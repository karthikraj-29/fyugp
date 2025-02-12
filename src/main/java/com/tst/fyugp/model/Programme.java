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
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private  Long id;
    private String programmeName;
    private String programmeCode;
    private String programmeDescription;
    private String programmeDuration;
    private String programmeType;
    private String programmeMode;
    @ManyToMany
    @JoinTable(
            name = "programme_department",
            joinColumns = @JoinColumn(name = "programme_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id"))
    private List<Department>  department; ;


}
