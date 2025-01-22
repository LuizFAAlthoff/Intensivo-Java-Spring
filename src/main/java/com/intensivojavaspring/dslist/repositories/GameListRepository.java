package com.intensivojavaspring.dslist.repositories;

import com.intensivojavaspring.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
