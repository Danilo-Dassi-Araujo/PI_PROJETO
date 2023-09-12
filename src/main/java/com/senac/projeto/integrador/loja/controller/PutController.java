package com.senac.projeto.integrador.loja.controller;

import com.senac.projeto.integrador.loja.dto.request.EmailDTORequest;
import com.senac.projeto.integrador.loja.dto.request.UserRequestDTO;
import com.senac.projeto.integrador.loja.dto.response.UpdateDTOResponse;
import com.senac.projeto.integrador.loja.service.AlterStockProductService;
import com.senac.projeto.integrador.loja.service.InactiveAndActiveProductService;
import com.senac.projeto.integrador.loja.service.InactiveAndActiveUserService;
import com.senac.projeto.integrador.loja.service.UpdateUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/edit")
@CrossOrigin(origins = "http://localhost:3000")
public class PutController {

    private final InactiveAndActiveUserService inactiveAndActiveUserService;
    private final InactiveAndActiveProductService inactiveAndActiveProductService;
    private final AlterStockProductService alterStockProductService;
    private final UpdateUserService updateUserService;


    @PutMapping
    public ResponseEntity<Void> inactiveOrActiveUser(@RequestBody EmailDTORequest email) throws Exception {
        inactiveAndActiveUserService.inactiveOrActiveUser(email);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<Void> inactiveOrActiveProduct(@PathVariable Integer id) throws Exception {
        inactiveAndActiveProductService.activeAndInactiveProduct(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("/product-stock/{id}/{newStockValue}")
    public ResponseEntity<Void> alterStockProduct(@PathVariable Integer id,
                                                  @PathVariable Integer newStockValue) throws Exception {
        alterStockProductService.alterStock(id, newStockValue);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("/user")
    public ResponseEntity<UpdateDTOResponse> alterUser(@RequestBody UserRequestDTO requestDTO,
                                                       @RequestParam String login) throws Exception {
        UpdateDTOResponse updateDTOResponse = updateUserService.updateUser(requestDTO, login);
        return ResponseEntity.ok().body(updateDTOResponse);
    }
}
