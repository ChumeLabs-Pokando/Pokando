package com.br.Pokando.model;

import com.br.Pokando.model.heranca.Cliente;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Evento")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "descricao", nullable = true)
    private String descricao;
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusEvento statusEvento;
    @Column(name = "datahora", nullable = false)
    private Date dataHora;
    @Column(name = "autorizado", nullable = false)
    private boolean autorizado;
    @Column(name = "limite_inscricoes", nullable = false)
    private double limiteInscricoes;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "organizador_evento",
            joinColumns = @JoinColumn(name = "evento_id"),
            inverseJoinColumns = @JoinColumn(name = "organizador_id")
    )
    private List<Organizador> organizador = new ArrayList<>();
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "cliente_evento",
            joinColumns = @JoinColumn(name = "evento_id"),
            inverseJoinColumns = @JoinColumn(name = "cliente_id")
    )
    private List<Cliente> cliente = new ArrayList<>();
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "evento_ingresso",
            joinColumns = @JoinColumn(name = "evento_id"),
            inverseJoinColumns = @JoinColumn(name = "ingresso_id")
    )
    private List<Ingresso> ingresso = new ArrayList<>();

    public Evento(Long id) {
        this.id = id;
    }


}
