package com.test.springbootjpa.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Talaba {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String ism;

    @Column(nullable = false)
    private String familya;

    @Column(nullable = false)
    private String tugilgan_kun;

    @Column(nullable = false, unique = true)
    private String telefon;
}