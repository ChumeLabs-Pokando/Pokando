package com.br.Pokando.Mapper;

import com.br.Pokando.dto.CargoRequest;
import com.br.Pokando.dto.CargoResponse;
import com.br.Pokando.dto.EstadoRequest;
import com.br.Pokando.dto.EstadoResponse;
import com.br.Pokando.model.Cargo;
import com.br.Pokando.model.Estado;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CargoMapper implements IMapper<Cargo, CargoResponse, CargoRequest, CargoRequest> {

    @Override
    public CargoResponse toDto(
            Cargo entity
    ) {
        CargoResponse dto = new CargoResponse(
                entity.getId(),
                entity.getNome()

        );
        return dto;
    }

    @Override
    public List<CargoResponse> toListDto(
            List<Cargo> list
    ) {
        return list.stream()
                .map((entity) -> toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public Cargo toEntity(CargoRequest request) {
        return new Cargo(
                null,
                request.getNome()

        );
    }

    public Cargo toEntity(CargoResponse response) {
        return new Cargo(
                response.getId(),
                response.getNome()

        );
    }
    @Override
    public Cargo update(CargoRequest request, Cargo entity) {
        entity.setNome(request.getNome());
        return entity;
    }

}
