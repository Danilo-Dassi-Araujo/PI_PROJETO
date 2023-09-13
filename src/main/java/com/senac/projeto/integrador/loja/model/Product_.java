package com.senac.projeto.integrador.loja.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Product.class)
@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public class Product_ {

    public static volatile SingularAttribute<Product, String> nameProduct;
    public static volatile SingularAttribute<Product, Integer> id;
    public static volatile SingularAttribute<Product, String> descriptionProduct;
    public static volatile SingularAttribute<Product, Double> assessmentProduct;
    public static volatile SingularAttribute<Product, Double> priceProduct;
    public static volatile SingularAttribute<Product, Integer> stockQuantity;
    public static volatile SingularAttribute<Product, Boolean> isActive;
}
