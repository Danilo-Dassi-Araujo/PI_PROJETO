package com.senac.projeto.integrador.loja.repository;

import com.senac.projeto.integrador.loja.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<Session, Integer> {
    Session findFirstByOrderByIdDesc();
}
