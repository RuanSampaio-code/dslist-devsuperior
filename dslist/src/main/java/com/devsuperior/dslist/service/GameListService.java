package com.devsuperior.dslist.service;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repository.GameListRepository;
import com.devsuperior.dslist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result =  gameListRepository.findAll();
        List<GameListDTO> dto = result.stream().map(g -> new GameListDTO(g)).toList();
        return dto;
    }


    @Transactional
    public void move(Long listId, int souceIndex,  int destinationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection obj = list.remove(souceIndex);
        list.add(destinationIndex, obj);

        int min = souceIndex < destinationIndex ? souceIndex : destinationIndex;
        int max = souceIndex < destinationIndex ? destinationIndex : souceIndex;

        for(int i = min; i <= max; i++){
            gameListRepository.updateBelongingPosition(listId,list.get(i).getId(), i);
        }
    }

}
