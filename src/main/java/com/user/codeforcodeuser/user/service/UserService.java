package com.user.codeforcodeuser.user.service;

import com.user.codeforcodeuser.user.domain.User;
import com.user.codeforcodeuser.user.dto.request.UserDeleteRequest;
import com.user.codeforcodeuser.user.dto.request.UserLoginRequest;
import com.user.codeforcodeuser.user.dto.request.UserRegisterRequest;
import com.user.codeforcodeuser.user.dto.request.UserSearchRequest;
import com.user.codeforcodeuser.user.dto.response.UserResponse;
import com.user.codeforcodeuser.exception.UserNotFoundException;
import com.user.codeforcodeuser.user.repository.UserRepository;
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
    public UserResponse register(UserRegisterRequest request) {
        User user = new User(
                request.getPassword(),
                request.getNickName()
        );

        User savedUser = userRepository.save(user);

        return UserResponse.from(savedUser);
    }

    @Transactional(readOnly = true)
    public UserResponse login(UserLoginRequest request) {
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
    public UserResponse get(UserSearchRequest request){
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
    public boolean delete(UserDeleteRequest request){
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
