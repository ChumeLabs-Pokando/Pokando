package com.br.Pokando.security.dto;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author 1513003
 */
public record ProviderRegistrationRequest(
        String providerName,
        String clientId,
        String clientSecret,
        String registrationId // e.g., "google", "github"
        ) {

}