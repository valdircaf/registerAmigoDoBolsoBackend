package com.cadastro.cadastro.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cadastro.cadastro.entities.Client;
import com.cadastro.cadastro.services.ClientServices;

@RestController
@RequestMapping(value = "/clients")
public class ClientController implements Serializable{

    @Autowired
    private ClientServices service;

    @GetMapping
    public ResponseEntity<List<Client>> findAll(){
        List<Client> list_clients = service.findAll();
        return ResponseEntity.ok().body(list_clients);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id){
        Client client = service.findById(id);
        return ResponseEntity.ok().body(client);
    }

    @PostMapping(value = "/{id}")
    @CrossOrigin
    public ResponseEntity<Client> addNewClient(@RequestBody Client client, @PathVariable Long id){
        Client newClient = service.addNewClient(client, id);
        return ResponseEntity.ok().body(newClient);
    }

    @CrossOrigin
    @PutMapping(value = "/{clientId}")
    public ResponseEntity<Client> changeClient(@PathVariable Long clientId, @RequestBody Client client){
        Client currentClient = service.changeClient(clientId , client);
        return ResponseEntity.ok().body(currentClient);
    }

    @DeleteMapping(value = "/delete/{id}")
    @CrossOrigin
    public ResponseEntity<Void> deleteClient(@PathVariable Long id){
        service.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}
