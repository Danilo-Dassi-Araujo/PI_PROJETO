package com.senac.projeto.integrador.loja.filter.repository;

import com.senac.projeto.integrador.loja.filter.ControllerFilter;
import com.senac.projeto.integrador.loja.filter.FilterProducts;
import com.senac.projeto.integrador.loja.model.Product;
import com.senac.projeto.integrador.loja.model.Product_;
import com.senac.projeto.integrador.loja.model.User;
import com.senac.projeto.integrador.loja.model.User_;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductPredicateHandler {

    public Predicate[] getPredicatesByFilter(FilterProducts controllerFilter,
                                             Root<Product> root,
                                             CriteriaQuery<?> cq,
                                             CriteriaBuilder cb) {

        List<Predicate> predicates = new ArrayList<>();

        if (!ObjectUtils.isEmpty(controllerFilter.getNameProduct())) {
            String compare = "%" + controllerFilter.getNameProduct() + "%";
            predicates.add(cb.like(root.get(Product_.nameProduct), compare));
        }

        return predicates.toArray(new Predicate[0]);

    }
}
