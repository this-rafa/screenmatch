package br.com.estudos.screenmatch.desafios;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SepararNumerosParesImpares {

    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);

        Map<String, List<Integer>> numerosSeparados = numeros.stream()
            .collect(Collectors.groupingBy(n -> n % 2 == 0 ? "par" : "impar"));

        System.out.println(numerosSeparados);
    }

}
