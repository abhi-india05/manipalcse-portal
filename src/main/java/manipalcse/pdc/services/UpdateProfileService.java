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
public class UpdateProfileService {

    @Autowired
    private AdminRepo adminRepo;
    
    @Autowired
    private StudentRepo studentRepo;
    
    @Autowired
    private FacultyRepo facultyRepo;
    
    @Autowired
    private AlumniRepo alumniRepo;

    public AdminDto updateAdminProfile(Long id, AdminDto adminDto) {
        Admin admin = adminRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Admin not found"));
        
        // Update fields except password
        admin.setFirstName(adminDto.getFirstName());
        admin.setLastName(adminDto.getLastName());
        admin.setEmail(adminDto.getEmail());
        admin.setMobileNumber(adminDto.getMobileNumber());
        
        Admin updatedAdmin = adminRepo.save(admin);
        
        return convertToAdminDto(updatedAdmin);
    }

    public StudentDto updateStudentProfile(Long id, StudentDto studentDto) {
        Student student = studentRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Student not found"));
        
        // Update fields except password
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
        
        Student updatedStudent = studentRepo.save(student);
        
        return convertToStudentDto(updatedStudent);
    }

    public FacultyDto updateFacultyProfile(Long id, FacultyDto facultyDto) {
        Faculty faculty = facultyRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Faculty not found"));
        
        // Update fields except password
        faculty.setFirstName(facultyDto.getFirstName());
        faculty.setLastName(facultyDto.getLastName());
        faculty.setEmail(facultyDto.getEmail());
        faculty.setMobileNumber(facultyDto.getMobileNumber());
        faculty.setCabinLocation(facultyDto.getCabinLocation());
        faculty.setAreaOfInterest(facultyDto.getAreaOfInterest());
        faculty.setAreaOfResearch(facultyDto.getAreaOfResearch());
        faculty.setCourses(facultyDto.getCourses());
        
        Faculty updatedFaculty = facultyRepo.save(faculty);
        
        return convertToFacultyDto(updatedFaculty);
    }

    public AlumniDto updateAlumniProfile(Long id, AlumniDto alumniDto) {
        Alumni alumni = alumniRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Alumni not found"));
        
        // Update fields except password
        alumni.setFirstName(alumniDto.getFirstName());
        alumni.setLastName(alumniDto.getLastName());
        alumni.setEmail(alumniDto.getEmail());
        alumni.setMobileNumber(alumniDto.getMobileNumber());
        
        Alumni updatedAlumni = alumniRepo.save(alumni);
        
        return convertToAlumniDto(updatedAlumni);
    }

    private AdminDto convertToAdminDto(Admin admin) {
        AdminDto dto = new AdminDto();
        dto.setFirstName(admin.getFirstName());
        dto.setLastName(admin.getLastName());
        dto.setEmail(admin.getEmail());
        dto.setMobileNumber(admin.getMobileNumber());
        return dto;
    }

    private StudentDto convertToStudentDto(Student student) {
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
        return dto;
    }

    private FacultyDto convertToFacultyDto(Faculty faculty) {
        FacultyDto dto = new FacultyDto();
        dto.setFirstName(faculty.getFirstName());
        dto.setLastName(faculty.getLastName());
        dto.setEmail(faculty.getEmail());
        dto.setMobileNumber(faculty.getMobileNumber());
        dto.setCabinLocation(faculty.getCabinLocation());
        dto.setAreaOfInterest(faculty.getAreaOfInterest());
        dto.setAreaOfResearch(faculty.getAreaOfResearch());
        dto.setCourses(faculty.getCourses());
        return dto;
    }

    private AlumniDto convertToAlumniDto(Alumni alumni) {
        AlumniDto dto = new AlumniDto();
        dto.setFirstName(alumni.getFirstName());
        dto.setLastName(alumni.getLastName());
        dto.setEmail(alumni.getEmail());
        dto.setMobileNumber(alumni.getMobileNumber());
        return dto;
    }
}