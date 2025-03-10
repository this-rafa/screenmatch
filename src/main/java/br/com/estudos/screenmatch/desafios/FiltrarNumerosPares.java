package br.com.estudos.screenmatch.desafios;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FiltrarNumerosPares {

    public FiltrarNumerosPares(){

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);

        numeros.stream()
            .filter(n -> n% 2 == 0)
            .collect(Collectors.toList())
            .forEach(System.out::println);

    }

}
