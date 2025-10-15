package com.br.Pokando.controller;

import com.br.Pokando.Mapper.TagCategoriaMapper;
import com.br.Pokando.Service.TagCategoriaService;
import com.br.Pokando.dto.TagCategoriaRequest;
import com.br.Pokando.dto.TagCategoriaResponse;
import com.br.Pokando.model.TagCategoria;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tag-categoria")
public class TagCategoriaController extends CRUDDefaultControllerAdapter<TagCategoria, Long, TagCategoriaResponse, TagCategoriaRequest, TagCategoriaRequest> {

    public TagCategoriaController(TagCategoriaService service, TagCategoriaMapper mapper) {
        super(service, mapper);
    }
}
