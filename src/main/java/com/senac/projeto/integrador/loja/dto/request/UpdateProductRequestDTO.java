package com.senac.projeto.integrador.loja.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductRequestDTO {
    private Integer id;
    private String nameProduct;
    private String description;
    private Double assessmentProduct;
    private Double priceProduct;
    private Integer stockQuantity;
}
