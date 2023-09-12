package com.senac.projeto.integrador.loja.builder;

import com.senac.projeto.integrador.loja.dto.request.ProductRequestDTO;
import com.senac.projeto.integrador.loja.model.Product;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductBuilder {

    public static Product buildFrom(ProductRequestDTO productRequestDTO) {
        return Product
                .builder()
                .descriptionProduct(productRequestDTO.getDescription())
                .assessmentProduct(productRequestDTO.getAssessmentProduct())
                .nameProduct(productRequestDTO.getNameProduct())
                .priceProduct(productRequestDTO.getPriceProduct())
                .stockQuantity(productRequestDTO.getStockQuantity())
                .isActive(Boolean.TRUE)
                .build();
    }

    public static Product buildFrom(Product product) {
        return Product
                .builder()
                .id(product.getId())
                .descriptionProduct(product.getDescriptionProduct())
                .assessmentProduct(product.getAssessmentProduct())
                .nameProduct(product.getNameProduct())
                .priceProduct(product.getPriceProduct())
                .stockQuantity(product.getStockQuantity())
                .isActive(product.getIsActive() ? Boolean.FALSE : Boolean.TRUE)
                .build();
    }


}
