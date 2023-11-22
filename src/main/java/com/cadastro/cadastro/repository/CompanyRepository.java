package com.cadastro.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadastro.cadastro.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>{
    Company findByName(String name);
}
