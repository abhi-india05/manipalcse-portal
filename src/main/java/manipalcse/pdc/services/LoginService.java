
package manipalcse.pdc.services;

import org.springframework.stereotype.Service;


@Service
public class LoginService {
/* 
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

     @Autowired
    private PasswordEncoder passwordEncoder;  

    public LoginResponse login(String email, String password) {
        Admin admin = adminRepo.findByEmail(email).orElse(null);
        Alumni alumni = alumniRepo.findByEmail(email).orElse(null);
        Faculty faculty = facultyRepo.findByEmail(email).orElse(null);
        Student student = studentRepo.findByEmail(email).orElse(null);

        if (admin != null) {
            if (!passwordEncoder.matches(password, admin.getPassword())) {
                throw new RuntimeException("Invalid password");
            }

            Long Id = admin.getId();
            List<String> roles=Collections.singletonList("ROLE_ADMIN");
            String jwtToken = jwtUtil.generateJwtToken(Id, roles);

            return new LoginResponse(jwtToken, Id, roles);
        } else if (alumni != null) {
            if (!passwordEncoder.matches(password, alumni.getPassword())) {
                throw new RuntimeException("Invalid password");
            }

            Long Id = alumni.getId();
            List<String> roles = Collections.singletonList("ROLE_ALUMNI");
            String jwtToken = jwtUtil.generateJwtToken(Id, roles);

            return new LoginResponse(jwtToken, Id, roles);
        } else if (faculty != null) {
            if (!passwordEncoder.matches(password, faculty.getPassword())) {
                throw new RuntimeException("Invalid password");
            }

            Long Id = faculty.getId();
            List<String> roles = Collections.singletonList("ROLE_FACULTY");
            String jwtToken = jwtUtil.generateJwtToken(Id, roles);

            return new LoginResponse(jwtToken, Id, roles);
        } else if (student != null) {
            if (!passwordEncoder.matches(password, student.getPassword())) {
                throw new RuntimeException("Invalid password");
            }

            Long Id = student.getId();
            List<String> roles = Collections.singletonList("ROLE_STUDENT");
            String jwtToken = jwtUtil.generateJwtToken(Id, roles);

            return new LoginResponse(jwtToken, Id, roles);
        } else {
            throw new RuntimeException("User not found");
        }
    }*/
}