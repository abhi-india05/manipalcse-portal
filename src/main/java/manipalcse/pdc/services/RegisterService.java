package manipalcse.pdc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import manipalcse.pdc.dto.AdminDto;
import manipalcse.pdc.dto.AlumniDto;
import manipalcse.pdc.dto.FacultyDto;
import manipalcse.pdc.dto.StudentDto;
import manipalcse.pdc.entity.Admin;
import manipalcse.pdc.entity.Alumni;
import manipalcse.pdc.entity.Faculty;
import manipalcse.pdc.entity.Student;
import manipalcse.pdc.repository.AdminRepo;
import manipalcse.pdc.repository.AlumniRepo;
import manipalcse.pdc.repository.FacultyRepo;
import manipalcse.pdc.repository.StudentRepo;

@Service
public class RegisterService {

    @Autowired
    private AdminRepo adminRepo;
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private FacultyRepo facultyRepo;
    @Autowired
    private AlumniRepo alumniRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String registerAdmin(AdminDto adminDto) {
        if (adminRepo.findByEmail(adminDto.getEmail()).isPresent()) {
            throw new RuntimeException("Admin with this email already exists");
        }
        Admin admin = new Admin();
        admin.setEmail(adminDto.getEmail());
        admin.setPassword(passwordEncoder.encode(adminDto.getPassword()));
        
        adminRepo.save(admin);
        return "Admin registered successfully";
    }

    public String registerStudent(StudentDto studentDto) {
        if (studentRepo.findByEmail(studentDto.getEmail()).isPresent()) {
            throw new RuntimeException("Student with this email already exists");
        }
        Student student = new Student();
        student.setEmail(studentDto.getEmail());
        student.setPassword(passwordEncoder.encode(studentDto.getPassword()));
        
        studentRepo.save(student);
        return "Student registered successfully";
    }

    public String registerFaculty(FacultyDto facultyDto) {
        if (facultyRepo.findByEmail(facultyDto.getEmail()).isPresent()) {
            throw new RuntimeException("Faculty with this email already exists");
        }
        Faculty faculty = new Faculty();
        faculty.setEmail(facultyDto.getEmail());
        faculty.setPassword(passwordEncoder.encode(facultyDto.getPassword()));
        
        facultyRepo.save(faculty);
        return "Faculty registered successfully";
    }

    public String registerAlumni(AlumniDto alumniDto) {
        if (alumniRepo.findByEmail(alumniDto.getEmail()).isPresent()) {
            throw new RuntimeException("Alumni with this email already exists");
        }
        Alumni alumni = new Alumni();
        alumni.setEmail(alumniDto.getEmail());
        alumni.setPassword(passwordEncoder.encode(alumniDto.getPassword()));
        
        alumniRepo.save(alumni);
        return "Alumni registered successfully";
    }
}