package com.senac.projeto.integrador.loja.repository.specification;

import com.senac.projeto.integrador.loja.filter.ControllerFilter;
import com.senac.projeto.integrador.loja.filter.repository.UserPredicateHandler;
import com.senac.projeto.integrador.loja.model.User;
import com.senac.projeto.integrador.loja.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserSpecification {

    private final UserRepository userRepository;
    private final UserPredicateHandler userPredicateHandler;

    public List<User> findBy(ControllerFilter controllerFilter) {
        Specification<User> specification = (root, criteriaQuery, criteriaBuilder) ->
                criteriaQuery
                        .where(userPredicateHandler.getPredicatesByFilter(controllerFilter, root, criteriaQuery, criteriaBuilder))
                        .getRestriction();
        return userRepository.findAll(specification);
    }
}