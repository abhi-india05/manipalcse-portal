package manipalcse.pdc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import manipalcse.pdc.dto.AdminDto;
import manipalcse.pdc.dto.AlumniDto;
import manipalcse.pdc.dto.FacultyDto;
import manipalcse.pdc.dto.StudentDto;
import manipalcse.pdc.security.JwtUtil;
import manipalcse.pdc.services.ProfileService;

@RestController
public class ProfileController {

    @Autowired private ProfileService profileService;
    @Autowired private JwtUtil jwtUtil;


    @GetMapping("/admin/{id}/profile")
    @PreAuthorize("hasRole('ADMIN') and #id == authentication.principal.id")
    public ResponseEntity<?> getAdminProfile(@PathVariable Long id, Authentication authentication) {
        try {
            AdminDto dto = profileService.getAdminProfileById(id);
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/student/{id}/profile")
    @PreAuthorize("hasRole('STUDENT') and #id == authentication.principal.id")
    public ResponseEntity<?> getStudentProfile(@PathVariable Long id, Authentication authentication) {
        try {
            StudentDto dto = profileService.getStudentProfileById(id);
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/faculty/{id}/profile")
    @PreAuthorize("hasRole('FACULTY') and #id == authentication.principal.id")
    public ResponseEntity<?> getFacultyProfile(@PathVariable Long id, Authentication authentication) {
        try {
            FacultyDto dto = profileService.getFacultyProfileById(id);
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/alumni/{id}/profile")
    @PreAuthorize("hasRole('ALUMNI') and #id == authentication.principal.id")
    public ResponseEntity<?> getAlumniProfile(@PathVariable Long id, Authentication authentication) {
        try {
            AlumniDto dto = profileService.getAlumniProfileById(id);
            
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

   
    }
