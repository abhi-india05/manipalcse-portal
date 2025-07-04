package manipalcse.pdc.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "student")
public class Student {

    @NotBlank(message = "Roll number is required")
    @Column(name = "roll_no", nullable = false, length = 50)
    private String rollNo;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long StudentId;

    @NotBlank(message = "Enrollment number is required")
    @Column(name = "enrollment_no", nullable = false, length = 50)
    private String enrollmentNo;

    @NotBlank(message = "Section is required")
    @Column(name = "section", nullable = false, length = 10)
    private String section;

    @NotBlank(message = "Academic year is required")
    @Pattern(regexp = "^[0-9]{4}-[0-9]{2}$", message = "Academic year must be in the format YYYY-YY (e.g., 2024-25)")
    @Column(name = "academic_year", nullable = false, length = 10)
    private String academicYear;

    @NotBlank(message = "Admitted year is required")
    @Pattern(regexp = "^[0-9]{4}-[0-9]{2}$", message = "Admitted year must be in the format YYYY-YY (e.g., 2024-25)")
    @Column(name = "admitted_year", nullable = false, length = 10)
    private String admittedYear;

    @NotBlank(message = "Name is required")
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @NotBlank(message = "Program branch is required")
    @Column(name = "program_branch", nullable = false, length = 100)
    private String programBranch;

    @NotBlank(message = "Date of birth is required")
    @Column(name = "dob", nullable = false)
    private String dob;

    @NotBlank(message = "Gender is required")
    @Column(name = "gender", nullable = false, length = 10)
    private String gender;

    @NotBlank(message = "Mobile number is required")
    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Mobile number must be a valid 10-digit Indian number")
    @Column(name = "mobile_number", nullable = false, unique = true, length = 10)
    private String mobileNumber;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    @Column(name = "email", nullable = false, unique = true, length = 150)
    private String email;

    @NotBlank(message = "Password is required")
    @Column(name = "password", nullable = false)
    private String password;

    @ManyToMany
    @JoinTable(
            name = "student_roles",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public Long getId() {
        return StudentId;
    }

    public String getEnrollmentNo() {
        return enrollmentNo;
    }

    public void setEnrollmentNo(String enrollmentNo) {
        this.enrollmentNo = enrollmentNo;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public String getAdmittedYear() {
        return admittedYear;
    }

    public void setAdmittedYear(String admittedYear) {
        this.admittedYear = admittedYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProgramBranch() {
        return programBranch;
    }

    public void setProgramBranch(String programBranch) {
        this.programBranch = programBranch;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
