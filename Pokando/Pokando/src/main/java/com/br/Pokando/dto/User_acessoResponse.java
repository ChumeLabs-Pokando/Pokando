package com.br.Pokando.dto;


import lombok.*;

@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User_acessoResponse extends DefaultResponse{

    private String nome;

    public User_acessoResponse(Long id) {
        super(id);
    }
    public User_acessoResponse(Long id, String nome) {
        super(id);
        this.nome = nome;
    }

}
