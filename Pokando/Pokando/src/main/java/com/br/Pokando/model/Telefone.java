package com.br.Pokando.model;

import com.br.Pokando.model.heranca.Usuario;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Telefone")
@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "numero")
    private String numero;
    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;
    @ManyToOne(optional = false)
    @JoinColumn(name = "organizador_id", nullable = true)
    private Organizador organizador;
   // @ManyToOne(optional = false)
  //  @JoinColumn(name = "proprietario_id", nullable = false)
 //   private Proprietario proprietario;

}
