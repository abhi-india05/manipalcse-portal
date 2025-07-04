package manipalcse.pdc.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class StudentDto {

    @NotBlank(message = "Roll number is required")
    private String rollNo;

    @NotBlank(message = "Enrollment number is required")
    private String enrollmentNo;

    @NotBlank(message = "Section is required")
    private String section;

    @NotBlank(message = "Academic year is required")
    @Pattern(regexp = "^[0-9]{4}-[0-9]{2}$", message = "Academic year must be in the format YYYY-YY (e.g., 2024-25)")
    private String academicYear;

    @NotBlank(message = "Admitted year is required")
    @Pattern(regexp = "^[0-9]{4}-[0-9]{2}$", message = "Admitted year must be in the format YYYY-YY (e.g., 2024-25)")
    private String admittedYear;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Program branch is required")
    private String programBranch;

    @NotBlank(message = "Date of birth is required")
    private String dob;

    @NotBlank(message = "Gender is required")
    private String gender;

    @NotBlank(message = "Mobile number is required")
    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Mobile number must be a valid 10-digit Indian number")
    private String mobileNumber;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;



    public StudentDto() {}

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo  = rollNo;
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
