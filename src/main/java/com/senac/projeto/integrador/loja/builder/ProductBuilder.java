package com.senac.projeto.integrador.loja.builder;

import com.senac.projeto.integrador.loja.dto.request.ProductRequestDTO;
import com.senac.projeto.integrador.loja.dto.request.UpdateProductRequestDTO;
import com.senac.projeto.integrador.loja.model.Product;
import com.senac.projeto.integrador.loja.model.Product_;
import lombok.RequiredArgsConstructor;
import org.springframework.util.ObjectUtils;

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

    public static Product buildFrom(UpdateProductRequestDTO productRequest, Product product) {
        return Product
                .builder()
                .id(product.getId())
                .descriptionProduct(!ObjectUtils.isEmpty(productRequest.getDescription()) ? productRequest.getDescription() : product.getDescriptionProduct())
                .assessmentProduct(!ObjectUtils.isEmpty(productRequest.getAssessmentProduct()) ? productRequest.getAssessmentProduct() : product.getAssessmentProduct())
                .nameProduct(!ObjectUtils.isEmpty(productRequest.getNameProduct()) ? productRequest.getNameProduct() : product.getNameProduct())
                .priceProduct(!ObjectUtils.isEmpty(productRequest.getPriceProduct()) ? productRequest.getPriceProduct() : product.getPriceProduct())
                .stockQuantity(!ObjectUtils.isEmpty(productRequest.getStockQuantity()) ? productRequest.getStockQuantity() : product.getStockQuantity())
                .isActive(Boolean.TRUE)
                .build();
    }


}
