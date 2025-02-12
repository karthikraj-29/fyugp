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
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String universityName;
    private String universityCode;
    private String universityDescription;
    private String universityLocation;
    private String universityEmail;
    private String universityPhone;
    private String universityWebsite;
    @OneToMany
    private List<College>  college;
}
