package com.example.Restaurant.Service;

import com.example.Restaurant.model.BaseEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface GenericService<T extends BaseEntity<I>, I> {

    List<T> getAll();

    Page<T> getAllPaginated(Pageable pageable);

    Page<T> getAllPaginated(Example<T> example, Pageable pageable);

}
