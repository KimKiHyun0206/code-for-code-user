package com.user.codeforcodeuser.solution.domain;


import com.user.codeforcodeuser.common.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class Explanation extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long solutionId;
    private String userId;
    private String code;
    private Boolean isSuccess;

    public Explanation(Long solutionId, String userId, String code, Boolean isSuccess) {
        this.solutionId = solutionId;
        this.userId = userId;
        this.code = code;
        this.isSuccess = isSuccess;
    }
}
