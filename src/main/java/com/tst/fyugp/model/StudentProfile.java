package com.tst.fyugp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentProfile {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String registrationNumber;
    private String firstName;
    private String lastName;
    @ManyToOne
    private User user;
    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course>  course;

    @ManyToMany
    private List<Enrollment> enrollment;
    @ManyToMany
    private List<Department> department;
    @ManyToMany
    private List<Programme> programme;


}
