package com.kcsitglobal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/Customers")
public class CustomerController<Customers> {
	 @Autowired
	    private CustomerService customerService;

	    @Autowired
	    private RestTemplate restTemplate;

	    @GetMapping("/{userId}")
	    public Customers getCustomers(@PathVariable("userId") Long userId) {

	        Customers user = this.customerService.getCustomers(userId);
	        //http://localhost:9002/contact/user/1311

	        List contacts = this.restTemplate.getForObject("http://contact-service/contact/user/" + user.getUserId(), List.class);


	        user.setContacts(contacts);
	        return user;

	    }

	}

}
