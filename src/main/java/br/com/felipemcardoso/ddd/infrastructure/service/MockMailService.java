package br.com.felipemcardoso.ddd.infrastructure.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by felipe on 2/13/16.
 */
@Service("mockMailService")
public class MockMailService implements MailerService {

    @Value("${mailer.host}")
    private String host;

    @Value("${mailer.port}")
    private String port;

    @Value("${mailer.username}")
    private String username;

    @Value("${mailer.password}")
    private String password;

    @Value("${mailer.email}")
    private String email;

    @Value("${mailer.sender}")
    private String sender;

    @Override
    public void enviarEmail(String destinatario, String assunto, String corpo) {
        System.out.println("Enviando email para: " + destinatario);
        System.out.println("Assunto: " + assunto);
        System.out.println("Corpo: " + corpo);
    }

    @Override
    public void enviarEmail(List<String> destinatarios, String assunto, String corpo) {
        System.out.println("Enviando email para: " + destinatarios.toString());
        System.out.println("Assunto: " + assunto);
        System.out.println("Corpo: " + corpo);
    }
}
