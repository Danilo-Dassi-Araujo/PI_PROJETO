package com.senac.projeto.integrador.loja.controller;

import com.senac.projeto.integrador.loja.dto.request.LoginRequestDTO;
import com.senac.projeto.integrador.loja.dto.response.ListingDTOResponse;
import com.senac.projeto.integrador.loja.dto.response.ListingProductResponseDTO;
import com.senac.projeto.integrador.loja.dto.response.LoginDTOResponse;
import com.senac.projeto.integrador.loja.dto.response.PageDTO;
import com.senac.projeto.integrador.loja.filter.ControllerFilter;
import com.senac.projeto.integrador.loja.filter.FilterProducts;
import com.senac.projeto.integrador.loja.indicator.GroupIndicator;
import com.senac.projeto.integrador.loja.service.ListingProductsService;
import com.senac.projeto.integrador.loja.service.ListingUsersService;
import com.senac.projeto.integrador.loja.service.LoginService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/home")
@CrossOrigin(origins = "http://localhost:3000")
public class GetController {

    private final ListingUsersService listingUsersService;
    private final LoginService loginService;
    private final ListingProductsService listingProductsService;

    @GetMapping("/listingUser")
    public ResponseEntity<List<ListingDTOResponse>> getFilteredUsers(ControllerFilter controllerFilter) throws Exception {

        List<ListingDTOResponse> allUsers = listingUsersService.getAllUsers(controllerFilter);
        return ResponseEntity.ok().body(allUsers);
    }
    @GetMapping("/login")
    public ResponseEntity<LoginDTOResponse> login(LoginRequestDTO loginRequestDTO) throws Exception {
        LoginDTOResponse loginDTOResponse = loginService.loginUser(loginRequestDTO);
        return ResponseEntity.ok().body(loginDTOResponse);
    }

    @GetMapping("/listingProducts")
    public ResponseEntity<PageDTO<ListingProductResponseDTO>> listingProducts(FilterProducts controllerFilter, @RequestParam int page, @RequestParam int maxItems) {
        PageDTO<ListingProductResponseDTO> listingProductResponseDTOS = listingProductsService.listingProducts(controllerFilter, page, maxItems);
        return ResponseEntity.ok().body(listingProductResponseDTOS);
    }
}
