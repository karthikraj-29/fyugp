package com.tst.fyugp.controller.college;

import com.tst.fyugp.service.college.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    
    private final DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService){
        this.departmentService=departmentService;
    }
    
    @PostMapping
    public String hello(){
        return "h";
    }
    
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteById(@RequestBody Long id){

        if(departmentService.deleteById(id)){
            return  ResponseEntity.ok().body("Department deleted successfully");
        }
        return  ResponseEntity.notFound().build();
    }

}
