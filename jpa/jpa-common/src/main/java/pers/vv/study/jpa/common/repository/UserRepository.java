package pers.vv.study.jpa.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pers.vv.study.jpa.common.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
