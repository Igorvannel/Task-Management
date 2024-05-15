package com.igor.user.service.repository;

import com.igor.user.service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
  public User findByEmail(String email);

}
