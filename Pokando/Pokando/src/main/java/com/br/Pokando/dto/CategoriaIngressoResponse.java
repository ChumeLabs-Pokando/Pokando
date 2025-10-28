package com.br.Pokando.dto;


import lombok.*;

@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaIngressoResponse extends DefaultResponse{

   private String nome;
   private double preco;
   private boolean meiaEntrada;

    public CategoriaIngressoResponse(Long id) {
        super(id);
    }
    public CategoriaIngressoResponse(Long id, String nome, double preco, boolean meiaEntrada) {
        super(id);
        this.nome = nome;
        this.preco = preco;
        this.meiaEntrada = meiaEntrada;
    }
}
