package com.example.Restaurant.Service.impl;

import com.example.Restaurant.Service.ClientService;
import com.example.Restaurant.domain.Client;
import com.example.Restaurant.dto.ClientDto;
import com.example.Restaurant.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteServiceImpl extends GenericServiceImpl<Client, Integer> implements ClientService {
    @Autowired
    private ClientFilter clientFilter;

    private final ClientMapper clientMapper = new ClientMapper();

    @Override
    public void trim(Client entity) {
    }

    @Override
    public Page<ClientDto> getByName(Pageable pageable, String name, String orderBy, String direction) {
        FilterManager<Client> filterManager = new FilterManager<>(clientFilter);

        filterManager.addParameter("name", "%" + name + "%");
        if(direction.equals("ASC")){
            filterManager.orderBy(orderBy).asc();
        }else {
            filterManager.orderBy(orderBy).desc();
        }

        List<Client> clientList = filterManager.findByFilter();

        List<ClientDto> clientDtos= new ArrayList<>();

        clientList.forEach(item ->  clientDtos.add(clientMapper.convertToDTO(item)));
        Long pageInit = pageable.getOffset();
        Long pageEnd = (pageInit + pageable.getPageSize()) > clientDtos.size() ? clientDtos.size() : (pageInit + pageable.getPageSize());

        return new PageImpl<>(clientDtos.subList(pageInit.intValue(), pageEnd.intValue()), pageable, clientDtos.size());
    }
}