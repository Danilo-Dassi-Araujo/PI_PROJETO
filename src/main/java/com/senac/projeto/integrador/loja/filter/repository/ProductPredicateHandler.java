package com.senac.projeto.integrador.loja.filter.repository;

import com.senac.projeto.integrador.loja.filter.ControllerFilter;
import com.senac.projeto.integrador.loja.model.Product;
import com.senac.projeto.integrador.loja.model.Product_;
import com.senac.projeto.integrador.loja.model.User;
import com.senac.projeto.integrador.loja.model.User_;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductPredicateHandler {

    public Predicate[] getPredicatesByFilter(ControllerFilter controllerFilter,
                                             Root<Product> root,
                                             CriteriaQuery<?> cq,
                                             CriteriaBuilder cb) {

        List<Predicate> predicates = new ArrayList<>();

        if (!ObjectUtils.isEmpty(controllerFilter.getName())) {
            String compare = "%" + controllerFilter.getName() + "%";
            predicates.add(cb.like(root.get(Product_.nameProduct), compare));
        }

        return predicates.toArray(new Predicate[0]);

    }
}
