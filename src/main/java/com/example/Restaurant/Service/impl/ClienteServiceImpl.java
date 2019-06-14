package com.example.Restaurant.Service.impl;

import com.example.Restaurant.Service.ClienteService;
import com.example.Restaurant.dto.ClienteDto;
import com.example.Restaurant.exceptions.DefaultException;
import com.example.Restaurant.model.Cliente;
import com.example.Restaurant.repository.ClienteRepository;
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
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ClienteFilter clienteFilter;

    @Override
    public Cliente findById(Integer id) {
        Assert.notNull(id, "id.not.informed");
        Optional<Cliente> optionalCliente = repository.findById(id);
        if (!optionalCliente.isPresent())
            throw new DefaultException("cliente.not.found");
        return optionalCliente.get();
    }

    @Override
    public ClienteDto save(ClienteDto clienteDto) {
        Cliente cliente = clienteDto.toModel();
//        Utils.checkIfNameExist(cliente.getClinome(), repository);
        cliente = repository.save(cliente);
        return cliente.toDto();
    }

    @Override
    public Page<ClienteDto> getAll(Pageable pageable, String name, String sortBy, String direction) {
        FilterManager<Cliente> filterManager = new FilterManager<>(clienteFilter);

        filterManager.addParameter("clinome", "%" + name + "%");

        if(direction.equals("ASC")){
            filterManager.orderBy(sortBy).asc();
        }else {
            filterManager.orderBy(sortBy).desc();
        }

        List<Cliente> clients = filterManager.findByFilter();

        List<ClienteDto> clientDtos = new ArrayList<>();

        clients.forEach(client -> clientDtos.add(client.toDto()));
        Long pageInit = pageable.getOffset();
        Long pageEnd = (pageInit + pageable.getPageSize()) > clientDtos.size() ? clientDtos.size() : (pageInit + pageable.getPageSize());

        return new PageImpl<>(clientDtos.subList(pageInit.intValue(), pageEnd.intValue()), pageable, clientDtos.size());
    }

    @Override
    public ClienteDto update(ClienteDto clienteDto) {
        Assert.notNull(clienteDto.getClicod(), "id.not.informed");
        return save(clienteDto);
    }

    @Override
    public void delete(Integer id) {
        Assert.notNull(id, "id.not.informed");
        Cliente cliente = findById(id);
        repository.delete(cliente);
    }
}