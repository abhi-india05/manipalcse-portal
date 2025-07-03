package manipalcse.pdc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import manipalcse.pdc.entity.Faculty;

@Repository
public interface FacultyRepo extends JpaRepository<Faculty,Integer> {

    
}
