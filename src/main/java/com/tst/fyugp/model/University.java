package com.tst.fyugp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String universityName;
    @Column(nullable = false, unique = true)
    private String universityCode;
    private String universityDescription;
    private String universityLocation;
    private String universityEmail;
    private String universityPhone;
    private String universityWebsite;
    @OneToMany(mappedBy = "university", cascade = CascadeType.ALL)
    private List<College> colleges;

}