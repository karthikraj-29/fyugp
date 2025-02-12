package com.tst.fyugp.service.college.impl;

import com.tst.fyugp.repository.CourseRepo;
import com.tst.fyugp.service.college.CourseService;
import org.springframework.stereotype.Service;


@Service
public class CourseServiceImpl  implements CourseService {

    private final CourseRepo courseRepo;
    public CourseServiceImpl (CourseRepo courseRepo){
        this.courseRepo = courseRepo;
    }

    @Override
    public boolean deleteById(Long id) {
        if(courseRepo.existsById(id)){
            courseRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
