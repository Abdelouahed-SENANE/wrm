package ma.youcode.wrm.repository;

import ma.youcode.wrm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<User, Long> {
}
