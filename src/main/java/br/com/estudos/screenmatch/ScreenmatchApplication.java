package br.com.estudos.screenmatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.estudos.screenmatch.desafios.FiltrarNumerosImpares;
import br.com.estudos.screenmatch.desafios.RemovendoDuplicatas;
import br.com.estudos.screenmatch.desafios.SubListas;



@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner{
	public static void main(String[] args){
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//Principal principal = new Principal();
		//principal.exibirMenu();

		SubListas subListas = new SubListas();

	}

}
