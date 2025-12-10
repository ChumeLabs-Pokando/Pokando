package com.br.Pokando.security.converter;


import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.util.StringUtils;

/**
 *
 * @author 1513003
 */
public class PokandoJwtGrantedAuthoritiesConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {
        Map<String, Object> claims = jwt.getClaims();
        String roles = (String) claims.get("roles");

        if (StringUtils.hasLength(roles)) {
            return Arrays.stream(roles.split(" "))
                    .map(roleName -> {
                        if (!roleName.startsWith("ROLE_")) {
                            roleName = "ROLE_" + roleName;
                        }
                        return new SimpleGrantedAuthority(roleName);
                    })
                    .collect(Collectors.toList());
        }
        return null;
    }
}