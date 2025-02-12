package com.tst.fyugp.service.college;

import com.tst.fyugp.model.Programme;
import org.springframework.http.ResponseEntity;

public interface ProgrammeService {

    public ResponseEntity<?> addProgramme(Programme programme);
    public  ResponseEntity<?>  updateProgramme(Long id);
    public  boolean  deleteProgramme(Long id);
    public  void getProgrammeByName(String name);
    public  ResponseEntity<?>  getAllProgramme();
    public  ResponseEntity<?>  getProgrammeByDepartment(String department);

}
