package com.br.Pokando.Service;

import com.br.Pokando.model.Usuario;
import com.br.Pokando.repository.UsuarioRepository;
import com.br.Pokando.security.enumeration.SocialAuthProvider; // Import novo
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional; // Import novo

@Service
@RequiredArgsConstructor
public class UsuarioService implements UserDetailsService {

    private final UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));
    }

    public Usuario salvar(Usuario usuario) {
        return repository.save(usuario);
    }

    public List<Usuario> listarTodos() {
        return repository.findAll();
    }

    // Método antigo (pode manter se usar em outros lugares)
    public Usuario buscarPorEmail(String email) {
        return repository.findByEmail(email).orElse(null);
    }

    // --- NOVO MÉTODO PARA CORRIGIR O ERRO ---
    public Optional<Usuario> buscarPor(String email, SocialAuthProvider provider) {
        // Busca no repositório apenas pelo e-mail
        return repository.findByEmail(email);
    }
}