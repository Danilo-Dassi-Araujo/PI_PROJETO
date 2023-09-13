package com.senac.projeto.integrador.loja.service;

import com.senac.projeto.integrador.loja.builder.ProductBuilder;
import com.senac.projeto.integrador.loja.dto.request.UpdateProductRequestDTO;
import com.senac.projeto.integrador.loja.indicator.GroupIndicator;
import com.senac.projeto.integrador.loja.model.Product;
import com.senac.projeto.integrador.loja.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@RequiredArgsConstructor
@Service
public class UpdateProductService {

    private final ProductRepository productRepository;

    public void updateProduct(UpdateProductRequestDTO updateProductRequestDTO,
                                     GroupIndicator groupIndicator) throws Exception {
        if (ObjectUtils.isEmpty(updateProductRequestDTO)) {
            throw new Exception("Request vazia!");
        }
        if (!GroupIndicator.ADMIN.equals(groupIndicator)) {
            throw new Exception("Somente administradores podem alterar os produtos!");
        }

        Product product = productRepository.findById(updateProductRequestDTO.getId()).orElse(null);

        if(ObjectUtils.isEmpty(product)){
            throw new Exception("Nenhum produto encontrado pelo id: " + updateProductRequestDTO.getId());
        }

        Product updateProductToSave = ProductBuilder.buildFrom(updateProductRequestDTO, product);

        productRepository.save(updateProductToSave);

    }
}
