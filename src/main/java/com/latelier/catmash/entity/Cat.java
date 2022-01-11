package com.latelier.catmash.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long catId;
    @Column(nullable = false)
    private String imageUrl;
    @Column(nullable = false, unique = true)
    private String imageId;
    @Column(columnDefinition = "integer default 0")
    private Integer score;
}
