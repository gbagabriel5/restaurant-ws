package com.example.Restaurant.Service.impl;

import com.example.Restaurant.Service.ClientService;
import com.example.Restaurant.domain.Client;
import com.example.Restaurant.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl extends GenericServiceImpl<Client, Integer> implements ClientService {

    @Autowired
    private ClienteRepository repository;

    @Override
    public void trim(Client entity) {
    }
}