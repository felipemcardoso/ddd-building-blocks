package br.com.felipemcardoso.ddd.security;

import org.springframework.stereotype.Component;

@Component
public class ProfileHelper {

    public String getProfile() {
        Token token = SessionContext.descriptor().getToken();

        return token.getPerfil();
    }

    public String getId() {
        Token token = SessionContext.descriptor().getToken();

        return token.getUsuarioId();
    }

}
