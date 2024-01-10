package com.example.interior.model.user;

import com.example.interior.model.image.Image;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 30, unique = true)
    private String username;
    private String password;
    private String role; // USER, ADMIN

    @OneToMany(mappedBy = "user")
    private List<Image> images;



    @CreationTimestamp
    private Timestamp createDate;
}
