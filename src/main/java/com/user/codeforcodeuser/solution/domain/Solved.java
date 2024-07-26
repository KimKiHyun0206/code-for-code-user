package com.user.codeforcodeuser.solution.domain;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
public class Solved {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private Long solutionId;
    private Boolean isSuccess;

    public Solved(String userId, Long solutionId, Boolean isSuccess){
        this.userId = userId;
        this.solutionId = solutionId;
        this.isSuccess = isSuccess;
    }

    public void updateSuccess(Long id){
        this.isSuccess = true;
    }
}
