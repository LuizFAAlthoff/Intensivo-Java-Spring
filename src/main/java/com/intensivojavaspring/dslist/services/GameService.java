package com.intensivojavaspring.dslist.services;

import com.intensivojavaspring.dslist.dto.GameDTO;
import com.intensivojavaspring.dslist.dto.GameMinDTO;
import com.intensivojavaspring.dslist.entities.Game;
import com.intensivojavaspring.dslist.projections.GameMinProjection;
import com.intensivojavaspring.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//marcação para registar um componente no sistema
//esse service irá pegar entidades do repository e devolver DTO's para a interface de API
@Component
public class GameService {
    //injetando um componente repository no meu componente service
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long gameId) {
        Game result = gameRepository.findById(gameId).get(); //ideia de melhoria: adicionar tratamento de erro no findById
        GameDTO gameDTO = new GameDTO(result);
        return gameDTO;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll(); //consulta do JPA que faz uma consulta no banco e retorna todos os registros de games em uma lista
        //stream irá mexer com uma sequência de dados, e map irá transformar objetos de uma coisa para outra
        //Todos os objetos x originalmente Game, irão se transformar num DTO, passando X como argumento e finalizando transformando numa lista
        List<GameMinDTO> resultDto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return resultDto;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }
}
