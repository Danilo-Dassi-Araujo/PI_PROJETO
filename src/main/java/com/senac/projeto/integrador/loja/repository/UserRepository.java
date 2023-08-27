package com.senac.projeto.integrador.loja.repository;

import com.senac.projeto.integrador.loja.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {
     User findByCpf(String cpf);
}
