package com.cadastro.cadastro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadastro.cadastro.entities.Client;
import com.cadastro.cadastro.entities.Company;
import com.cadastro.cadastro.exceptions.AlreadyExistsCompany;
import com.cadastro.cadastro.repository.CompanyRepository;

@Service
public class CompanyServices {

    @Autowired
    private CompanyRepository repository;

    public List<Company> findAll() {
        return repository.findAll();
    }

    public void addCompany(Company company) {
        if(repository.findByName(company.getName()) == null){
            repository.save(company);
        }else{
            throw new AlreadyExistsCompany("Usuário já existe");
        }
    }

    public List<Client> findAllClients(Long id) {
        Optional<Company> company = repository.findById(id);
        List<Client> list_clients = company.get().getList_clients();
        return list_clients;
    }
}
