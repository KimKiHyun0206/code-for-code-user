package com.user.codeforcodeuser.solution.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Solved {
    @Id
    private Long id;
    private boolean idSuccess;
}
