package br.com.felipemcardoso.ddd.infrastructure.service;

import java.util.List;

/**
 * Created by felipe on 1/8/16.
 */
public interface MailerService {

    void enviarEmail(String destinatario, String assunto, String corpo);

    void enviarEmail(List<String> destinatarios, String assunto, String corpo);

}
