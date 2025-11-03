package com.br.Pokando.dto;

public class ApiDataResponse<T> {
    private String mensagem;
    private int statusCode;
    private String status;
    private T data;

    public ApiDataResponse(String mensagem, int statusCode, String status, T data) {
        this.mensagem = mensagem;
        this.statusCode = statusCode;
        this.status = status;
        this.data = data;
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

    public T getData() {
        return data;
    }
}