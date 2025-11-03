package com.br.Pokando.Mapper;

import com.br.Pokando.dto.PagamentoRequest;
import com.br.Pokando.dto.PagamentoResponse;
import com.br.Pokando.model.Pagamento;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PagamentoMapper implements IMapper<Pagamento, PagamentoResponse, PagamentoRequest, PagamentoRequest>{


    @Override
    public PagamentoResponse toDto(
            Pagamento entity
    ) {
        PagamentoResponse dto = new PagamentoResponse(
                entity.getId(),
                entity.getNomeCompleto(),
                entity.getCpf(),
                entity.getEmail(),
                entity.getNomeCartao(),
                entity.getNumeroCartao(),
                entity.getValidadeCartao()

        );
        return dto;
    }

    @Override
    public List<PagamentoResponse> toListDto(
            List<Pagamento> list
    ) {
        return list.stream()
                .map((entity) -> toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public Pagamento toEntity(PagamentoRequest request) {
        return new Pagamento(
                null,
                request.getNomeCompleto(),
                request.getCpf(),
                request.getEmail(),
                request.getNomeCartao(),
                request.getNumeroCartao(),
                request.getValidadeCartao()
        );
    }

    public Pagamento toEntity(PagamentoResponse response) {
        return new Pagamento(
                response.getId(),
                response.getNomeCompleto(),
                response.getCpf(),
                response.getEmail(),
                response.getNomeCartao(),
                response.getNumeroCartao(),
                response.getValidadeCartao()
        );
    }

    @Override
    public Pagamento update(PagamentoRequest request, Pagamento entity) {
        entity.setNomeCompleto(request.getNomeCompleto());
        entity.setCpf(request.getCpf());
        entity.setEmail(request.getEmail());
        entity.setNomeCartao(request.getNomeCartao());
        entity.setNumeroCartao(request.getNumeroCartao());
        entity.setValidadeCartao(request.getValidadeCartao());
        return entity;
    }
}
