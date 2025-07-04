package manipalcse.pdc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import manipalcse.pdc.security.JwtUtil;
import manipalcse.pdc.services.ProfileService;

@RestController
public class ProfileController {

    @Autowired private ProfileService profileService;
    @Autowired private JwtUtil jwtUtil;

    @GetMapping("/admin/{id}/profile")
    public ResponseEntity<?> getAdminProfile(@PathVariable Long id, Authentication authentication) {
        return ResponseEntity.ok(profileService.getAdminProfileById(id));
    }

    @GetMapping("/student/{id}/profile")
    public ResponseEntity<?> getStudentProfile(@PathVariable Long id, Authentication authentication) {
        return ResponseEntity.ok(profileService.getStudentProfileById(id));
    }

    @GetMapping("/faculty/{id}/profile")
    public ResponseEntity<?> getFacultyProfile(@PathVariable Long id, Authentication authentication) {
        return ResponseEntity.ok(profileService.getFacultyProfileById(id));
    }

    @GetMapping("/alumni/{id}/profile")
    public ResponseEntity<?> getAlumniProfile(@PathVariable Long id, Authentication authentication) {
        return ResponseEntity.ok(profileService.getAlumniProfileById(id));
    }

  
}