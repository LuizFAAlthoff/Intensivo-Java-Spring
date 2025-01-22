package com.intensivojavaspring.dslist.services;

import com.intensivojavaspring.dslist.dto.GameListDTO;
import com.intensivojavaspring.dslist.entities.GameList;
import com.intensivojavaspring.dslist.repositories.GameListRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//marcação para registar um componente no sistema
//esse service irá pegar entidades do repository e devolver DTO's para a interface de API
@Component
public class GameListService {
    //injetando um componente repository no meu componente service
    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }
}
