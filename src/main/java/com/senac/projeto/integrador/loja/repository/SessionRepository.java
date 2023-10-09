package com.senac.projeto.integrador.loja.repository;

import com.senac.projeto.integrador.loja.model.SessionClientStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<SessionClientStore, Integer> {
    SessionClientStore findFirstByOrderByIdDesc();
}
