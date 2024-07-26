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
public class Solution extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer level;
    private String explain;
    private String input;
    private String output;


    public Solution(String title, Integer level, String explain, String input, String output) {
        this.title = title;
        this.level = level;
        this.explain = explain;
        this.input = input;
        this.output = output;
    }

    public void update(String title, Integer level, String explain, String input, String output) {
        this.title = title;
        this.level = level;
        this.explain = explain;
        this.input = input;
        this.output = output;
    }
}
