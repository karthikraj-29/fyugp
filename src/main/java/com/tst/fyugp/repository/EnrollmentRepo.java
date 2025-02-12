package com.tst.fyugp.repository;

import com.tst.fyugp.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepo  extends JpaRepository<Enrollment, Long> {
}
