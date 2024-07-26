package com.user.codeforcodeuser.solution.dto.explanation.response;

import com.user.codeforcodeuser.solution.domain.Explanation;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExplanationResponse {
    private Long id;
    private Long solutionId;
    private String code;
    private Boolean isSuccess;

    public static ExplanationResponse from(Explanation explanation){
        return new ExplanationResponse(
                explanation.getId(),
                explanation.getSolutionId(),
                explanation.getCode(),
                explanation.getIsSuccess()
        );
    }
}
