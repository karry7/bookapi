package com.example.booksapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Commentaire {
    @Id
    private Long id;
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Commentaire{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }
}
