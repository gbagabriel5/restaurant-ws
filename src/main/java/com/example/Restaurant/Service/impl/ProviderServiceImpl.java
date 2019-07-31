package com.example.Restaurant.Service.impl;

import com.example.Restaurant.Service.ProviderService;
import com.example.Restaurant.domain.Provider;
import org.springframework.stereotype.Service;

@Service
public class ProviderServiceImpl extends GenericServiceImpl<Provider, Integer> implements ProviderService {
    @Override
    public void trim(Provider entity) {
    }
}