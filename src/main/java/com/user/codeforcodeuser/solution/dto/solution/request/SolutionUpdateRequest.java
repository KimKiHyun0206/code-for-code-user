package com.user.codeforcodeuser.solution.dto.solution.request;

import lombok.Data;

@Data
public class SolutionUpdateRequest {
    private Long id;
    private String title;
    private Integer level;
    private String explain;
    private String input;
    private String output;
}
