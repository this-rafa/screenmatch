package br.com.estudos.screenmatch.principal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import br.com.estudos.screenmatch.model.DadosEpisodio;
import br.com.estudos.screenmatch.model.DadosSeries;
import br.com.estudos.screenmatch.model.DadosTemporada;
import br.com.estudos.screenmatch.model.Episodio;
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

		List<DadosEpisodio> dadosEpisodios = (List<DadosEpisodio>) temporadas.stream()
            .flatMap(t -> t.episodios().stream())
            .collect(Collectors.toList());

        
        System.out.println("\n Top 5 Episódios com maior avaliação: ");
        dadosEpisodios.stream()
            .filter(e -> !e.avaliacao().equalsIgnoreCase("N/A"))
            .sorted(Comparator.comparing(DadosEpisodio::avaliacao).reversed())
            .limit(5)
            .forEach(System.out::println);

        List<Episodio> episodios = temporadas.stream()
            .flatMap(t -> t.episodios().stream()
            .map( d -> new Episodio(t.numero(), d))
            ).collect(Collectors.toList());
            

        episodios.forEach(System.out::println);

        System.out.println("Digite um trecho do titulo do episódio para buscar");
        String nomeTitulo = scanner.nextLine();

        Optional<Episodio> episodioBuscado =  episodios.stream()
            .filter(e -> e.getTitulo().toUpperCase().contains(nomeTitulo.toUpperCase()))
            .findFirst();

        if(episodioBuscado.isPresent()){
            System.out.println("Episodio encontrado!");
            System.out.println("Temporada: " + episodioBuscado.get().getTemporada());
        }else{
            System.out.println("Episodio não encontrado!");
        }

        // System.out.println("Apartir de qual ano você deseja ver os episódios?");
        // int ano = scanner.nextInt();
        // scanner.nextLine();

        // LocalDate dataBusca = LocalDate.of(ano, 1, 1);

        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // episodios.stream()
        //     .filter( e -> e.getDataLancamento() != null && e.getDataLancamento().isAfter(dataBusca))
        //     .forEach( e -> System.out.println(
        //         "Temporada: " + e.getTemporada() +
        //         " Episódio: " + e.getNumeroEpisodio() +
        //         " Data Lancamento: " + e.getDataLancamento().format(formatter)

        //         ));

        Map<Integer, Double> avalicoesPorTemporada = episodios.stream()
            .filter(e -> e.getAvaliacao() != 0)
            .collect(Collectors.groupingBy(Episodio::getTemporada,
            Collectors.averagingDouble(Episodio::getAvaliacao)));


        DoubleSummaryStatistics est = episodios.stream()
            .filter(e -> e.getAvaliacao() != 0)
            .collect(Collectors.summarizingDouble(Episodio::getAvaliacao));

        System.out.println("Média: " + String.format("%.2f",est.getAverage()));
        System.out.println("Max: " + est.getMax());
        System.out.println("Min: " + est.getMin());
        System.out.println("Total Ep: " + est.getCount());

    }
}
