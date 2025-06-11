package com.aluracursos.screenmatch.service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ConsultaGemini {

    private final String apiKey;

    public ConsultaGemini(@Value("${gemini.api.key}") String apiKey) {
        this.apiKey = apiKey;
    }

    public String obtenerTraduccion(String texto) {
        String modelo = "gemini-2.0-flash-lite";
        String prompt = "Traduce el siguiente texto al español: " + texto;

        Client cliente = new Client.Builder()
                .apiKey(apiKey)
                .build();

        try {
            GenerateContentResponse respuesta = cliente.models.generateContent(
                    modelo,
                    prompt,
                    null
            );

            if (!respuesta.text().isEmpty()) {
                return respuesta.text();
            }
        } catch (Exception e) {
            System.err.println("Error al llamar a la API de Gemini para traducción: " + e.getMessage());
        }

        return null;
    }
}
