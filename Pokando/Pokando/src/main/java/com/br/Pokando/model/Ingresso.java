package com.br.Pokando.model;

import com.br.Pokando.model.heranca.Cliente;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Ingresso")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ingresso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "quantidade", nullable = false)
    private double quantidade;
    @Column(name = "status", nullable = false)
    private boolean status;
    @Column(name = "presenca", nullable = false)
    private boolean presenca;
    @Column(name = "dataPedido", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate dataPedido;
    @Column(name = "dataPagamento", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate dataPagamento;
    @Column(name = "gratuito", nullable = false)
    private boolean gratuito;
    @ManyToOne(optional = false)
    @JoinColumn(name = "categoria_ingresso_id", nullable = false)
    private CategoriaIngresso categoriaIngresso;
    @ManyToOne(optional = false)
    @JoinColumn(name = "pagamento_id", nullable = false)
    private Pagamento pagamento;
    @ManyToMany(mappedBy = "ingresso")
    private List<Evento> evento;

    public Ingresso(Long id) {
        this.id = id;
    }



}


