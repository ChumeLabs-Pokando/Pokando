package com.br.Pokando.Service;


import com.br.Pokando.model.Endereco;
import com.br.Pokando.model.Estado;
import com.br.Pokando.repository.EstadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService {

    public EstadoRepository repository;

    public List<Estado> buscarTodos() {
        var lista = repository.findAll();
        return lista;


    }
}
