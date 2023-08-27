package com.senac.projeto.integrador.loja.controller;

import com.senac.projeto.integrador.loja.dto.request.RegisterRequestDTO;
import com.senac.projeto.integrador.loja.dto.response.RegisterDTOResponse;
import com.senac.projeto.integrador.loja.service.RegisterUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/home")
public class PostController {

    private final RegisterUserService registerUserService;

    @PostMapping("/register")
    public ResponseEntity<RegisterDTOResponse> registerUser(@RequestBody RegisterRequestDTO registerRequestDTO) throws Exception {

        RegisterDTOResponse registerDTOResponse = registerUserService.registerUser(registerRequestDTO);
        return ResponseEntity.ok().body(registerDTOResponse);
    }
}
