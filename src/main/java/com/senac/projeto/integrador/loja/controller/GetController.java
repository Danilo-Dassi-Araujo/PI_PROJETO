package com.senac.projeto.integrador.loja.controller;

import com.senac.projeto.integrador.loja.dto.response.ListingDTOResponse;
import com.senac.projeto.integrador.loja.filter.ControllerFilter;
import com.senac.projeto.integrador.loja.indicator.GroupIndicator;
import com.senac.projeto.integrador.loja.service.ListingUsersService;
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
    @GetMapping("/listingUser")
    public ResponseEntity<List<ListingDTOResponse>> getFilteredUsers(ControllerFilter controllerFilter,
                                                                     @RequestParam GroupIndicator groupIndicator) throws Exception {
        List<ListingDTOResponse> allUsers = listingUsersService.getAllUsers(controllerFilter, groupIndicator);
        return ResponseEntity.ok().body(allUsers);
    }
}
