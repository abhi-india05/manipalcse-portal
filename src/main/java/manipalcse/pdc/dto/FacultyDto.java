package manipalcse.pdc.dto;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class FacultyDto {

    

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Valid email is required")
    private String email;

    @NotBlank(message = "Mobile number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @NotBlank(message = "Cabin location is required")
    private String cabinLocation;

    private List<String> areaOfInterest = new ArrayList<>();
    private List<String> areaOfResearch = new ArrayList<>();
    private List<String> courses = new ArrayList<>();

    @NotBlank(message = "Password is required")
    private String password;


    public FacultyDto() {}

    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getCabinLocation() {
        return cabinLocation;
    }

    public void setCabinLocation(String cabinLocation) {
        this.cabinLocation = cabinLocation;
    }

    public List<String> getAreaOfInterest() {
        return areaOfInterest;
    }

    public void setAreaOfInterest(List<String> areaOfInterest) {
        this.areaOfInterest = areaOfInterest;
    }

    public List<String> getAreaOfResearch() {
        return areaOfResearch;
    }

    public void setAreaOfResearch(List<String> areaOfResearch) {
        this.areaOfResearch = areaOfResearch;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
