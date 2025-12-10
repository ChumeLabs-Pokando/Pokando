package com.br.Pokando.security.util;

import org.springframework.util.StringUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 1513003
 */
public class SettingsParser {

    private SettingsParser() { /* Classe utilitária estática */ }

    /**
     * Converte uma String no formato "{key1=value1, key2=value2}" para um Map<String, Object>.
     * Realiza uma conversão de tipo básica (Strings "true" e "false" para Boolean).
     *
     * @param settingsString A string de configurações do banco de dados.
     * @return Um mapa com chaves e valores processados.
     */
    public static Map<String, Object> stringToMap(String settingsString) {
        if (!StringUtils.hasText(settingsString)) {
            return Collections.emptyMap();
        }

        // 1. Remove as chaves de abertura e fechamento da String: "{...}"
        String content = settingsString.substring(1, settingsString.length() - 1);

        // 2. Divide em pares chave-valor (o delimitador é ", ")
        String[] pairs = StringUtils.commaDelimitedListToStringArray(content);

        Map<String, Object> resultMap = new HashMap<>();

        for (String pair : pairs) {
            // Garante que a string está limpa
            String trimmedPair = pair.trim();

            // 3. Divide a chave do valor
            int separatorIndex = trimmedPair.indexOf('=');

            if (separatorIndex > 0) {
                String key = trimmedPair.substring(0, separatorIndex).trim();
                String valueString = trimmedPair.substring(separatorIndex + 1).trim();

                // 4. Conversão de Tipo Simplificada (essencial para Booleans)
                Object value;
                if ("true".equalsIgnoreCase(valueString) || "false".equalsIgnoreCase(valueString)) {
                    value = Boolean.valueOf(valueString);
                } else {
                    // Mantém como String se não for um tipo conhecido
                    value = valueString;
                }

                resultMap.put(key, value);
            }
        }
        return resultMap;
    }
}