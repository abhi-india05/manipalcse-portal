
package manipalcse.pdc.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manipalcse.pdc.dto.LoginResponse;
import manipalcse.pdc.entity.Admin;
import manipalcse.pdc.entity.Alumni;
import manipalcse.pdc.entity.Faculty;
import manipalcse.pdc.entity.Student;
import manipalcse.pdc.repository.AdminRepo;
import manipalcse.pdc.repository.AlumniRepo;
import manipalcse.pdc.repository.FacultyRepo;
import manipalcse.pdc.repository.StudentRepo;
import manipalcse.pdc.security.JwtUtil;


@Service
public class LoginService {

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private AlumniRepo alumniRepo;

    @Autowired
    private FacultyRepo facultyRepo;

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private JwtUtil jwtUtil;

    public LoginResponse login(String email, String password) {
        Admin admin = adminRepo.findByEmail(email).orElse(null);
        Alumni alumni = alumniRepo.findByEmail(email).orElse(null);
        Faculty faculty = facultyRepo.findByEmail(email).orElse(null);
        Student student = studentRepo.findByEmail(email).orElse(null);

        if (admin != null) {
            if (!passwordEncoder.matches(password, admin.getPassword())) {
                throw new RuntimeException("Invalid password");
            }

            String Id = admin.getId();
            List<String> roles = Collections.singletonList("ADMIN");
            String jwtToken = jwtUtil.generateJwtToken(Id, roles);

            return new LoginResponse(jwtToken, Id, roles);
        } else if (alumni != null) {
            if (!passwordEncoder.matches(password, alumni.getPassword())) {
                throw new RuntimeException("Invalid password");
            }

            String Id = alumni.getId();
            List<String> roles = Collections.singletonList("ALUMNI");
            String jwtToken = jwtUtil.generateJwtToken(Id, roles);

            return new LoginResponse(jwtToken, Id, roles);
        } else if (faculty != null) {
            if (!passwordEncoder.matches(password, faculty.getPassword())) {
                throw new RuntimeException("Invalid password");
            }

            String Id = faculty.getId();
            List<String> roles = Collections.singletonList("FACULTY");
            String jwtToken = jwtUtil.generateJwtToken(Id, roles);

            return new LoginResponse(jwtToken, Id, roles);
        } else if (student != null) {
            if (!passwordEncoder.matches(password, student.getPassword())) {
                throw new RuntimeException("Invalid password");
            }

            String Id = student.getId();
            List<String> roles = Collections.singletonList("STUDENT");
            String jwtToken = jwtUtil.generateJwtToken(Id, roles);

            return new LoginResponse(jwtToken, Id, roles);
        } else {
            throw new RuntimeException("User not found");
        }
    }
}