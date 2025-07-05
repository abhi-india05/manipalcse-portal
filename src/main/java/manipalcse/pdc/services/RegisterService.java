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
    admin.setFirstName(adminDto.getFirstName());
    admin.setLastName(adminDto.getLastName());  
    admin.setMobileNumber(adminDto.getMobileNumber());
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
    student.setRollNo(studentDto.getRollNo());
    student.setEnrollmentNo(studentDto.getEnrollmentNo());
    student.setSection(studentDto.getSection());
    student.setAcademicYear(studentDto.getAcademicYear());
    student.setAdmittedYear(studentDto.getAdmittedYear());
    student.setName(studentDto.getName());
    student.setProgramBranch(studentDto.getProgramBranch());
    student.setDob(studentDto.getDob());
    student.setGender(studentDto.getGender());
    student.setMobileNumber(studentDto.getMobileNumber());
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
    faculty.setFirstName(facultyDto.getFirstName());
    faculty.setLastName(facultyDto.getLastName());
    faculty.setEmail(facultyDto.getEmail());
    faculty.setMobileNumber(facultyDto.getMobileNumber());
    faculty.setCabinLocation(facultyDto.getCabinLocation());
    faculty.setAreaOfInterest(facultyDto.getAreaOfInterest());
    faculty.setAreaOfResearch(facultyDto.getAreaOfResearch());
    faculty.setCourses(facultyDto.getCourses());
    faculty.setPassword(passwordEncoder.encode(facultyDto.getPassword()));

    facultyRepo.save(faculty);
    return "Faculty registered successfully";
}

    public String registerAlumni(AlumniDto alumniDto) {
        if (alumniRepo.findByEmail(alumniDto.getEmail()).isPresent()) {
            throw new RuntimeException("Alumni with this email already exists");
        }
        Alumni alumni = new Alumni();
        alumni.setFirstName(alumniDto.getFirstName());
        alumni.setLastName(alumniDto.getLastName());
        alumni.setEmail(alumniDto.getEmail());
        alumni.setMobileNumber(alumniDto.getMobileNumber());
        alumni.setPassword(passwordEncoder.encode(alumniDto.getPassword()));
        
        alumniRepo.save(alumni);
        return "Alumni registered successfully";
    }
}