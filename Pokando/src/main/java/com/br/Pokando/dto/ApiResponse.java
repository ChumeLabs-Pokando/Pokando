package com.br.Pokando.dto;

public class ApiResponse {

    private String mensagem;
    private int statusCode;
    private String status;

    public ApiResponse(String mensagem, int statusCode, String status) {
        this.mensagem = mensagem;
        this.statusCode = statusCode;
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getStatus() {
        return status;
    }
}

