package com.senac.projeto.integrador.loja.service.product;

import com.senac.projeto.integrador.loja.builder.ProductBuilder;
import com.senac.projeto.integrador.loja.model.Product;
import com.senac.projeto.integrador.loja.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@RequiredArgsConstructor
@Service
public class InactiveAndActiveProductService {

    private final ProductRepository productRepository;

    public void activeAndInactiveProduct(Integer id) throws Exception {

        if (!ObjectUtils.isEmpty(id)) {
            Product productById = productRepository.findById(id).orElse(null);

            if (ObjectUtils.isEmpty(productById)) {
                throw new Exception("Nenhum produto encontrado para id: " + id);
            }
            Product productToSave = ProductBuilder.buildFrom(productById);

            productRepository.save(productToSave);
        } else {
            throw new Exception("Id está vazio!");
        }
    }

}
