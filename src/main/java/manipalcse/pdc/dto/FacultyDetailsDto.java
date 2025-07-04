package manipalcse.pdc.dto;

import java.util.List;

public class FacultyDetailsDto {
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private String cabinLocation;
    private List<String> areaOfInterest;
    private List<String> areaOfResearch;
    private List<String> courses;

    // Getters and setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getMobileNumber() { return mobileNumber; }
    public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }
    public String getCabinLocation() { return cabinLocation; }
    public void setCabinLocation(String cabinLocation) { this.cabinLocation = cabinLocation; }
    public List<String> getAreaOfInterest() { return areaOfInterest; }
    public void setAreaOfInterest(List<String> areaOfInterest) { this.areaOfInterest = areaOfInterest; }
    public List<String> getAreaOfResearch() { return areaOfResearch; }
    public void setAreaOfResearch(List<String> areaOfResearch) { this.areaOfResearch = areaOfResearch; }
    public List<String> getCourses() { return courses; }
    public void setCourses(List<String> courses) { this.courses = courses; }
}