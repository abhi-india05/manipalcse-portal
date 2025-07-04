package manipalcse.pdc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manipalcse.pdc.dto.AdminDto;
import manipalcse.pdc.dto.AlumniDto;
import manipalcse.pdc.dto.FacultyDto;
import manipalcse.pdc.dto.StudentDto;
import manipalcse.pdc.entity.Admin;
import manipalcse.pdc.entity.Alumni;
import manipalcse.pdc.entity.Faculty;
import manipalcse.pdc.entity.Student;
import manipalcse.pdc.exception.NotFoundException;
import manipalcse.pdc.repository.AdminRepo;
import manipalcse.pdc.repository.AlumniRepo;
import manipalcse.pdc.repository.FacultyRepo;
import manipalcse.pdc.repository.StudentRepo;

@Service
public class ProfileService {
    @Autowired private AdminRepo adminRepo;
    @Autowired private StudentRepo studentRepo;
    @Autowired private FacultyRepo facultyRepo;
    @Autowired private AlumniRepo alumniRepo;

    public AdminDto getAdminProfileById(Long id) {
        Admin admin = adminRepo.findById(id).orElseThrow(() -> new NotFoundException("Admin not found"));
        AdminDto dto = new AdminDto();
        dto.setEmail(admin.getEmail());
        dto.setFirstName(admin.getFirstName());
        dto.setLastName(admin.getLastName());
        dto.setMobileNumber(admin.getMobileNumber());
        dto.setPassword(null); 
        return dto;
    }

    public StudentDto getStudentProfileById(String id) {
        Student student = studentRepo.findById(id).orElseThrow(() -> new NotFoundException("Student not found"));
        StudentDto dto = new StudentDto();
        dto.setRollNo(student.getRollNo());
        dto.setEnrollmentNo(student.getEnrollmentNo());
        dto.setSection(student.getSection());
        dto.setAcademicYear(student.getAcademicYear());
        dto.setAdmittedYear(student.getAdmittedYear());
        dto.setName(student.getName());
        dto.setProgramBranch(student.getProgramBranch());
        dto.setDob(student.getDob());
        dto.setGender(student.getGender());
        dto.setMobileNumber(student.getMobileNumber());
        dto.setEmail(student.getEmail());
        dto.setPassword(null);
        return dto;
    }

    public FacultyDto getFacultyProfileById(Long id) {
        Faculty faculty = facultyRepo.findById(id).orElseThrow(() -> new RuntimeException("Faculty not found"));
        FacultyDto dto = new FacultyDto();
        dto.setFirstName(faculty.getFirstName());
        dto.setLastName(faculty.getLastName());
        dto.setEmail(faculty.getEmail());
        dto.setMobileNumber(faculty.getMobileNumber());
        dto.setCabinLocation(faculty.getCabinLocation());
        dto.setAreaOfInterest(faculty.getAreaOfInterest());
        dto.setAreaOfResearch(faculty.getAreaOfResearch());
        dto.setCourses(faculty.getCourses());
        dto.setPassword(null); 
        return dto;
    }

    public AlumniDto getAlumniProfileById(Long id) {
        Alumni alumni = alumniRepo.findById(id).orElseThrow(() -> new RuntimeException("Alumni not found"));
        AlumniDto dto = new AlumniDto();
        dto.setEmail(alumni.getEmail());
        dto.setFirstName(alumni.getFirstName());
        dto.setLastName(alumni.getLastName());
        dto.setMobileNumber(alumni.getMobileNumber());
   
        dto.setPassword(null);
        return dto;
    }
}