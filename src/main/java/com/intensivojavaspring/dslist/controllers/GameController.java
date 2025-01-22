package com.intensivojavaspring.dslist.controllers;

import com.intensivojavaspring.dslist.dto.GameDTO;
import com.intensivojavaspring.dslist.dto.GameMinDTO;
import com.intensivojavaspring.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//necessário para configurar a classe como controlador da api rest
@RestController
@RequestMapping(value = "/games") //mapeamento da URL que acessa este controlador
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable Long id) {
        GameDTO resultDto = gameService.findById(id);
        return resultDto;
    }

    @GetMapping //assinalando que requisições get chegarão aqui
    public List<GameMinDTO> findAll(){
        List<GameMinDTO> resultDto = gameService.findAll();
        return resultDto;
    }
}
