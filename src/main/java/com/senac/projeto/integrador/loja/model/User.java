package com.senac.projeto.integrador.loja.model;

import com.senac.projeto.integrador.loja.indicator.GroupIndicator;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_USUARIO", schema = "PUBLIC")
public class User implements UserDetails {

    @Id
    @Column(name = "EMAIL")
    private String email;

    @Column(name = "NOME")
    private String name;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "SENHA")
    private String password;

    @Column(name = "GRUPO")
    private GroupIndicator group;

    @Column(name = "ATIVO")
    private Boolean isActive;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.group == GroupIndicator.ADMIN) return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
