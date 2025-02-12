package com.tst.fyugp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class College {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String collegeName;
    private String collegeCode;
    private String collegeDescription;
    private String collegeLocation;
    private String collegeEmail;
    private String collegePhone;
    private String collegeWebsite;
    @ManyToOne
    private University university;

}
