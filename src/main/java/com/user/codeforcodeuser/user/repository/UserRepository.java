package com.user.codeforcodeuser.user.repository;

import com.user.codeforcodeuser.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
