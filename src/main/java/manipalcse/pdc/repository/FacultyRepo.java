package manipalcse.pdc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import manipalcse.pdc.entity.Faculty;

@Repository
public interface FacultyRepo extends JpaRepository<Faculty,Long> {
    List<Faculty> findAll();
    Optional<Faculty> findByEmail(String email);
    Optional<Faculty> findById(String Id);
    
}
