package com.senac.projeto.integrador.loja.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.time.LocalDate;

@StaticMetamodel(Client.class)
@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public class Client_ {

    public static volatile SingularAttribute<Client, String> email;
    public static volatile SingularAttribute<Client, String> nomeCompleto;
    public static volatile SingularAttribute<Client, LocalDate> dataNascimento;
    public static volatile SingularAttribute<Client, String> genero;
}
