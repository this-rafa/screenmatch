package br.com.estudos.screenmatch.desafios;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SubListas {

    public SubListas() {
        
        List<List<Integer>> listaDeNumeros = Arrays.asList(
            Arrays.asList(1, 2, 3, 4),
            Arrays.asList(5, 6, 7, 8),
            Arrays.asList(9, 10, 11, 12)
        );

        List<Integer> numerosPrimos = listaDeNumeros.stream()
        .flatMap(t -> t.stream()
        .filter( n -> n > 1 && IntStream.range(2, n)
        .noneMatch(i -> n % i == 0)))
        .sorted(Comparator.reverseOrder())
        .collect(Collectors.toList());

        System.out.println(numerosPrimos);

    }

}
