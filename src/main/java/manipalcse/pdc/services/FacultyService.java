package manipalcse.pdc.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manipalcse.pdc.dto.FacultyDetailsDto;
import manipalcse.pdc.entity.Faculty;
import manipalcse.pdc.repository.FacultyRepo;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepo facultyRepo;

    public List<FacultyDetailsDto> getAllFacultyDetails() {
        List<Faculty> facultyList = facultyRepo.findAll();
        return facultyList.stream().map(faculty -> {
            FacultyDetailsDto dto = new FacultyDetailsDto();
            dto.setFirstName(faculty.getFirstName());
            dto.setLastName(faculty.getLastName());
            dto.setEmail(faculty.getEmail());
            dto.setMobileNumber(faculty.getMobileNumber());
            dto.setCabinLocation(faculty.getCabinLocation());
            dto.setAreaOfInterest(faculty.getAreaOfInterest());
            dto.setAreaOfResearch(faculty.getAreaOfResearch());
            dto.setCourses(faculty.getCourses());
            return dto;
        }).collect(Collectors.toList());
    }
}