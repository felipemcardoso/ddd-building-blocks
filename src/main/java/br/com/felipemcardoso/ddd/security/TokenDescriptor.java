package br.com.felipemcardoso.ddd.security;

public class TokenDescriptor {

    private Token token;

    private String asString;

    public TokenDescriptor(Token token, String asString) {
        this.token = token;
        this.asString = asString;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public String getAsString() {
        return asString;
    }

    public void setAsString(String asString) {
        this.asString = asString;
    }
}
