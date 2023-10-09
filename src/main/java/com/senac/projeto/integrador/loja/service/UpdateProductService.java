package com.senac.projeto.integrador.loja.service;

import com.senac.projeto.integrador.loja.builder.ProductBuilder;
import com.senac.projeto.integrador.loja.dto.request.UpdateProductRequestDTO;
import com.senac.projeto.integrador.loja.indicator.GroupIndicator;
import com.senac.projeto.integrador.loja.model.Product;
import com.senac.projeto.integrador.loja.model.SessionClientStore;
import com.senac.projeto.integrador.loja.repository.ProductRepository;
import com.senac.projeto.integrador.loja.repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@RequiredArgsConstructor
@Service
public class UpdateProductService {

    private final ProductRepository productRepository;
    private final SessionRepository sessionRepository;

    public void updateProduct(UpdateProductRequestDTO updateProductRequestDTO) throws Exception {
        if (ObjectUtils.isEmpty(updateProductRequestDTO)) {
            throw new Exception("Request vazia!");
        }
        SessionClientStore sessionClientStoreUser = sessionRepository.findFirstByOrderByIdDesc();

        if (!GroupIndicator.ADMIN.getGroupName().equals(sessionClientStoreUser.getRole())) {
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
