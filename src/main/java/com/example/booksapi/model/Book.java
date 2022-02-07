package com.example.booksapi.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    @Id
private Long uuid;
    @Column(name = "name")
    private String name;
@OneToMany
@Column(name = "commentaires")

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

