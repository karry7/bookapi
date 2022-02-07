package com.example.booksapi.model;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Book {
    @Id
private Long uuid;
private String name;
@OneToMany
private List<Commentaire> commentaires;

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

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


}

