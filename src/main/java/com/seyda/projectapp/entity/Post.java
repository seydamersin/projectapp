package com.seyda.projectapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "post")
@Data
public class Post {
    @Id
    Long id;
    @ManyToOne(fetch = FetchType.LAZY)//
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)// bir user silindiğinde bütün postları silinsin
    @JsonIgnore // serilization da sorun çıkmasın
    User user;

    String title;
    @Lob
    @Column(columnDefinition = "text")
    String text;

}
