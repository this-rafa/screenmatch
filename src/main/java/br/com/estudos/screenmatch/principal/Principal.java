package br.com.estudos.screenmatch.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.estudos.screenmatch.model.DadosSeries;
import br.com.estudos.screenmatch.model.DadosTemporada;
import br.com.estudos.screenmatch.service.ConsumoApi;
import br.com.estudos.screenmatch.service.ConverteDados;

public class Principal {

    private Scanner scanner = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados converte = new ConverteDados();

    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=6585022c";

    public void exibirMenu(){
        System.out.println("Digite o nome da série para a busca");

        String nomeSerie = scanner.nextLine();
        nomeSerie = nomeSerie.replace(" ", "+");

        String urlSerie = ENDERECO + nomeSerie + API_KEY;

        var json = consumo.oberDados(urlSerie);

        DadosSeries serie = converte.obterDados(json, DadosSeries.class);
        System.out.println(serie);

        List<DadosTemporada> temporadas = new ArrayList<>();

		for(int i = 1; i<= serie.totalTemporadas(); i++){
            String urlTemporadas = ENDERECO + nomeSerie + "&season=" + i + API_KEY;
			json = consumo.oberDados(urlTemporadas);
			temporadas.add(converte.obterDados(json, DadosTemporada.class));
		}

		temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));

    }
}
