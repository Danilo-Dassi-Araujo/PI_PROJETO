package com.senac.projeto.integrador.loja.builder;

import com.senac.projeto.integrador.loja.dto.response.ListingProductResponseDTO;
import com.senac.projeto.integrador.loja.dto.response.PageDTO;
import com.senac.projeto.integrador.loja.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PageListingProductsBuilder {

    public static PageDTO<ListingProductResponseDTO> buildFrom(Page<Product> productPage) {
        return PageDTO.<ListingProductResponseDTO>builder()
                .pageNum(productPage.getNumber() + 1)
                .pageItemsNum(productPage.getNumberOfElements())
                .totalItems(productPage.getTotalElements())
                .totalPages(productPage.getTotalPages())
                .data(getListingProductResponse(productPage.getContent()))
                .build();
    }

    private static List<ListingProductResponseDTO> getListingProductResponse(List<Product> productList) {
        return productList.stream()
                .filter(Objects::nonNull)
                .map(PageListingProductsBuilder::fromProduct)
                .collect(Collectors.toList());
    }

    private static ListingProductResponseDTO fromProduct(Product product) {
        return ListingProductResponseDTO.builder()
                .id(product.getId())
                .nameProduct(product.getNameProduct())
                .stockProduct(product.getStockQuantity())
                .priceProduct(product.getPriceProduct())
                .isActive(product.getIsActive())
                .build();
    }
}
