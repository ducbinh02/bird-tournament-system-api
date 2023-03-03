package com.swp.doannc.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Bird")
public class Bird {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    //Chua tao moi quan he voi UserID
    private Long ownerId;

    private int age;


    private String type;

    private float weight;

    private boolean gender;

    private String avatarUrl;

    @Column(nullable = false)
    private boolean isEnable;

}