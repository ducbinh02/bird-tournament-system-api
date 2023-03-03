package com.swp.doannc.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Score")
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int form;

    private int posture;

    private int voice;

    //chua add annotation fk
    private Long examinerId;

    //chua add annotation fk
    private Long refId;

    @Column(nullable = false)
    private boolean isEnable;

}
