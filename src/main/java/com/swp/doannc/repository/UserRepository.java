package com.swp.doannc.repository;

import java.util.List;

import com.swp.doannc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository
 */
public interface UserRepository extends JpaRepository<User, Long> {

  List<User> findAll();

  User findByEmail(String email);

  boolean existsByEmail(String email);

  boolean existsByPhone(String phone);

}
