package edu.iu.c322.invoicingservice.controller;

import edu.iu.c322.invoicingservice.handler.InvalidOrderIdException;
import edu.iu.c322.invoicingservice.model.dto.*;
import edu.iu.c322.invoicingservice.model.entity.Invoice;
import edu.iu.c322.invoicingservice.model.entity.Item;
import edu.iu.c322.invoicingservice.model.entity.ItemStatus;
import edu.iu.c322.invoicingservice.model.entity.StatusUpdate;
import edu.iu.c322.invoicingservice.repository.InvoiceRepository;
import edu.iu.c322.invoicingservice.repository.InvoicesRepository;
import edu.iu.c322.invoicingservice.repository.ItemRepository;
import edu.iu.c322.invoicingservice.repository.ItemStatusRepository;
import jakarta.persistence.criteria.Order;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/invoices")
public class InvoicingController {

    private Invoice invoice  = new Invoice();

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    InvoicesRepository invoiceRepository;

    @Autowired
    ItemStatusRepository itemStatusRepository;
    /*
    @Autowired
    private InvoiceRepository repository;

     */

    // this is bad it is binding this class the customerRepository so instead we use spring dependency injection
    /*
    public CustomerController() {
        this.repository = new CustomerRepository();
    }
     */

    //this is dpeendency injection


    /*
    public InvoicingController(InvoiceRepository repository) {
        this.repository = repository;
    }

     */



    private final WebClient orderService;


    public InvoicingController(WebClient.Builder webClientBuilder) {
        orderService = webClientBuilder.baseUrl("http://localhost:8080").build();
    }

    public StructItemDto itemToStruct(OrderItemDto orderItemDto){
        StructItemDto structItemDto = new StructItemDto();
        structItemDto.setItem(orderItemDto.getName());
        structItemDto.setPrice(orderItemDto.getPrice());
        structItemDto.setId(0);
        return structItemDto;
    }


    public InvoiceDto convertOrderToInvoice(OrderDto orderDto, int orderId){

        InvoiceDto invoiceDto = new InvoiceDto();
        invoiceDto.setOrderPlaced(orderDto.getOrderDate());
        invoiceDto.setTotal(orderDto.getTotal());
        invoiceDto.setPaymentDto(orderDto.getPayment());

        // Map Order Items to Invoice Items

                    InvoiceItemDto invoiceItemDto = new InvoiceItemDto();


                    List<StructItemDto> structItemDtos = new ArrayList<>();

                    //loop and set Id's
                    for(int i = 0; i < orderDto.getItems().size(); i++){

                        structItemDtos.add(itemToStruct(orderDto.getItems().get(i)));

                        String name = orderDto.getItems().get(i).getName();
                        System.out.println(name);
                        Item itemy = itemRepository.findByName(name);
                        if (itemy != null) {
                            structItemDtos.get(i).setId(itemy.getId());

                            ItemStatus itemStatus = new ItemStatus();
                            itemStatus.setStatus(invoiceItemDto.getStatus());
                            itemStatus.setOrderId(orderId);
                            itemStatus.setItemId(itemy.getId());
                            itemStatus.setDate(invoiceItemDto.getOn());

                            itemStatusRepository.save(itemStatus);

                        } else {
                            invoiceItemDto.getItems().get(i).setId(i);
                        }
                    }
                    invoiceItemDto.setStatus("shipping now");
                    invoiceItemDto.setOn("4/12/2023");
                    invoiceItemDto.setShippingDto(orderDto.getShippingAddress());
                    // Set other fields if needed
        invoiceItemDto.setItems(structItemDtos);
        invoiceDto.setInvoiceItemDto(invoiceItemDto);

        invoiceToToStorage(invoiceItemDto, orderId);




        return invoiceDto;
    }

    public void invoiceToToStorage(InvoiceItemDto invoiceDto, int orderId){
        invoice.setInvoiceCreationDate(invoiceDto.getOn());
        invoice.setStatus(invoiceDto.getStatus());
        invoice.setOrderId(orderId);

        invoiceRepository.save(invoice);
    }



    @ExceptionHandler(InvalidOrderIdException.class)
    public ResponseEntity<Object> handleInvalidOrderIdException(InvalidOrderIdException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.NOT_FOUND.value());
        body.put("error", ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }




    @GetMapping("/{orderId}")
    public Mono<ResponseEntity<InvoiceDto>> findByOrderId(@PathVariable int orderId) {


        return orderService.get().uri("/orders/order/{orderId}", orderId)
                .retrieve()
                .onStatus(status -> status.is4xxClientError(),
                        response -> {
                            if (response.statusCode() == HttpStatus.NOT_FOUND) {
                                return Mono.error(new InvalidOrderIdException("Invalid orderId: " + orderId));
                            } else {
                                return Mono.error(new ResponseStatusException(response.statusCode()));
                            }
                        })
                .bodyToMono(OrderDto.class)
                .flatMap(orderDto -> {
                    InvoiceDto invoiceDto = convertOrderToInvoice(orderDto, orderId);
                    return Mono.just(ResponseEntity.ok(invoiceDto));
                });
    }






    //@valid tells spring to ensure validations are checked, our validation is currently in the customer class

    /*
    @PostMapping
    public int create(@Valid @RequestBody Invoice invoice){
        return repository.create(invoice);
    }


    //we just need the orderPlaces, status, and on in a new invoice table with a foreign key to the order table


    // PUT lcoalhost:8080.customers/2
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody StatusUpdate update, @PathVariable int id){
        repository.update(update, id);
    }



     */


}