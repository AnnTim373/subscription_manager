package org.timofeeva.subman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.timofeeva.subman.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
