package com.tst.fyugp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class StaffType {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String staffType;
    @ManyToMany
    @JoinTable(
            name = "staff_staffType",
            joinColumns = @JoinColumn(name = "staffType_id"),
            inverseJoinColumns = @JoinColumn(name = "staff_id"))
    private List<Staff> staff;


}
