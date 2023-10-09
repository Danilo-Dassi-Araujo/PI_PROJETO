package com.senac.projeto.integrador.loja.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Address.class)
@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public class Address_ {

    public static volatile SingularAttribute<Address, Integer> idEndereco;
    public static volatile SingularAttribute<Address, String> cep;
    public static volatile SingularAttribute<Address, String> logradouro;
    public static volatile SingularAttribute<Address, String> numero;
    public static volatile SingularAttribute<Address, String> complemento;
    public static volatile SingularAttribute<Address, String> bairro;
    public static volatile SingularAttribute<Address, String> cidade;
    public static volatile SingularAttribute<Address, String> uf;
    public static volatile SingularAttribute<Address, Client> client;

}
