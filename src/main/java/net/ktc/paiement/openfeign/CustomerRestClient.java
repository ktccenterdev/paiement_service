package net.ktc.paiement.openfeign;


import net.ktc.paiement.entities.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping(path = "/api/customer/{id}")
    Customer getCustomer(@PathVariable(name = "id") String id);
    @GetMapping(path = "/api/customer")
    List<Customer> allCustomers();
}
