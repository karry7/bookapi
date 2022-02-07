package com.example.booksapi.model;

import javax.persistence.Id;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Book {
    @Id
private Long uuid;
private String name;
private List<String> commentaires = new ArrayList<>();



    @Override
    public String toString() {
        return "Book{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", commentaires=" + commentaires +
                '}';
    }


    public Long getUuid() {
        return uuid;
    }
    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCommentaires(List<String> commentaires) {
        this.commentaires = commentaires;
    }


    public List<String> getCommentaires() {
        return commentaires;
    }
}

