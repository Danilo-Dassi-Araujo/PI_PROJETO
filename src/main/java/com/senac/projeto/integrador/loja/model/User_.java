package com.senac.projeto.integrador.loja.model;

import com.senac.projeto.integrador.loja.indicator.GroupIndicator;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(User.class)
@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public class User_ {

    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, GroupIndicator> group;
    public static volatile SingularAttribute<User, String> cpf;
    public static volatile SingularAttribute<User, String> name;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, Boolean> isActive;
}
