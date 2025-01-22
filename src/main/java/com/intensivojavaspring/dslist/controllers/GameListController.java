package com.intensivojavaspring.dslist.controllers;

import com.intensivojavaspring.dslist.dto.GameListDTO;
import com.intensivojavaspring.dslist.services.GameListService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//necessário para configurar a classe como controlador da api rest
@RestController
@RequestMapping(value = "/lists") //mapeamento da URL que acessa este controlador
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @GetMapping //assinalando que requisições get chegarão aqui
    public List<GameListDTO> findAll(){
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }
}
