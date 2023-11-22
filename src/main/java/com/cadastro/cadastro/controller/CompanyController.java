package com.cadastro.cadastro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cadastro.cadastro.entities.Client;
import com.cadastro.cadastro.entities.Company;
import com.cadastro.cadastro.services.CompanyServices;

@RestController
@RequestMapping(value = "/users")
public class CompanyController {

    @Autowired
    private CompanyServices service;
    
    @GetMapping
    public ResponseEntity<List<Company>> findAll(){
        List<Company> list_companies = service.findAll();
        return ResponseEntity.ok().body(list_companies);
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Company> addCompany(@RequestBody Company company){
        service.addCompany(company);
        return ResponseEntity.ok().body(company);
    }

    @GetMapping(value = "/{id}/clients")
    public ResponseEntity<List<Client>> findAllClients(@PathVariable Long id){
        List<Client> list_clients = service.findAllClients(id);
        return ResponseEntity.ok().body(list_clients);
    }
}
