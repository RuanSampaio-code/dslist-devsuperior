package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.GameList;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class GameListDTO {

    private Long id;
    private String name;

    public GameListDTO(GameList entity) {
       id = entity.getId();
       name = entity.getName();
    }


}
