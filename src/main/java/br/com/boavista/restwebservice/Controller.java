package br.com.boavista.restwebservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import lombok.Data;

@RestController
public class Controller {

	@GetMapping(value = "/ola")
	public String hello() {
		return "Olá";
	}
	
	@GetMapping(value = "/ciao")
	public String ciao() {
		return "Ciao";
	}
	
	@GetMapping(value = "/cliente/{id}")
	public String getCliente(@PathVariable String id) {
		Cliente c = new Cliente();

		if (id.equals("1")) {
			c.setId(1);
		} else {
			c.setId(2);
		}

		c.setNome("Maria da Silva");
		c.setEmail("jose@silva.com.br");
		
		Endereco cob = new Endereco();
		cob.setTipoEndereco("Cobrança");
		cob.setLogradouro("Rua 10, 188");
		cob.setBairro("Centro");
		cob.setCidade("São Paulo");
		cob.setUf("SP");
		
		Endereco corr = new Endereco();
		corr.setTipoEndereco("Correspondência");
		corr.setLogradouro("Rua Humaitá, 99");
		
		c.setCobranca(cob);
		c.setCorrespondencia(corr);
		
		return new Gson().toJson(c);
	}
}

@Data
class Cliente {
	private int id;
	private String nome;
	private String email;
	private Endereco cobranca;
	private Endereco correspondencia;
}

@Data
class Endereco {
	private String tipoEndereco;
	private String logradouro;
	private String bairro;
	private String cidade;
	private String uf;
}
