package com.senac.projeto.integrador.loja.builder;

import com.senac.projeto.integrador.loja.model.Product;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductStockBuilder {

    public static Product buildFrom(Product product) {
        return Product
                .builder()
                .id(product.getId())
                .descriptionProduct(product.getDescriptionProduct())
                .assessmentProduct(product.getAssessmentProduct())
                .nameProduct(product.getNameProduct())
                .priceProduct(product.getPriceProduct())
                .stockQuantity(product.getStockQuantity())
                .isActive(product.getIsActive())
                .build();
    }
}
