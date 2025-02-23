package com.pisa.techtest.service.impl;

import com.pisa.techtest.domain.Cliente;
import com.pisa.techtest.repository.ClienteRepository;
import com.pisa.techtest.service.ClienteService;
import com.pisa.techtest.service.dto.ClienteDTO;
import com.pisa.techtest.service.mapper.ClienteMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    private final ClienteMapper clienteMapper = ClienteMapper.INSTANCE;

    public List<ClienteDTO> getAllClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream().map(clienteMapper::toDto).collect(Collectors.toList());
    }

    public ClienteDTO getClienteById(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado")
        );
        return clienteMapper.toDto(cliente);
    }

    public ClienteDTO saveCliente(ClienteDTO clienteDTO) {
        Cliente cliente = clienteMapper.toEntity(clienteDTO);
        Cliente savedCliente = clienteRepository.save(cliente);
        return clienteMapper.toDto(savedCliente);
    }

    public ClienteDTO updateCliente(String id, ClienteDTO clienteDTO) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado")
        );
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setGenero(clienteDTO.getGenero());
        cliente.setEdad(clienteDTO.getEdad());
        cliente.setDireccion(clienteDTO.getDireccion());
        cliente.setTelefono(clienteDTO.getTelefono());
        cliente.setEstado(clienteDTO.isEstado());
        Cliente updatedCliente = clienteRepository.save(cliente);
        return clienteMapper.toDto(updatedCliente);
    }

    public void deleteCliente(String id) {
        clienteRepository.deleteById(id);
    }
}