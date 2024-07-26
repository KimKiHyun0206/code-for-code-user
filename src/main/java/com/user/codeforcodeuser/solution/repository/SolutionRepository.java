package com.user.codeforcodeuser.solution.repository;

import com.user.codeforcodeuser.solution.domain.Solution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolutionRepository extends JpaRepository<Solution, Long> {
}
