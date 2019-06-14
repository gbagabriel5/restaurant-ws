package com.example.Restaurant.Service.impl;

import com.example.Restaurant.Service.ProdutoService;
import com.example.Restaurant.dto.ProdutoDto;
import com.example.Restaurant.exceptions.DefaultException;
import com.example.Restaurant.model.Produto;
import com.example.Restaurant.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private ProdutoFilter produtoFilter;

    @Override
    public Produto findById(Integer id) {
        Assert.notNull(id, "id.not.informed");
        Optional<Produto> optionalProduto = repository.findById(id);
        if (!optionalProduto.isPresent())
            throw new DefaultException("product.not.found");
        return optionalProduto.get();
    }

    @Override
    public ProdutoDto save(ProdutoDto produtoDto) {
        int est= produtoDto.getProestoque();
        int estm= produtoDto.getProestm();
        if(est>=estm){
            produtoDto.setProstatus("OK");
        }else{
            produtoDto.setProstatus("Baixo");
        }
        Produto produto = produtoDto.toModel();
        produto = repository.save(produto);
        return produto.toDto();
    }

    @Override
    public Page<ProdutoDto> getAll(Pageable pageable, String name, String sortBy, String direction) {
        FilterManager<Produto> filterManager = new FilterManager<>(produtoFilter);

        filterManager.addParameter("pronome", "%" + name + "%");

        if(direction.equals("ASC")){
            filterManager.orderBy(sortBy).asc();
        }else {
            filterManager.orderBy(sortBy).desc();
        }

        List<Produto> produtos = filterManager.findByFilter();

        List<ProdutoDto> produtoDtos = new ArrayList<>();

        produtos.forEach(produto -> produtoDtos.add(produto.toDto()));
        Long pageInit = pageable.getOffset();
        Long pageEnd = (pageInit + pageable.getPageSize()) > produtoDtos.size() ? produtoDtos.size() : (pageInit + pageable.getPageSize());

        return new PageImpl<>(produtoDtos.subList(pageInit.intValue(), pageEnd.intValue()), pageable, produtoDtos.size());
    }

    @Override
    public ProdutoDto update(ProdutoDto produtoDto) {
        Assert.notNull(produtoDto.getProcod(), "id.not.informed");
        return save(produtoDto);
    }

    @Override
    public void delete(Integer id) {
        Assert.notNull(id, "id.not.informed");
        Produto produto = findById(id);
        repository.delete(produto);
    }
}