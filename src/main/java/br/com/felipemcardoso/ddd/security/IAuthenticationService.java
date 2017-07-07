package br.com.felipemcardoso.ddd.security;

import org.springframework.stereotype.Service;

/**
 * Created by felipe on 10/29/15.
 */
@Service
public interface IAuthenticationService {

    Token authenticate(String email, String senha);

}
