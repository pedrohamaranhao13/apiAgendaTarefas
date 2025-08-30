package br.com.cotiinformatica.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfiguration {
	
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("API - Sistema de Agenda de tarefas")
						.description("Documentação da API do sistema desenvolvido em Spring Boot")
						.version("1.0.0")
						.contact(new Contact()
								.name("Coti Informática")
								.url("https://.cotiinformatica.com.br")
								.email("contato@cotiinformatica.com.br"))
						.license(new License()
								.name("Apache 2.0")
								.url("http://springdoc.org")))
				.externalDocs(new ExternalDocumentation()
						.description("Mais informações")
						.url("https://github.com.br/cotiinformatica"));
	}

}
