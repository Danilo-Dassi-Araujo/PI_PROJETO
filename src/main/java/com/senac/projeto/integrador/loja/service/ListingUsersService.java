package com.senac.projeto.integrador.loja.service;

import com.senac.projeto.integrador.loja.dto.response.ListingDTOResponse;
import com.senac.projeto.integrador.loja.filter.ControllerFilter;
import com.senac.projeto.integrador.loja.indicator.GroupIndicator;
import com.senac.projeto.integrador.loja.model.User;
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

    public List<ListingDTOResponse> getAllUsers(ControllerFilter controllerFilter, GroupIndicator groupIndicator) throws Exception {
        if (ObjectUtils.isEmpty(controllerFilter)) {
            return listAllUsers(groupIndicator);
        }

        if (GroupIndicator.ESTOQUISTA.equals(groupIndicator)) {
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

    private List<ListingDTOResponse> listAllUsers(GroupIndicator groupIndicator) throws Exception {
        if (GroupIndicator.ESTOQUISTA.equals(groupIndicator)) {
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
