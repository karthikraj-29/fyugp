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
public class Programme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String programmeName;

    @Column(nullable = false, unique = true)
    private String programmeCode;
    private String programmeDescription;
    private String programmeDuration;
    private String programmeType;
    private String programmeMode;

    @ManyToMany(mappedBy = "programmes")
    private List<Department> departments;

}
