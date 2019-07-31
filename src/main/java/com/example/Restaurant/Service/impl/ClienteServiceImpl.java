package com.example.Restaurant.Service.impl;

import com.example.Restaurant.Service.ClientService;
import com.example.Restaurant.domain.Client;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl extends GenericServiceImpl<Client, Integer> implements ClientService {
    @Override
    public void trim(Client entity) {
    }
}