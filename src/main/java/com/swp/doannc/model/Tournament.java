package com.swp.doannc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Tournament")
public class Tournament {
    @Id
    private Long id;

    private String name;

    private String description;

    private String capacity;

    private String location;

    private Double minimumAge;

    private Double minimumWeight;

    //chua add fk vs ruleID
    private Long ruleId;

    @Column(nullable = false)
    private boolean isEnable;

}
