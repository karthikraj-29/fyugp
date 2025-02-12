package com.tst.fyugp.repository;

import com.tst.fyugp.model.StaffType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffTypeRepo  extends JpaRepository<StaffType, Long> {

}
