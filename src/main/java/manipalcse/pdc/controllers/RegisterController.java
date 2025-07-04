package manipalcse.pdc.controllers;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import manipalcse.pdc.dto.AdminDto;
import manipalcse.pdc.dto.AlumniDto;
import manipalcse.pdc.dto.FacultyDto;
import manipalcse.pdc.dto.StudentDto;
import manipalcse.pdc.services.RegisterService;

@RestController
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    private static final Pattern MOBILE_PATTERN = Pattern.compile("^[6-9]\\d{9}$");

    @PostMapping("/register/admin")
    public ResponseEntity<?> registerAdmin(@RequestBody AdminDto adminDto) {
        try {
            validateAdminDto(adminDto);
            return ResponseEntity.ok(registerService.registerAdmin(adminDto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/register/student")
    public ResponseEntity<?> registerStudent(@RequestBody StudentDto studentDto) {
        try {
            validateStudentDto(studentDto);
            return ResponseEntity.ok(registerService.registerStudent(studentDto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/register/faculty")
    public ResponseEntity<?> registerFaculty(@RequestBody FacultyDto facultyDto) {
        try {
            validateFacultyDto(facultyDto);
            return ResponseEntity.ok(registerService.registerFaculty(facultyDto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/register/alumni")
    public ResponseEntity<?> registerAlumni(@RequestBody AlumniDto alumniDto) {
        try {
            validateAlumniDto(alumniDto);
            return ResponseEntity.ok(registerService.registerAlumni(alumniDto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    private void validateAdminDto(AdminDto dto) {
        if (dto.getEmail() == null || !EMAIL_PATTERN.matcher(dto.getEmail()).matches())
            throw new IllegalArgumentException("Invalid or missing email");
        if (dto.getMobileNumber() == null || !MOBILE_PATTERN.matcher(dto.getMobileNumber()).matches())
            throw new IllegalArgumentException("Invalid or missing mobile number");
        if (dto.getFirstName() == null || dto.getFirstName().isBlank())
            throw new IllegalArgumentException("First name is required");
        if (dto.getLastName() == null || dto.getLastName().isBlank())
            throw new IllegalArgumentException("Last name is required");
        if (dto.getPassword() == null || dto.getPassword().isBlank())
            throw new IllegalArgumentException("Password is required");
    }

    private void validateStudentDto(StudentDto dto) {
        if (dto.getEmail() == null || !EMAIL_PATTERN.matcher(dto.getEmail()).matches())
            throw new IllegalArgumentException("Invalid or missing email");
        if (dto.getMobileNumber() == null || !MOBILE_PATTERN.matcher(dto.getMobileNumber()).matches())
            throw new IllegalArgumentException("Invalid or missing mobile number");
        if (dto.getName() == null || dto.getName().isBlank())
            throw new IllegalArgumentException("Name is required");
        if (dto.getPassword() == null || dto.getPassword().isBlank())
            throw new IllegalArgumentException("Password is required");
    }

    private void validateFacultyDto(FacultyDto dto) {
        if (dto.getEmail() == null || !EMAIL_PATTERN.matcher(dto.getEmail()).matches())
            throw new IllegalArgumentException("Invalid or missing email");
        if (dto.getMobileNumber() == null || !MOBILE_PATTERN.matcher(dto.getMobileNumber()).matches())
            throw new IllegalArgumentException("Invalid or missing mobile number");
        if (dto.getFirstName() == null || dto.getFirstName().isBlank())
            throw new IllegalArgumentException("First name is required");
        if (dto.getLastName() == null || dto.getLastName().isBlank())
            throw new IllegalArgumentException("Last name is required");
        if (dto.getPassword() == null || dto.getPassword().isBlank())
            throw new IllegalArgumentException("Password is required");
    }

    private void validateAlumniDto(AlumniDto dto) {
        if (dto.getEmail() == null || !EMAIL_PATTERN.matcher(dto.getEmail()).matches())
            throw new IllegalArgumentException("Invalid or missing email");
        if (dto.getMobileNumber() == null || !MOBILE_PATTERN.matcher(dto.getMobileNumber()).matches())
            throw new IllegalArgumentException("Invalid or missing mobile number");
        if (dto.getFirstName() == null || dto.getFirstName().isBlank())
            throw new IllegalArgumentException("First name is required");
        if (dto.getLastName() == null || dto.getLastName().isBlank())
            throw new IllegalArgumentException("Last name is required");
        if (dto.getPassword() == null || dto.getPassword().isBlank())
            throw new IllegalArgumentException("Password is required");
    }
}