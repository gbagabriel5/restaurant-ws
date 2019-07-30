package com.example.Restaurant.controller;

import com.example.Restaurant.Service.GenericService;
import com.example.Restaurant.annotation.DefaultParamsPagedList;
import com.example.Restaurant.domain.BaseEntity;
import com.example.Restaurant.mapper.GenericMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;

public interface ListRest<E extends BaseEntity<I>, D, I> {
    @GetMapping
    @ApiOperation(value = "List all")
    @DefaultParamsPagedList
    default Page<D> getAll(Integer page, Integer count, String order, String sortProperty){
        Page<E> pages = getService().getAllPaginated(PagingUtils.createPageRequest(page, count, order, sortProperty));
        return getMapper().convertToSliceDTO(pages);
    }
    GenericMapper<E, D> getMapper();

    GenericService<E, I> getService();
}