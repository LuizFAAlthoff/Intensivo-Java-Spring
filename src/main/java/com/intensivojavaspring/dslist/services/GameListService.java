package com.intensivojavaspring.dslist.services;

import com.intensivojavaspring.dslist.dto.GameListDTO;
import com.intensivojavaspring.dslist.entities.GameList;
import com.intensivojavaspring.dslist.projections.GameMinProjection;
import com.intensivojavaspring.dslist.repositories.GameListRepository;

import com.intensivojavaspring.dslist.repositories.GameRepository;
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

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }
    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        List <GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i); //"atualize a posição de um objeto nesta lista, com esse elemento da lista, com esta nova posição

        }
    }
}
