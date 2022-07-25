package ru.netology.domain;

import lombok.*;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Player {
    private int id;
    private String name;
    private int strength;
}

