package com.user.codeforcodeuser.solution.service;

import com.user.codeforcodeuser.solution.domain.Solution;
import com.user.codeforcodeuser.solution.dto.solution.request.SolutionGetRequest;
import com.user.codeforcodeuser.solution.dto.solution.request.SolutionListGetRequest;
import com.user.codeforcodeuser.solution.dto.solution.request.SolutionRegisterRequest;
import com.user.codeforcodeuser.solution.dto.solution.request.SolutionUpdateRequest;
import com.user.codeforcodeuser.solution.dto.solution.response.SolutionResponse;
import com.user.codeforcodeuser.solution.repository.SolutionRepository;
import com.user.codeforcodeuser.solution.repository.SolvedRepository;
import com.user.codeforcodeuser.user.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SolutionService {

    private final SolutionRepository solutionRepository;
    private final SolvedRepository solvedRepository;

    @Transactional
    public SolutionResponse register(SolutionRegisterRequest request) {
        Solution solution = new Solution(
                request.getTitle(),
                request.getLevel(),
                request.getExplain(),
                request.getInput(),
                request.getOutput()
        );

        Solution savedSolution = solutionRepository.save(solution);

        return SolutionResponse.from(savedSolution);
    }

    @Transactional(readOnly = true)
    public SolutionResponse get(SolutionGetRequest request) {
        Solution solution = solutionRepository.findById(request.getId()).get();

        return SolutionResponse.from(solution);

    }

    @Transactional(readOnly = true)
    public Page<SolutionResponse> getAll(SolutionListGetRequest request, Pageable pageable) {

        if (request.getIsSuccess() != null && request.getLevel() != null) {

        } else if (request.getLevel() != null) {
            return solutionRepository.findSolutionsByLevel(request.getLevel()).map(SolutionResponse::from);
        } else if (request.getIsSuccess() != null) {

        }

        Page<SolutionResponse> responses = solutionRepository.findAll(pageable).map(SolutionResponse::from);

        return responses;
    }

    @Transactional
    public SolutionResponse update(SolutionUpdateRequest request) {
        Solution updateSolution = solutionRepository.findById(request.getId()).get();

        updateSolution.update(
                request.getTitle(),
                request.getLevel(),
                request.getExplain(),
                request.getInput(),
                request.getOutput()
        );

        return SolutionResponse.from(updateSolution);
    }


}
