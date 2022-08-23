package com.esther.DesafioSpring.repository;


import com.esther.DesafioSpring.model.Inicial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface InicialRepository extends JpaRepository<Inicial, Long> {

    List<Inicial> findAll();

    @Query(value = "SELECT * FROM INICIAL", nativeQuery = true)
    List<Inicial> getAll();

    Inicial getById(Long Id);

    Inicial findByEmailAndPassword(String email, String password);


}
