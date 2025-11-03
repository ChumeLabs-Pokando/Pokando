package com.br.Pokando.Mapper;

import com.br.Pokando.dto.*;
import com.br.Pokando.model.*;
import com.br.Pokando.repository.CategoriaIngressoRepository;
import com.br.Pokando.repository.EventoRepository;
import com.br.Pokando.repository.PagamentoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class IngressoMapper implements IMapper<Ingresso, IngressoResponse, IngressoRequest, IngressoRequest> {

    private final CategoriaIngressoMapper catMapper;
    private final CategoriaIngressoRepository catRepo;
    private final PagamentoMapper pMapper;
    private final PagamentoRepository pRepo;
    private final EventoRepository eventoRepo;

    public IngressoMapper(
            CategoriaIngressoMapper catMapper,
            CategoriaIngressoRepository catRepo,
            PagamentoMapper pMapper,
            PagamentoRepository pRepo,
            EventoRepository eventoRepo
    ) {
        this.catMapper = catMapper;
        this.catRepo = catRepo;
        this.pMapper = pMapper;
        this.pRepo = pRepo;
        this.eventoRepo = eventoRepo;
    }

    @Override
    public IngressoResponse toDto(Ingresso entity) {
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

        if (entity.getEvento() != null && !entity.getEvento().isEmpty()) {
            dto.setEventoIds(
                    entity.getEvento().stream()
                            .map(Evento::getId)
                            .collect(Collectors.toList())
            );
        }

        return dto;
    }

    @Override
    public List<IngressoResponse> toListDto(List<Ingresso> list) {
        return list.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }


    public Ingresso toEntity(IngressoRequest request,
                             CategoriaIngressoRepository catRepo,
                             PagamentoRepository pRepo,
                             EventoRepository eventoRepo) {

        var entity = new Ingresso();
        entity.setQuantidade(request.getQuantidade());
        entity.setStatus(request.isStatus());
        entity.setPresenca(request.isPresenca());
        entity.setDataPedido(request.getDataPedido());
        entity.setDataPagamento(request.getDataPagamento());
        entity.setGratuito(request.isGratuito());

        if (request.getCategoriaIngressoRequest() != null) {
            var cat = catRepo.findById(request.getCategoriaIngressoRequest().getId())
                    .orElseThrow(() -> new RuntimeException("Categoria do ingresso não encontrada"));
            entity.setCategoriaIngresso(cat);
        }

        if (request.getPagamentoRequest() != null) {
            var pag = pRepo.findById(request.getPagamentoRequest().getId())
                    .orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));
            entity.setPagamento(pag);
        }

        if (request.getEventoId() != null && !request.getEventoId().isEmpty()) {
            List<Evento> eventos = request.getEventoId().stream()
                    .map(id -> eventoRepo.findById(id)
                            .orElseThrow(() -> new RuntimeException("Evento não encontrado com ID " + id)))
                    .collect(Collectors.toList());
            entity.setEvento(eventos);
        }

        return entity;
    }


    @Override
    public Ingresso toEntity(IngressoRequest request) {
        return toEntity(request, catRepo, pRepo, eventoRepo);
    }

    @Override
    public Ingresso update(IngressoRequest request, Ingresso entity) {
        entity.setQuantidade(request.getQuantidade());
        entity.setStatus(request.isStatus());
        entity.setPresenca(request.isPresenca());
        entity.setDataPedido(request.getDataPedido());
        entity.setDataPagamento(request.getDataPagamento());
        entity.setGratuito(request.isGratuito());

        if (request.getCategoriaIngressoRequest() != null) {
            var cat = catRepo.findById(request.getCategoriaIngressoRequest().getId())
                    .orElseThrow(() -> new RuntimeException("Categoria do ingresso não encontrada"));
            entity.setCategoriaIngresso(cat);
        }

        if (request.getPagamentoRequest() != null) {
            var pag = pRepo.findById(request.getPagamentoRequest().getId())
                    .orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));
            entity.setPagamento(pag);
        }

        if (request.getEventoId() != null && !request.getEventoId().isEmpty()) {
            List<Evento> eventos = request.getEventoId().stream()
                    .map(id -> eventoRepo.findById(id)
                            .orElseThrow(() -> new RuntimeException("Evento não encontrado com ID " + id)))
                    .collect(Collectors.toList());
            entity.setEvento(eventos);
        }

        return entity;
    }
}
