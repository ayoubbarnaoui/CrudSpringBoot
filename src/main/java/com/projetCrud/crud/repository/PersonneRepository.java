package com.projetCrud.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetCrud.crud.model.Personne;

@Repository
public interface PersonneRepository extends JpaRepository<Personne, Integer>{

}
