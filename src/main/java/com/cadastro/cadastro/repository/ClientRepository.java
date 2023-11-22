package com.cadastro.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadastro.cadastro.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
    Client findByName(String name);
}
