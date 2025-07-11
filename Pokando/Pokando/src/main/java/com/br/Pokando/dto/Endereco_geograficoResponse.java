package com.br.Pokando.dto;

import com.br.Pokando.model.Endereco_geografico;
import lombok.*;

@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco_geograficoResponse extends DefaultResponse{

    public String latitude;

    public String longitude;

    public Endereco_geograficoResponse(Long id) {
        super(id);
    }
    public Endereco_geograficoResponse(Long id, String latitude, String longitude) {
        super(id);
        this.latitude = latitude;
        this.longitude = longitude;
    }

}
