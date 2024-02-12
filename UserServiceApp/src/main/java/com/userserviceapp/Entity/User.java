package com.userserviceapp.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user_datails")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(name = "NAME" ,length = 20)
    private String name;
    private String about;
    private String email;

    //Jpa will ignore the field annotated with @Transient and does not save it to database
    @Transient
    private List<Rating> rating=new ArrayList<>();
}
