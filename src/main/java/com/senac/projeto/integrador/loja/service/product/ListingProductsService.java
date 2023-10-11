package com.senac.projeto.integrador.loja.service.product;

import com.senac.projeto.integrador.loja.builder.PageListingProductsBuilder;
import com.senac.projeto.integrador.loja.dto.response.ListingProductResponseDTO;
import com.senac.projeto.integrador.loja.dto.response.PageDTO;
import com.senac.projeto.integrador.loja.filter.FilterProducts;
import com.senac.projeto.integrador.loja.model.Product;
import com.senac.projeto.integrador.loja.repository.ProductRepository;
import com.senac.projeto.integrador.loja.repository.specification.ProductSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ListingProductsService {

    private final ProductRepository productRepository;
    private final ProductSpecification productSpecification;

    public PageDTO<ListingProductResponseDTO> listingProducts(FilterProducts controllerFilter, int page, int maxItems) {
        Pageable pageable = PageRequest.of(page, maxItems);
        Page<Product> pageProduct = productSpecification.findBy(controllerFilter, pageable);

        return PageListingProductsBuilder.buildFrom(pageProduct);
    }
}