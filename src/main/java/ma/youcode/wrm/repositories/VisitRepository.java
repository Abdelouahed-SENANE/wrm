package ma.youcode.wrm.repositories;

import ma.youcode.wrm.entities.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends JpaRepository<Visit , Long> {
}
