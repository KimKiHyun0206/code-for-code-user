package com.user.codeforcodeuser.solution.repository;

import com.user.codeforcodeuser.solution.domain.Solution;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SolutionRepository extends JpaRepository<Solution, Long> {

    public Page<Solution> findSolutionsByLevel(Integer level);
    //TODO JOIN 테이블 만들어서 푼 문제와 풀지 않은 문제 여부로 문제 가져올 수 있도록 만들기
    //public Page<Solution> findSolutionsBy

    //git
}
