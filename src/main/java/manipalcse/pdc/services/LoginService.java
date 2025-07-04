package manipalcse.pdc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import manipalcse.pdc.dto.LoginResponse;
import manipalcse.pdc.entity.Admin;
import manipalcse.pdc.entity.Alumni;
import manipalcse.pdc.entity.Faculty;
import manipalcse.pdc.entity.Privilege;
import manipalcse.pdc.entity.Role;
import manipalcse.pdc.entity.Student;
import manipalcse.pdc.repository.AdminRepo;
import manipalcse.pdc.repository.AlumniRepo;
import manipalcse.pdc.repository.FacultyRepo;
import manipalcse.pdc.repository.StudentRepo;
import manipalcse.pdc.security.JwtUtil;

public class LoginService {
    
    @Autowired
    private AdminRepo adminRepo;
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private FacultyRepo facultyRepo;
    @Autowired
    private AlumniRepo alumniRepo;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public LoginResponse login(String email, String password) {
        // Try Admin
        Admin admin = adminRepo.findByEmail(email);
        if (admin != null && passwordEncoder.matches(password, admin.getPassword())) {
            return buildResponse(admin.getEmail(), "ADMIN", admin.getRoles());
        }
        // Try Student
        Student student = studentRepo.findByEmail(email);
        if (student != null && passwordEncoder.matches(password, student.getPassword())) {
            return buildResponse(student.getEmail(), "STUDENT", student.getRoles());
        }
        // Try Faculty
        Faculty faculty = facultyRepo.findByEmail(email);
        if (faculty != null && passwordEncoder.matches(password, faculty.getPassword())) {
            return buildResponse(faculty.getEmail(), "FACULTY", faculty.getRoles());
        }
        // Try Alumni
        Alumni alumni = alumniRepo.findByEmail(email);
        if (alumni != null && passwordEncoder.matches(password, alumni.getPassword())) {
            return buildResponse(alumni.getEmail(), "ALUMNI", alumni.getRoles());
        }
        throw new RuntimeException("Invalid email or password");
    }

    private LoginResponse buildResponse(String email, String role, List<Role> roles) {
        LoginResponse response = new LoginResponse();
        response.setEmail(email);
        response.setRole(role);
        response.setPrivileges(roles.stream()
            .flatMap(r -> r.getPrivileges().stream())
            .map(Privilege::getName)
            .distinct()
            .toList());
        response.setToken(jwtUtil.generateJwtToken(email, List.of(role)));
        return response;
    }
}
