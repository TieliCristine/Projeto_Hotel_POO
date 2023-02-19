package com.projeto.hotel.service;

import com.projeto.hotel.model.entity.Customer;
import com.projeto.hotel.model.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer save(Customer customerForm) {
        return customerRepository.save(customerForm);
    }

    public List<Customer> list() {
        return customerRepository.findAll();
    }

    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    //    public Customer findByCpf(String cpf){
//        return customerRepository.findByCpf(cpf).orElse(null);
//    }

//    public Customer findByCpf(String cpf) {
//        return customerRepository.findByCpf(cpf)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário não encontrado"));
//    }

    public Customer update(Customer customer) {
        Customer recordFound = customerRepository.findById(customer.getId()).orElse(null);
        recordFound.setCpf(customer.getCpf());
        recordFound.setName(customer.getName());
        recordFound.setBirthdate(customer.getBirthdate());
        recordFound.setGender(customer.getGender());
        recordFound.setMobile(customer.getMobile());
//        existingCustomer.setAddress(customer.getAddress());
//        existingCustomer.setAccess(customer.getAccess());
        return customerRepository.save(recordFound);

    }

}