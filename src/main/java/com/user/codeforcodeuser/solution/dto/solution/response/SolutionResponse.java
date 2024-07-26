package com.user.codeforcodeuser.solution.dto.solution.response;

import com.user.codeforcodeuser.solution.domain.Solution;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SolutionResponse {
    private Long id;
    private String title;
    private String explain;
    private String input;
    private String output;

    public static SolutionResponse from(Solution solution){
        return new SolutionResponse(
                solution.getId(),
                solution.getTitle(),
                solution.getExplain(),
                solution.getInput(),
                solution.getOutput()
        );
    }
}
