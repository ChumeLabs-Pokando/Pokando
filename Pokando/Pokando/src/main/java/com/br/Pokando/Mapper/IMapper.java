package com.br.Pokando.Mapper;

import com.br.Pokando.dto.EnderecoResponse;
import com.br.Pokando.model.Endereco;

import java.util.List;

/**
 *
 * @author 1513003
 * @param <E> Representa uma classe de Negócio, no pacote model
 * @param <RESP> Representa uma classe de DTO para resposta, na pasta dto
 * @param <CREATE_DTO> Representa uma classe de DTO para requisição para criação de objetos no banco de dados, na pasta dto
 * @param <UPDATE_DTO> Representa uma classe de DTO para requisição para atualização de objetos no banco de dados, na pasta dto
 */
public interface IMapper<E, RESP, CREATE_DTO, UPDATE_DTO> {

    public RESP toDto(E entity);

    EnderecoResponse toDto(Endereco entity);

    public E toEntity(CREATE_DTO request);

    public E update(UPDATE_DTO request, E entity);

    public List<RESP> toListDto(List<E> items);
}
