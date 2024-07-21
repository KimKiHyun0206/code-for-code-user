package com.user.codeforcodeuser.service;

import com.user.codeforcodeuser.domain.User;
import com.user.codeforcodeuser.dto.request.DeleteRequest;
import com.user.codeforcodeuser.dto.request.LoginRequest;
import com.user.codeforcodeuser.dto.request.RegisterRequest;
import com.user.codeforcodeuser.dto.request.SearchRequest;
import com.user.codeforcodeuser.dto.response.UserResponse;
import com.user.codeforcodeuser.exception.UserNotFoundException;
import com.user.codeforcodeuser.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public UserResponse register(RegisterRequest request) {
        User user = new User(
                request.getPassword(),
                request.getNickName()
        );

        User savedUser = userRepository.save(user);

        return UserResponse.from(savedUser);
    }

    @Transactional(readOnly = true)
    public UserResponse login(LoginRequest request) {
        try {
            User user = userRepository.findById(request.getId()).orElseThrow(UserNotFoundException::new);

            if (!user.getPassword().equals(request.getPassword())) {
                user.setPassword(null);
                user.setNickName(null);
                user.setScore(null);
            }
            return UserResponse.from(user);

        } catch (UserNotFoundException e) {
            log.info(String.valueOf(e.getErrorMessage()));
            return null;
        }
    }

    @Transactional(readOnly = true)
    public UserResponse get(SearchRequest request){
        try {
            User user = userRepository.findById(request.getId()).orElseThrow(UserNotFoundException::new);

            if (!user.getPassword().equals(request.getPassword())) {
                return null;
            }
            return UserResponse.from(user);

        }catch (UserNotFoundException e){
            log.info(String.valueOf(e.getErrorMessage()));
            return null;
        }
    }

    @Transactional(readOnly = true)
    public Page<UserResponse> getRanking(Pageable pageable){
            return userRepository.findAll(pageable).map(UserResponse::from);
    }

    @Transactional
    public boolean delete(DeleteRequest request){
        try {
            User user = userRepository.findById(request.getId()).orElseThrow(UserNotFoundException::new);

            if (!user.getPassword().equals(request.getPassword())) {
                return false;
            }

            userRepository.deleteById(user.getId());
            return true;
        }catch (UserNotFoundException e){
            log.info(String.valueOf(e.getErrorMessage()));
            return false;
        }
    }
}
