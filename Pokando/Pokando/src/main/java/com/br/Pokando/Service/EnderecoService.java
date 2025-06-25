/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.Pokando.Service;

import com.br.Pokando.model.Endereco;
import com.br.Pokando.repository.EnderecoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author felip
 */
@Service
public class EnderecoService {

    public final EnderecoRepository repository;

    public EnderecoService(EnderecoRepository repository) {
        this.repository = repository;

    }

    public Endereco salvarEndereco(Endereco endereco) {
        var saved = repository.save(endereco);
       return saved;
    }

    /*public Optional<Endereco> buscarPorLogradouro(String logradouro) {
        return Optional.ofNullable(repository.findByLogradouro(logradouro).orElseThrow(
                () -> new RuntimeException("Logradouro não encontrado")
        ));*/

    public Optional<Endereco> buscarPorLogradouro(String logradouro) {
        // Busca todos e retorna o primeiro encontrado (ou você pode retornar a lista inteira se preferir)
        return repository
                .findByLogradouroContainingIgnoreCase(logradouro)
                .stream()
                .findFirst();
    }

    // ou se quiser retornar todos:
    public List<Endereco> buscarTodosPorLogradouro(String logradouro) {
        return repository.findByLogradouroContainingIgnoreCase(logradouro);
    }

    public List<Endereco> buscarTodos() {
        var lista = repository.findAll();
        return lista;


    }

    public void deletarPorLogradouro(String logradouro) {

        repository.deleteByLogradouro(logradouro);
    }

    ;
    
    
    // siglas: !=  diferente, ? se ele for(isso valida oque passou), : senao.
    // Essa função altera apenas um atributo no bd, sem excluir os outros ele valida se eles foram enviados do front senão ele preenche com os dados da entity...
    public void AtualizarEnderecoPorId(
            Long id,
          //  String logradouro,
            Endereco endereco
    ) {
      /*  Endereco enderecoEntity = buscarPorLogradouro(logradouro);
        Endereco enderecoAtualizado = Endereco.builder()
                .logradouro(logradouro)
                .bairro(endereco.getBairro() != null ? endereco.getBairro()
                        : enderecoEntity.getBairro())
                .cidade(endereco.getCidade() != null ? endereco.getCidade()
                        : enderecoEntity.getCidade())
                .numero(endereco.getNumero() != null ? endereco.getNumero()
                        : enderecoEntity.getNumero())
                .cep(endereco.getCep() != null ? endereco.getCep()
                        : enderecoEntity.getCep())
                .complemento(endereco.getComplemento() != null ? endereco.getComplemento()
                        : enderecoEntity.getComplemento())
                .build();
        // ai tem que colocar todos os atributos aqui, coloquei só bairro pra lembrar...
            */
        // --- 22/06/2025 - esse cod abaixo é a situação onde usamos por id, para alterar outro atributo... se ele buscar por logradouro ele não valida ele só puxa... como foi aqui encima...
               Endereco enderecoEntity = repository.findById(id).orElseThrow(() -> 
            new RuntimeException("Endereço não encontrado"));
             Endereco enderecoAtualizado = Endereco.builder()
                 .logradouro(endereco.getLogradouro() != null ? endereco.getLogradouro() : 
                         enderecoEntity.getLogradouro())
                    .bairro(endereco.getBairro() != null ? endereco.getBairro()
                        : enderecoEntity.getBairro())
                .cidade(endereco.getCidade() != null ? endereco.getCidade()
                        : enderecoEntity.getCidade())
                .numero(endereco.getNumero() != null ? endereco.getNumero()
                        : enderecoEntity.getNumero())
                .cep(endereco.getCep() != null ? endereco.getCep()
                        : enderecoEntity.getCep())
                .complemento(endereco.getComplemento() != null ? endereco.getComplemento()
                        : enderecoEntity.getComplemento())
                .build();
          //    .build();
        // fiz apenas com o logradouro mas a idéia é a mesma...
        repository.saveAndFlush(enderecoAtualizado);
    };


}
