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
@Table(name = "BirdRound")
public class BirdRound {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //chua add annotation fk birdId
    private Long birdId;

    //chua add annotation fk roundId
    private Long roundId;

    @Column(nullable = false)
    private boolean status;

    @Column(nullable = false)
    private boolean isEnable;

    @Column(nullable = false)
    private boolean isKick;

}
