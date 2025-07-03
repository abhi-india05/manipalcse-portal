package manipalcse.pdc.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Pattern(regexp = "^[0-9]{10}$")
    private String mobileNumber;

    @NotBlank
    private String cabinLocation;

    @ElementCollection
    private List<String> areaOfInterest = new ArrayList<>();

    @ElementCollection
    private List<String> areaOfResearch = new ArrayList<>();

    @ElementCollection
    private List<String> courses;

    private String password;

    public Faculty() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPassword(){
        return password;

    }

    public void setPassword(String password){
        this.password=password;
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
}
