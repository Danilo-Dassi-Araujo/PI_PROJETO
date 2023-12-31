package com.senac.projeto.integrador.loja.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ListingProductResponseDTO {

    private String nameProduct;
    private Integer id;
    private Integer stockProduct;
    private Double priceProduct;
    private Boolean isActive;
}
