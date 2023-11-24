package com.cadastro.cadastro.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadastro.cadastro.entities.Client;
import com.cadastro.cadastro.entities.Company;
import com.cadastro.cadastro.repository.ClientRepository;
import com.cadastro.cadastro.repository.CompanyRepository;

@Service
public class ClientServices {

    @Autowired
    private ClientRepository repository;

    @Autowired
    private CompanyRepository companyRepository;

    public List<Client> findAll() {
        List<Client> list_clients = repository.findAll();
        return list_clients;
    }

    public Client findById(Long id) {
        Optional<Client> client = repository.findById(id);
        return client.get();
    }

    public Client addNewClient(Client client, Long id) {
        Optional<Company> currentCompany = companyRepository.findById(id);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        client.setDate(LocalDateTime.now().format(formatter));
        client.setCurrentCompany(currentCompany.get());
        repository.save(client);
        return client;
    }

    public Client changeClient(Long clientId, Client client) {
        Client currentClient = repository.getReferenceById(clientId);
        updateData(client, currentClient);
        return repository.save(currentClient);
    }

    private void updateData(Client client, Client currentClient) {
        if(client.getCompany() != ""){
            currentClient.setCompany(client.getCompany());
        }
        if(client.getName() != ""){
            currentClient.setName(client.getName());
        }
        if(client.getNumber() != ""){
            currentClient.setNumber(client.getNumber());
        }
        if(client.getComments() != ""){
            currentClient.setComments(client.getComments());
        } 
        if(client.getConsultant() != ""){
            currentClient.setConsultant(client.getConsultant());
        }
        if(client.getSituation() != ""){
            currentClient.setSituation(client.getSituation());
        }
    }

    public void deleteClient(Long id) {
        repository.deleteById(id);
    }
}
