package com.br.Pokando.Mapper;

import com.br.Pokando.dto.*;
import com.br.Pokando.dto.IngressoRequest;
import com.br.Pokando.model.*;
import com.br.Pokando.model.Ingresso;
import com.br.Pokando.model.Ingresso;
import com.br.Pokando.repository.Categoria_ingressoRepository;
import com.br.Pokando.repository.PagamentoRepository;
import com.br.Pokando.repository.PaisRepository;
import com.br.Pokando.repository.UserAcessoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class IngressoMapper implements IMapper<Ingresso, IngressoResponse, IngressoRequest, IngressoRequest>{

    private final Categoria_ingressoMapper catMapper;
    private final Categoria_ingressoRepository catRepo;
    private final PagamentoMapper pMapper;
    private final PagamentoRepository pRepo;


    public IngressoMapper(Categoria_ingressoMapper catMapper, Categoria_ingressoRepository catRepo, PagamentoMapper pMapper, PagamentoRepository pRepo) {
        this.catMapper = catMapper;
        this.catRepo = catRepo;
        this.pMapper = pMapper;
        this.pRepo = pRepo;
    }

    @Override
    public IngressoResponse toDto(
            Ingresso entity
    ) {
        IngressoResponse dto = new IngressoResponse(entity.getId());
        dto.setQuantidade(entity.getQuantidade());
        dto.setStatus(entity.isStatus());
        dto.setPresenca(entity.isPresenca());
        dto.setDataPedido(entity.getDataPedido());
        dto.setDataPagamento(entity.getDataPagamento());
        dto.setGratuito(entity.isGratuito());


        if (entity.getCategoriaIngresso() != null) {
            dto.setCategoriaIngressoResponse(catMapper.toDto(entity.getCategoriaIngresso()));
        }


        if (entity.getPagamento() != null) {
            dto.setPagamentoResponse(pMapper.toDto(entity.getPagamento()));
        }

        return dto;
    }

    @Override
    public List<IngressoResponse> toListDto(
            List<Ingresso> list
    ) {
        return list.stream()
                .map((entity) -> toDto(entity))
                .collect(Collectors.toList());
    }

    public Ingresso toEntity(IngressoRequest request, Categoria_ingressoRepository catRepo, PagamentoRepository pRepo) {
        var entity = new Ingresso();
        entity.setQuantidade(request.getQuantidade());
        entity.setStatus(request.isStatus());
        entity.setPresenca(request.isPresenca());
        entity.setDataPedido(request.getDataPedido());
        entity.setDataPagamento(request.getDataPagamento());
        entity.setGratuito(request.isGratuito());

        if (request.getCategoriaIngressoRequest() != null) {
            var cat = catRepo
                    .findById(request.getCategoriaIngressoRequest().getId())
                    .orElseThrow(() -> new RuntimeException("Categoria do ingresso não encontrado"));
            entity.setCategoriaIngresso(cat);
        }
        if (request.getPagamentoRequest() != null) {
            var pag = pRepo
                    .findById(request.getPagamentoRequest().getId())
                    .orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));
            entity.setPagamento(pag);
        }

        return entity;
    }
    @Override
    public Ingresso toEntity(IngressoRequest request) {
        var entity = new Ingresso();
        entity.setQuantidade(request.getQuantidade());
        entity.setStatus(request.isStatus());
        entity.setPresenca(request.isPresenca());
        entity.setDataPedido(request.getDataPedido());
        entity.setDataPagamento(request.getDataPagamento());
        entity.setGratuito(request.isGratuito());

        if (request.getCategoriaIngressoRequest() != null && request.getCategoriaIngressoRequest().getId() != null) {
            Categoria_ingresso catIngresso = catRepo.findById(request.getCategoriaIngressoRequest().getId())
                    .orElseThrow(() -> new RuntimeException("Categoria do Ingresso não encontrado"));
            entity.setCategoriaIngresso(catIngresso);
        }
        if (request.getPagamentoRequest() != null && request.getPagamentoRequest().getId() != null) {
            Pagamento pag = pRepo.findById(request.getPagamentoRequest().getId())
                    .orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));
            entity.setPagamento(pag);
        }

        return entity;


    }
    @Override
    public Ingresso update(IngressoRequest request, Ingresso entity) {
        entity.setQuantidade(request.getQuantidade());
        entity.setStatus(request.isStatus());
        entity.setPresenca(request.isPresenca());
        entity.setDataPedido(request.getDataPedido());
        entity.setDataPagamento(request.getDataPagamento());
        entity.setGratuito(request.isGratuito());

        if (request.getCategoriaIngressoRequest() != null && request.getCategoriaIngressoRequest().getId() != null) {
            Categoria_ingresso catIngresso = catRepo.findById(request.getCategoriaIngressoRequest().getId())
                    .orElseThrow(() -> new RuntimeException("Categoria do Ingresso não encontrado"));
            entity.setCategoriaIngresso(catIngresso);
        }
        if (request.getPagamentoRequest() != null && request.getPagamentoRequest().getId() != null) {
            Pagamento pag = pRepo.findById(request.getPagamentoRequest().getId())
                    .orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));
            entity.setPagamento(pag);
        }
        return entity;
    }
    
}
