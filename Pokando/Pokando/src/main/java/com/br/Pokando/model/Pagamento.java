package com.br.Pokando.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "Pagamento")
@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nomecompleto", nullable = false)
    private String nomeCompleto;
    @Column(name = "cpf", nullable = false)
    private String cpf;
    @Column(name = "email", nullable = true)
    private String email;
    @Column(name = "nomecartao", nullable = true)
    private String nomeCartao;
    @Column(name = "numerocartao", nullable = false)
    private String numeroCartao;
    @Column(name = "validadecartao", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date validadeCartao;
    // falta o cvv
}
