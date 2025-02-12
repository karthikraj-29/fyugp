package com.tst.fyugp.service.college.impl;

import com.tst.fyugp.model.Programme;
import com.tst.fyugp.repository.ProgrammeRepo;
import com.tst.fyugp.service.college.ProgrammeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProgrammeServiceImpl  implements ProgrammeService {

    private final ProgrammeRepo programmeRepo;
    public ProgrammeServiceImpl(ProgrammeRepo programmeRepo) {
        this.programmeRepo = programmeRepo;
    }
    @Override
    public ResponseEntity<?> addProgramme(Programme programme) {
        return ResponseEntity.ok().body(programmeRepo.save(programme));
    }

    @Override
    public ResponseEntity<?> updateProgramme(Long id) {
    return null;
        }

    @Override
    public boolean deleteProgramme(Long id) {
        if(programmeRepo.existsById(id)){
            programmeRepo.deleteById(id);
            return  true;
        }
        return false;
    }

    @Override
    public void getProgrammeByName( String name) {

    }

    @Override
    public ResponseEntity<?> getAllProgramme() {
        return  ResponseEntity.ok().body(programmeRepo.findAll());
    }

    @Override
    public ResponseEntity<?> getProgrammeByDepartment(String department) {
        return ResponseEntity.ok().body(programmeRepo.findByDepartment(department));
    }
}
