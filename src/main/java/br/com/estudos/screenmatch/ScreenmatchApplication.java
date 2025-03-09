package br.com.estudos.screenmatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.estudos.screenmatch.model.DadosSeries;
import br.com.estudos.screenmatch.service.ConsumoApi;
import br.com.estudos.screenmatch.service.ConverteDados;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner{
	public static void main(String[] args){
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConsumoApi consumoApi = new ConsumoApi();
		String dados = consumoApi.oberDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");
		
		ConverteDados converteDados = new ConverteDados();
		DadosSeries dadosSeries = converteDados.obterDados(dados, DadosSeries.class);

		System.out.println(dadosSeries);

	}

}
