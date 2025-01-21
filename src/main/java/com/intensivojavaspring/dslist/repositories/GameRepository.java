package com.intensivojavaspring.dslist.repositories;

import com.intensivojavaspring.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

//REPOSITORY É O OBJETO RESPONSÁVEL POR FAZER CONSULTAS AO BANCO DE DADOS
public interface GameRepository extends JpaRepository<Game, Long> {

}
