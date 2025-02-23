package com.pisa.techtest.service;

import com.pisa.techtest.service.dto.ClienteDTO;

import java.util.List;

public interface ClienteService {

    public List<ClienteDTO> getAllClientes();

    public ClienteDTO getClienteById(Long id);

    public ClienteDTO saveCliente(ClienteDTO clienteDTO);

    public ClienteDTO updateCliente(String id, ClienteDTO clienteDTO);

    public void deleteCliente(String id);
}
