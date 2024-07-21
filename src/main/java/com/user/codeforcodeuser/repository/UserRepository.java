package com.user.codeforcodeuser.repository;

import com.user.codeforcodeuser.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
