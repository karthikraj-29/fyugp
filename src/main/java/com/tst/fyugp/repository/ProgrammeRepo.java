package com.tst.fyugp.repository;

import com.tst.fyugp.model.Programme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProgrammeRepo  extends JpaRepository<Programme, Long> {
    Optional<Programme> findByDepartment(String department);


}
