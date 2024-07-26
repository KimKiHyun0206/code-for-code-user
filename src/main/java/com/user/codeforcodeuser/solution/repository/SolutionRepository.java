package com.user.codeforcodeuser.solution.repository;

import com.user.codeforcodeuser.solution.domain.Solution;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SolutionRepository extends JpaRepository<Solution, Long> {

    public Page<Solution> findSolutionsByLevel(Integer level);
    //public Page<Solution> findSolutionsBy
}
