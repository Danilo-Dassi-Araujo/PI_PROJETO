package com.senac.projeto.integrador.loja.service;

import com.senac.projeto.integrador.loja.dto.response.ListingDTOResponse;
import com.senac.projeto.integrador.loja.filter.ControllerFilter;
import com.senac.projeto.integrador.loja.indicator.GroupIndicator;
import com.senac.projeto.integrador.loja.model.Session;
import com.senac.projeto.integrador.loja.model.User;
import com.senac.projeto.integrador.loja.repository.SessionRepository;
import com.senac.projeto.integrador.loja.repository.UserRepository;
import com.senac.projeto.integrador.loja.repository.specification.UserSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ListingUsersService {

    private final UserRepository userRepository;
    private final UserSpecification userSpecification;
    private final SessionRepository sessionRepository;

    public List<ListingDTOResponse> getAllUsers(ControllerFilter controllerFilter) throws Exception {
        Session sessionUser = sessionRepository.findFirstByOrderByIdDesc();
        if (ObjectUtils.isEmpty(controllerFilter.getName())) {
            return listAllUsers(sessionUser.getRole());
        }

        if (GroupIndicator.ESTOQUISTA.getGroupName().equals(sessionUser.getRole())) {
            throw new Exception("Você não tem permissão para listar usuários");
        }

        List<User> byUsers = userSpecification.findBy(controllerFilter);
        List<ListingDTOResponse> usersList = new ArrayList<>();

        for (User user : byUsers) {
            ListingDTOResponse build = ListingDTOResponse
                    .builder()
                    .cpf(user.getCpf())
                    .name(user.getName())
                    .email(user.getEmail())
                    .groupIndicator(user.getGroup().getGroupName())
                    .isActive(user.getIsActive())
                    .build();
            usersList.add(build);
        }
        return usersList;
    }

    private List<ListingDTOResponse> listAllUsers(String role) throws Exception {
        if (GroupIndicator.ESTOQUISTA.getGroupName().equals(role)) {
            throw new Exception("Você não tem permissão para listar usuários");
        }

        List<User> allUsers = userRepository.findAll();
        List<ListingDTOResponse> usersList = new ArrayList<>();

        for (User user : allUsers) {
            ListingDTOResponse build = ListingDTOResponse
                    .builder()
                    .cpf(user.getCpf())
                    .name(user.getName())
                    .email(user.getEmail())
                    .groupIndicator(user.getGroup().getGroupName())
                    .isActive(user.getIsActive())
                    .build();
            usersList.add(build);
        }
        return usersList;
    }
}
