package com.tcc.master.repository;

import com.tcc.master.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByEmail(String email);
    void deleteByName(String name);
}
