package com.swp.doannc.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Round")
public class Round {
    @Id
    private Long id;

    private String name;

    //chua add annotation fk TournamentId
    private Long tournamentId;


    private Date datetime;

    private String capacity;

    @Column(nullable = false)
    private boolean isEnable;

}
