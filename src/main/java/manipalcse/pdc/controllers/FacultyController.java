package manipalcse.pdc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import manipalcse.pdc.dto.FacultyDetailsDto;
import manipalcse.pdc.services.FacultyService;

@RestController
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @GetMapping("/faculty/view")
    @PreAuthorize("permitAll()") 
    public ResponseEntity<List<FacultyDetailsDto>> getAllFaculty() {
        return ResponseEntity.ok(facultyService.getAllFacultyDetails());
    }
}