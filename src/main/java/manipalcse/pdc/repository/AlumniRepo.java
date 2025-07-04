package manipalcse.pdc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import manipalcse.pdc.entity.Alumni;

@Repository
public interface AlumniRepo extends JpaRepository<Alumni,Long> {

    Optional<Alumni> findByEmail(String email);

    Optional<Alumni> findById(String Id);
}