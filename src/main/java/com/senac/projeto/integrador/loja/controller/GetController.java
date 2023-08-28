package com.senac.projeto.integrador.loja.controller;

import com.senac.projeto.integrador.loja.dto.request.LoginRequestDTO;
import com.senac.projeto.integrador.loja.dto.response.ListingDTOResponse;
import com.senac.projeto.integrador.loja.dto.response.LoginDTOResponse;
import com.senac.projeto.integrador.loja.filter.ControllerFilter;
import com.senac.projeto.integrador.loja.indicator.GroupIndicator;
import com.senac.projeto.integrador.loja.service.ListingUsersService;
import com.senac.projeto.integrador.loja.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/home")
public class GetController {

    private final ListingUsersService listingUsersService;
    private final LoginService loginService;

    @GetMapping("/listingUser")
    public ResponseEntity<List<ListingDTOResponse>> getFilteredUsers(ControllerFilter controllerFilter,
                                                                     @RequestParam GroupIndicator groupIndicator) throws Exception {
        List<ListingDTOResponse> allUsers = listingUsersService.getAllUsers(controllerFilter, groupIndicator);
        return ResponseEntity.ok().body(allUsers);
    }

    @GetMapping("/login")
    public ResponseEntity<LoginDTOResponse> login(LoginRequestDTO loginRequestDTO) throws Exception {
        LoginDTOResponse loginDTOResponse = loginService.loginUser(loginRequestDTO);
        return ResponseEntity.ok().body(loginDTOResponse);
    }
}
