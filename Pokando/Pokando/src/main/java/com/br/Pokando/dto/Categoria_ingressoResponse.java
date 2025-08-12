package com.br.Pokando.dto;


import lombok.*;

@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Categoria_ingressoResponse extends DefaultResponse{

   private String nome;
   private double preco;
   private boolean meiaEntrada;

    public Categoria_ingressoResponse(Long id) {
        super(id);
    }
    public Categoria_ingressoResponse(Long id, String nome, double preco, boolean meiaEntrada) {
        super(id);
        this.nome = nome;
        this.preco = preco;
        this.meiaEntrada = meiaEntrada;
    }
}
