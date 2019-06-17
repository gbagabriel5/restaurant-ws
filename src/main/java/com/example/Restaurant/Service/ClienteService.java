package com.example.Restaurant.Service;

import com.example.Restaurant.dto.ClienteDto;
import com.example.Restaurant.model.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClienteService {

    Cliente findById(Integer id);

    ClienteDto save(ClienteDto clienteDto);

    Page<ClienteDto> getAll(Pageable pageable, String nome, String sortProperty, String direction);

    ClienteDto update(ClienteDto clienteDto);

    void delete(Integer id);

}
