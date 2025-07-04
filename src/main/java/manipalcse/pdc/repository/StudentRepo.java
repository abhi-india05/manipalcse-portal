package manipalcse.pdc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import manipalcse.pdc.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student,String> {

    Optional<Student> findByEmail(String email);

    Optional<Student> findById(String Id);
}