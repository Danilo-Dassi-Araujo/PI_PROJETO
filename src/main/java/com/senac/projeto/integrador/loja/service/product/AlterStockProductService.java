package com.senac.projeto.integrador.loja.service.product;

import com.senac.projeto.integrador.loja.builder.ProductStockBuilder;
import com.senac.projeto.integrador.loja.model.Product;
import com.senac.projeto.integrador.loja.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
@RequiredArgsConstructor
public class AlterStockProductService {

    private final ProductRepository productRepository;

    public void alterStock(Integer id, Integer newProductStock) throws Exception {
        if(ObjectUtils.isEmpty(id)){
            throw new Exception("O id está vazio");
        }

        if(newProductStock < 0){
            throw new Exception("A quantidade não pode ser menor que 0.");
        }

        Product product = productRepository.findById(id).orElse(null);

        if(ObjectUtils.isEmpty(product)){
            throw new Exception("O produto não foi encontrado!");
        }

        product.setStockQuantity(newProductStock);
        Product productToSave = ProductStockBuilder.buildFrom(product);
        productRepository.save(productToSave);
    }
}
