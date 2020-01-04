package com.exemplo.wsdlcliente;

import com.exemplo.wsdlcliente.clients.PaisClient;
import com.exemplo.wsdlcliente.wsdl.GetPaisResponse;
import com.exemplo.wsdlcliente.wsdl.Pais;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class WsdlClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsdlClienteApplication.class, args);
	}
	
	@Bean
	CommandLineRunner lookup(PaisClient quoteClient) {
		return args -> {
			String pais = "Brasil";

			GetPaisResponse response = quoteClient.getPais(pais);
			System.out.println(response.getPais().getCapital());
			System.out.println(response.getPais().getMoeda());
			System.out.println(response.getPais().getPopulacao());

			response = quoteClient.getPais("Reino Unido");
			System.out.println(response.getPais().getCapital());
			System.out.println(response.getPais().getMoeda());
			System.out.println(response.getPais().getPopulacao());
		};
	}

}
