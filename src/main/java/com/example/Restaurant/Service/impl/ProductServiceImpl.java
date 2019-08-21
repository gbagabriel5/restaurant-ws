package com.example.Restaurant.Service.impl;

import com.example.Restaurant.Service.ProductService;
import com.example.Restaurant.domain.Product;
import com.example.Restaurant.domain.ProductItem;
import com.example.Restaurant.dto.ProductDto;
import com.example.Restaurant.mapper.ProductMapper;
import com.example.Restaurant.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl extends GenericServiceImpl<Product, Integer> implements ProductService {

    @Autowired
    private ProductItemRepository productItemRepository;

    @Autowired
    private ProductFilter productFilter;

    private ProductMapper productMapper = new ProductMapper();

    @Override
    public void trim(Product entity) {
    }

    private void saveItens(Product entity, Product productsave){
        for (ProductItem productItem: entity.getItemproduto()) {
            if(productsave.getControl().equals("Sim") && productsave.getQuantity()>=productsave.getMinQuantity())
                productsave.setStatus("OK");
            else if(productsave.getControl().equals("Sim") && productsave.getQuantity()<productsave.getMinQuantity())
                productsave.setStatus("Baixo");
            else
                productsave.setStatus("Sem Controle");
            productItem.setProduct(productsave);
            productItem.setItem(productItem.getItem());
            productItem.setQtde(productItem.getQtde());
            productItemRepository.save(productItem);
        }
    }

    @Override
    public Product add(Product entity) {
        try {
            Product productsave =super.add(entity);
            saveItens(entity, productsave);
            entity=productsave;
        } catch (Exception ex) {
            new Exception("Não foi possivel salvar o item"+ex);
        }
        return entity;
    }

    @Override
    public Page<ProductDto> getByName(Pageable pageable, String name, String orderBy, String direction) {
        FilterManager<Product> filterManager = new FilterManager<>(productFilter);

        filterManager.addParameter("name", "%" + name + "%");
        if(direction.equals("ASC")){
            filterManager.orderBy(orderBy).asc();
        }else {
            filterManager.orderBy(orderBy).desc();
        }

        List<Product> productList = filterManager.findByFilter();

        List<ProductDto> productDtos= new ArrayList<>();

        productList.forEach(products ->  productDtos.add(productMapper.convertToDTO(products)));
        Long pageInit = pageable.getOffset();
        Long pageEnd = (pageInit + pageable.getPageSize()) > productDtos.size() ? productDtos.size() : (pageInit + pageable.getPageSize());

        return new PageImpl<>(productDtos.subList(pageInit.intValue(), pageEnd.intValue()), pageable, productDtos.size());
    }
}