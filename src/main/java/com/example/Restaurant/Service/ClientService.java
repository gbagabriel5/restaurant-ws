package com.example.Restaurant.Service;

import com.example.Restaurant.domain.Client;
import com.example.Restaurant.dto.ClientDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientService extends GenericService<Client, Integer>{
    Page<ClientDto> getByName(Pageable pageable, String name, String orderBy, String direction);
}