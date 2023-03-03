package com.swp.doannc.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddBirdPointRequest {

    private int form;

    private int posture;

    private int voice;

    private Long examinerId;

    private Long refId;
}
