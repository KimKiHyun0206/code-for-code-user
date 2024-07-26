package com.user.codeforcodeuser.solution.domain;


import com.user.codeforcodeuser.common.BaseEntity;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
public class Explanation extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long solutionId;
    private String code;
    private Boolean isSuccess;
}
