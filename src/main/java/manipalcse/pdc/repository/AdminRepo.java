package manipalcse.pdc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import manipalcse.pdc.entity.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin,Long> {

     Optional<Admin> findByEmail(String email);
Optional<Admin> findById(Long id);  
}
