package com.br.Pokando.Mapper;

import com.br.Pokando.dto.TelefoneRequest;
import com.br.Pokando.dto.TelefoneResponse;
import com.br.Pokando.model.Cliente;
import com.br.Pokando.model.Organizador;
import com.br.Pokando.model.heranca.Usuario;
import com.br.Pokando.model.Telefone;

import com.br.Pokando.repository.ClienteRepository;
import com.br.Pokando.repository.OrganizadorRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TelefoneMapper implements IMapper<Telefone, TelefoneResponse, TelefoneRequest, TelefoneRequest>{

    private final ClienteMapper clienteMapper;
    private final ClienteRepository clienteRepository;

    private final OrganizadorMapper organizadorMapper;
    private final OrganizadorRepository organizadorRepository;

    //private final ProprietarioMapper proprietarioMapper;
    //private final ProprietarioRepository proprietarioRepository;

    public TelefoneMapper(ClienteMapper clienteMapper, ClienteRepository clienteRepository, OrganizadorMapper organizadorMapper, OrganizadorRepository organizadorRepository) {
        this.clienteMapper = clienteMapper;
        this.clienteRepository = clienteRepository;
        this.organizadorMapper = organizadorMapper;
        this.organizadorRepository = organizadorRepository;
    }

    @Override
    public TelefoneResponse toDto(
            Telefone entity
    ) {
        TelefoneResponse dto = new TelefoneResponse(entity.getId());
        dto.setNumero(entity.getNumero());

        if (entity.getCliente() != null) {
            dto.setCliente(clienteMapper.toDto(entity.getCliente()));
        }
        if (entity.getOrganizador() != null) {
            dto.setOrganizador(organizadorMapper.toDto(entity.getOrganizador()));
        }
       // if (entity.getProprietario() != null) {
        //    dto.setProprietario(proprietarioMapper.toDto(entity.getProprietario()));
        //}

        return dto;
    }

    @Override
    public List<TelefoneResponse> toListDto(
            List<Telefone> list
    ) {
        return list.stream()
                .map((entity) -> toDto(entity))
                .collect(Collectors.toList());
    }


    public Telefone toEntity(TelefoneRequest request, ClienteRepository clienteRepository, OrganizadorRepository organizadorRepository) {
        var entity = new Telefone();
        entity.setNumero(request.getNumero());


        if (request.getClienteRequest() != null) {
            var Cliente = clienteRepository
                    .findById(request.getClienteRequest().getId())
                    .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
            entity.setCliente(Cliente);
        }
        if (request.getOrganizadorRequest() != null) {
            var Organizador = organizadorRepository
                    .findById(request.getOrganizadorRequest().getId())
                    .orElseThrow(() -> new RuntimeException("Organizador não encontrado"));
            entity.setOrganizador(Organizador);
        }
     //   if (request.getProprietario() != null) {
    //        var Proprietario = proprietarioRepository
     //               .findById(request.getProprietario().getId())
      //              .orElseThrow(() -> new RuntimeException("Proprietario não encontrado"));
    //        entity.setProprietario(Proprietario);
   //     }


        return entity;
    }
    @Override
    public Telefone toEntity(TelefoneRequest request) {
        var entity = new Telefone();
        entity.setNumero(request.getNumero());


        if (request.getClienteRequest() != null) {
            var Cliente = clienteRepository
                    .findById(request.getClienteRequest().getId())
                    .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
            entity.setCliente(Cliente);
        }
        if (request.getOrganizadorRequest() != null) {
            var Organizador = organizadorRepository
                    .findById(request.getOrganizadorRequest().getId())
                    .orElseThrow(() -> new RuntimeException("Organizador não encontrado"));
            entity.setOrganizador(Organizador);
        }
        //   if (request.getProprietario() != null) {
        //        var Proprietario = proprietarioRepository
        //               .findById(request.getProprietario().getId())
        //              .orElseThrow(() -> new RuntimeException("Proprietario não encontrado"));
        //        entity.setProprietario(Proprietario);
        //     }

        return entity;
    }

    @Override
    public Telefone update(TelefoneRequest request, Telefone entity) {
        entity.setNumero(request.getNumero());


        if (request.getClienteRequest() != null && request.getClienteRequest().getId() != null) {
            Cliente cliente = clienteRepository.findById(request.getClienteRequest().getId())
                    .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
            entity.setCliente(cliente);
        }
        if (request.getOrganizadorRequest() != null && request.getOrganizadorRequest().getId() != null) {
            Organizador organizador = organizadorRepository.findById(request.getOrganizadorRequest().getId())
                    .orElseThrow(() -> new RuntimeException("Organizador não encontrado"));
            entity.setOrganizador(organizador);
        }
       // if (request.getProprietarioRequest() != null && request.getProprietarioRequest().getId() != null) {
       //     Proprietario proprietario = proprietarioRepository.findById(request.getProprietarioRequest().getId())
      //              .orElseThrow(() -> new RuntimeException("Proprietario não encontrado"));
      //      entity.setProprietario(proprietario);
     //   }


        return entity;
    }
}

