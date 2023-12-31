package com.senac.projeto.integrador.loja.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductListingRequest {
    private String nameProduct;
    private int page;
    private int maxItems;
}
