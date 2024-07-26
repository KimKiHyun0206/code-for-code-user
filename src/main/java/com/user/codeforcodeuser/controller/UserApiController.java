package com.user.codeforcodeuser.controller;

import com.user.codeforcodeuser.common.dto.PageDto;
import com.user.codeforcodeuser.common.dto.ResponseDto;
import com.user.codeforcodeuser.dto.request.UserDeleteRequest;
import com.user.codeforcodeuser.dto.request.UserLoginRequest;
import com.user.codeforcodeuser.dto.request.UserRegisterRequest;
import com.user.codeforcodeuser.dto.request.UserSearchRequest;
import com.user.codeforcodeuser.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRegisterRequest request) {
        var response = userService.register(request);

        return ResponseDto.created(response);
    }

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginRequest request){
        var response = userService.login(request);

        return ResponseDto.ok(response);
    }

    @GetMapping("/get")
    public ResponseEntity<?> get(@RequestBody UserSearchRequest request) {
        var response = userService.get(request);

        return ResponseDto.ok(response);
    }

    @GetMapping("/ranking")
    public ResponseEntity<?> ranking(@PageableDefault(size = 10, direction = Sort.Direction.DESC) Pageable pageable) {
        var response = userService.getRanking(pageable);

        return PageDto.ok(response);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(UserDeleteRequest request) {
        if (userService.delete(request)) {
            return ResponseDto.noContent();
        }
        return ResponseDto.badRequest();
    }
}
