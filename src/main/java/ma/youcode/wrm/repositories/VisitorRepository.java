package ma.youcode.wrm.repositories;

import ma.youcode.wrm.entities.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor , Long> {
}
