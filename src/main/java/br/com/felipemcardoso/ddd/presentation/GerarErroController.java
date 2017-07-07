package br.com.felipemcardoso.ddd.presentation;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

@Path("/erro")
@Singleton
@Component
public class GerarErroController {
	
	@GET
	public Response gerarErro() {
		throw new RuntimeException("Erro gerado para teste.");
	}

}
