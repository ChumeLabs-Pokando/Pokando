package com.br.Pokando.exception;

public class UsuarioNotFoundException extends RuntimeException {

    public UsuarioNotFoundException() {
        super("Usuario não encontrado");
    }
    
}
