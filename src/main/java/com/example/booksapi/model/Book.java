package com.example.booksapi.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {
    @Id
private int uuid;
    private String name;

@OneToMany
private List<Commentaire> commentaires;




}

