package com.devsuperior.dslist.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_game_list")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

public class GameList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
