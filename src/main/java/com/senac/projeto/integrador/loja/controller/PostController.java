package com.senac.projeto.integrador.loja.controller;

import com.senac.projeto.integrador.loja.dto.request.UserRequestDTO;
import com.senac.projeto.integrador.loja.dto.response.RegisterDTOResponse;
import com.senac.projeto.integrador.loja.service.RegisterUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/home")
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {

    private final RegisterUserService registerUserService;

    @PostMapping("/register")
    public ResponseEntity<RegisterDTOResponse> registerUser(@RequestBody UserRequestDTO userRequestDTO) throws Exception {

        RegisterDTOResponse registerDTOResponse = registerUserService.registerUser(userRequestDTO);
        return ResponseEntity.ok().body(registerDTOResponse);
    }
}
