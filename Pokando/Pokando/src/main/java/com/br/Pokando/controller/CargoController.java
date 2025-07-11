package com.br.Pokando.controller;

import com.br.Pokando.Mapper.CargoMapper;
import com.br.Pokando.Service.CargoService;
import com.br.Pokando.dto.CargoRequest;
import com.br.Pokando.dto.CargoResponse;
import com.br.Pokando.model.Cargo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cargo")
public class CargoController extends CRUDDefaultControllerAdapter<Cargo, Long, CargoResponse, CargoRequest, CargoRequest>{
    public CargoController(CargoService service, CargoMapper mapper) {
        super(service, mapper);
    }
}
