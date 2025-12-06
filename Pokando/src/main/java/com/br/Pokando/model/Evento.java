package com.br.Pokando.model;

import jakarta.persistence.*;
import lombok.*;

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
    private Boolean autorizado;
    @Column(name = "limite_inscricoes", nullable = false)
    private Double limiteInscricoes;
    @Column(name = "local", nullable = false)
    private String local;
    @ManyToMany(mappedBy = "acessoClienteEvento")
    private List<Cliente> cliente = new ArrayList<>();
    @ManyToMany(mappedBy = "acessoOrganizadorEvento")
    private List<Cliente> organizador = new ArrayList<>();
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
