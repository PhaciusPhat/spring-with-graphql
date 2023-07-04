package com.example.graphQL.entity;

import lombok.*;

import java.util.UUID;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private UUID id;
    private String email;
    private String urlImage;
    private String firstName;
    private String lastName;
}
