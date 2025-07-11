package com.br.Pokando.Service;


import com.br.Pokando.Mapper.CargoMapper;
import com.br.Pokando.dto.CargoRequest;
import com.br.Pokando.dto.CargoResponse;
import com.br.Pokando.model.Cargo;
import com.br.Pokando.repository.CargoRepository;
import org.springframework.stereotype.Service;

@Service
public class CargoService  extends ServiceAdapter<Cargo, Long, CargoResponse, CargoRequest,CargoRequest>{
    public CargoService(CargoRepository repository, CargoMapper mapper) {
        super(repository, mapper);
    }
}
