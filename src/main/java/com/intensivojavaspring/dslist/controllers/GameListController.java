package com.intensivojavaspring.dslist.controllers;

import com.intensivojavaspring.dslist.dto.GameListDTO;
import com.intensivojavaspring.dslist.dto.GameMinDTO;
import com.intensivojavaspring.dslist.dto.ReplacementDTO;
import com.intensivojavaspring.dslist.services.GameListService;
import com.intensivojavaspring.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

//necessário para configurar a classe como controlador da api rest
@RestController
@RequestMapping(value = "/lists") //mapeamento da URL que acessa este controlador
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll(){
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId){
        List<GameMinDTO> resultDto = gameService.findByList(listId);
        return resultDto;
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body){
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}
