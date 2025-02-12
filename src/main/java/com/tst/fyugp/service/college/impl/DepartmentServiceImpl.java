package com.tst.fyugp.service.college.impl;

import com.tst.fyugp.repository.DepartmentRepo;
import com.tst.fyugp.service.college.DepartmentService;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepo departmentRepo;

    public DepartmentServiceImpl(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }
    @Override
    public boolean deleteById(Long id) {

        if(departmentRepo.existsById(id)){
            departmentRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
