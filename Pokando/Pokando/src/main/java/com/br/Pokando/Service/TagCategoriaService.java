package com.br.Pokando.Service;

import com.br.Pokando.Mapper.TagCategoriaMapper;
import com.br.Pokando.dto.TagCategoriaRequest;
import com.br.Pokando.dto.TagCategoriaResponse;
import com.br.Pokando.model.TagCategoria;
import com.br.Pokando.repository.TagCategoriaRepository;
import org.springframework.stereotype.Service;

@Service
public class TagCategoriaService extends ServiceAdapter<TagCategoria, Long, TagCategoriaResponse, TagCategoriaRequest, TagCategoriaRequest>{

    public TagCategoriaService(TagCategoriaRepository repository, TagCategoriaMapper mapper) {
        super(repository, mapper);
    }
}
