package com.esther.DesafioSpring.repository;


import com.esther.DesafioSpring.model.Inicial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface InicialRepository extends JpaRepository<Inicial, Long> {

    List<Inicial> findAll();

    Inicial getById(Long Id);

    Inicial findByEmailAndPassword(String email, String password);

    Optional<Inicial> findByEmail(String email);


}
