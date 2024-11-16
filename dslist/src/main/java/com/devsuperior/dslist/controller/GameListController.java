package com.devsuperior.dslist.controller;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.service.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
    @Autowired
    private GameListService gameListServiceService;

    @GetMapping
    private List<GameListDTO> findAll(){
        return gameListServiceService.findAll();
    }


}
