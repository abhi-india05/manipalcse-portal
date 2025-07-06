package manipalcse.pdc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import manipalcse.pdc.dto.AdminDto;
import manipalcse.pdc.dto.AlumniDto;
import manipalcse.pdc.dto.FacultyDto;
import manipalcse.pdc.dto.StudentDto;
import manipalcse.pdc.security.JwtUtil;
import manipalcse.pdc.services.UpdateProfileService;

@RestController
public class UpdateProfileController {

    @Autowired 
    private UpdateProfileService updateProfileService;
    
    @Autowired 
    private JwtUtil jwtUtil;

    @PutMapping("/admin/{id}/profile/update")
    @PreAuthorize("@jwtUtil.isAdmin(authentication, #id)")
    public ResponseEntity<?> updateAdminProfile(
            @PathVariable Long id, 
            @RequestBody AdminDto adminDto,
            Authentication authentication) {
        try {
            AdminDto updatedAdmin = updateProfileService.updateAdminProfile(id, adminDto);
            return ResponseEntity.ok(updatedAdmin);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/student/{id}/profile/update")
    @PreAuthorize("@jwtUtil.isStudent(authentication, #id)")
    public ResponseEntity<?> updateStudentProfile(
            @PathVariable Long id, 
            @RequestBody StudentDto studentDto,
            Authentication authentication) {
        try {
            StudentDto updatedStudent = updateProfileService.updateStudentProfile(id, studentDto);
            return ResponseEntity.ok(updatedStudent);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/faculty/{id}/profile/update")
    @PreAuthorize("@jwtUtil.isFaculty(authentication, #id)")
    public ResponseEntity<?> updateFacultyProfile(
            @PathVariable Long id, 
            @RequestBody FacultyDto facultyDto,
            Authentication authentication) {
        try {
            FacultyDto updatedFaculty = updateProfileService.updateFacultyProfile(id, facultyDto);
            return ResponseEntity.ok(updatedFaculty);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/alumni/{id}/profile/update")
    @PreAuthorize("@jwtUtil.isAlumni(authentication, #id)")
    public ResponseEntity<?> updateAlumniProfile(
            @PathVariable Long id, 
            @RequestBody AlumniDto alumniDto,
            Authentication authentication) {
        try {
            AlumniDto updatedAlumni = updateProfileService.updateAlumniProfile(id, alumniDto);
            return ResponseEntity.ok(updatedAlumni);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}