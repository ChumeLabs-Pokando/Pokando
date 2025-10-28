package com.br.Pokando.dto;

import com.br.Pokando.model.EnderecoGeografico;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoGeograficoResponse extends DefaultResponse{

    private String latitude;

    private String longitude;

    public EnderecoGeograficoResponse(Long id) {
        super(id);
    }
    public EnderecoGeograficoResponse(Long id, String latitude, String longitude) {
        super(id);
        this.latitude = latitude;
        this.longitude = longitude;
    }

}
