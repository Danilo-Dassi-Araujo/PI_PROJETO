package com.senac.projeto.integrador.loja.repository;

import com.senac.projeto.integrador.loja.model.Client;
import com.senac.projeto.integrador.loja.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, String>, JpaSpecificationExecutor<Client> {
}
