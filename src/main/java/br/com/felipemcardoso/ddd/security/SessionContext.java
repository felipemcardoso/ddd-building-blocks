package br.com.felipemcardoso.ddd.security;

/**
 * Guarda o token da sessão na ThreadLocal para utilização na camada de persistência
 * <p>
 * Created by felipe on 4/1/15.
 */
public class SessionContext {

    private static final ThreadLocal<TokenDescriptor> tokenThreadLocal = new ThreadLocal<>();

    public static void set(TokenDescriptor token) {
        tokenThreadLocal.set(token);
    }

    public static void remove() {
        tokenThreadLocal.remove();
    }

    public static TokenDescriptor descriptor() {
        return tokenThreadLocal.get();
    }

}
