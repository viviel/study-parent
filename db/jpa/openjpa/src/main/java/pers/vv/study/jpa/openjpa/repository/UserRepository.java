package pers.vv.study.jpa.openjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pers.vv.study.jpa.openjpa.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
