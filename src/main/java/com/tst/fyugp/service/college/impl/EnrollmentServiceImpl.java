package com.tst.fyugp.service.college.impl;

import com.tst.fyugp.repository.EnrollmentRepo;
import com.tst.fyugp.service.college.EnrollmentService;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepo courseEnrollmentRepo;
    public EnrollmentServiceImpl(EnrollmentRepo courseEnrollmentRepo) {
        this.courseEnrollmentRepo = courseEnrollmentRepo;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
