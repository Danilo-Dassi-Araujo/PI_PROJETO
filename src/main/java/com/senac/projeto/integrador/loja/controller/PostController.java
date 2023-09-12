package com.senac.projeto.integrador.loja.controller;

import com.senac.projeto.integrador.loja.dto.request.ProductRequestDTO;
import com.senac.projeto.integrador.loja.dto.request.UserRequestDTO;
import com.senac.projeto.integrador.loja.dto.response.RegisterDTOResponse;
import com.senac.projeto.integrador.loja.service.RegisterProductService;
import com.senac.projeto.integrador.loja.service.RegisterUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/home")
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {

    private final RegisterUserService registerUserService;
    private final RegisterProductService registerProductService;


    @PostMapping("/register")
    public ResponseEntity<RegisterDTOResponse> registerUser(@RequestBody UserRequestDTO userRequestDTO) throws Exception {

        RegisterDTOResponse registerDTOResponse = registerUserService.registerUser(userRequestDTO);
        return ResponseEntity.ok().body(registerDTOResponse);
    }

    @PostMapping("/registerProduct")
    public ResponseEntity<Void> registerUser(@RequestBody ProductRequestDTO productRequestDTO) throws Exception {

        registerProductService.registerProduct(productRequestDTO);
        return ResponseEntity.ok().build();
    }
}
