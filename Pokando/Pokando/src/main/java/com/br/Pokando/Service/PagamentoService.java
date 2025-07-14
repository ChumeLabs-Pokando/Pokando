package com.br.Pokando.Service;

import com.br.Pokando.Mapper.IMapper;
import com.br.Pokando.Mapper.PagamentoMapper;
import com.br.Pokando.dto.PagamentoRequest;
import com.br.Pokando.dto.PagamentoResponse;
import com.br.Pokando.model.Pagamento;
import com.br.Pokando.repository.PagamentoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService extends ServiceAdapter<Pagamento, Long, PagamentoResponse, PagamentoRequest,PagamentoRequest>{
    public PagamentoService(PagamentoRepository repository, PagamentoMapper mapper) {
        super(repository, mapper);
    }
}
