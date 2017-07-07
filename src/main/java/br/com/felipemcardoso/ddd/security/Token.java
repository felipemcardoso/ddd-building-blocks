package br.com.felipemcardoso.ddd.security;

import org.json.JSONObject;

import java.util.Date;

/**
 * Classe que representa uma sessão do usuário, contendo o login, e-mail e timestamp em que se deu o início da sessão.
 */
public class Token {

    private String usuarioId;

    private String email;

    private String perfil;

    private Long assinanteId;

    private String assinante;

    private String schema;

    private Date lastLogin;

    public Token(String usuarioId, String email, Long assinanteId,
                 String assinante, String schema, String perfil, Date lastLogin) {

        this.usuarioId = usuarioId;
        this.email = email;
        this.assinanteId = assinanteId;
        this.assinante = assinante;
        this.schema = schema;
        this.perfil = perfil;
        this.lastLogin = lastLogin;
    }

    public static Token fromJson(String json) {
        JSONObject jsonObject = new JSONObject(json);

        String id = jsonObject.getString("id");
        String email = jsonObject.getString("email");
        Long assinanteId = jsonObject.getLong("assinanteId");
        String assinante = jsonObject.getString("assinante");
        String schema = jsonObject.getString("schema");
        String perfil = jsonObject.getString("perfil");

        return new Token(id, email, assinanteId, assinante, schema, perfil, new Date(System.currentTimeMillis()));
    }

    public String toJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", getUsuarioId());
        jsonObject.put("email", getEmail());
        jsonObject.put("assinanteId", getAssinanteId());
        jsonObject.put("assinante", getAssinante());
        jsonObject.put("schema", getSchema());
        jsonObject.put("perfil", getPerfil());

        return jsonObject.toString();
    }

    public String getEmail() {
        return email;
    }

    public Long getAssinanteId() {
        return assinanteId;
    }

    public String getAssinante() {
        return assinante;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public String getSchema() {
        return schema;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public String getPerfil() {
        return perfil;
    }

    @Override
    public String toString() {
        return assinanteId + " , " + email;
    }
}
