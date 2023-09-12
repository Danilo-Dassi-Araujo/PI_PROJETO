package com.senac.projeto.integrador.loja.service;

import com.senac.projeto.integrador.loja.builder.ProductBuilder;
import com.senac.projeto.integrador.loja.dto.request.ProductRequestDTO;
import com.senac.projeto.integrador.loja.model.Product;
import com.senac.projeto.integrador.loja.repository.ProductRepository;
import com.senac.projeto.integrador.loja.utils.ValidatorUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
@RequiredArgsConstructor
public class RegisterProductService {

    private final ProductRepository productRepository;

    public void registerProduct(ProductRequestDTO productRequestDTO) throws Exception {
        if (!ObjectUtils.isEmpty(productRequestDTO)) {
            ValidatorUtils.validateProduct(productRequestDTO);

            Product productToSave = ProductBuilder.buildFrom(productRequestDTO);
            productRepository.save(productToSave);
        }
    }
}
