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
public class Department {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String departmentName;
    private String departmentCode;
    @ManyToMany
    private List<Course> course;
    @ManyToMany
    private List<Staff> staff;
    @ManyToMany
    private List<StudentProfile> student;
    @ManyToMany
    private List<Programme> programme;

}
