package com.senac.projeto.integrador.loja.repository.specification;

import com.senac.projeto.integrador.loja.filter.FilterProducts;
import com.senac.projeto.integrador.loja.filter.repository.ProductPredicateHandler;
import com.senac.projeto.integrador.loja.model.Product;
import com.senac.projeto.integrador.loja.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductSpecification {

    private final ProductPredicateHandler productPredicateHandler;
    private final ProductRepository productRepository;
    public Page<Product> findBy(FilterProducts controllerFilter, Pageable pageable) {
        Specification<Product> specification = (root, criteriaQuery, criteriaBuilder) ->
                criteriaQuery
                        .where(productPredicateHandler.getPredicatesByFilter(controllerFilter, root, criteriaQuery, criteriaBuilder))
                        .getRestriction();
        return productRepository.findAll(specification,pageable);
    }
}