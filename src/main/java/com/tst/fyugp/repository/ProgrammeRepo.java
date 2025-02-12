package com.tst.fyugp.repository;

import com.tst.fyugp.model.Programme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgrammeRepo  extends JpaRepository<Programme, Long> {
    Programme findByName(String name);
    Programme findByDepartment(String department);

}
