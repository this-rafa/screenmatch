package br.com.estudos.screenmatch.desafios;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class QuadradoDosPares {

    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);

        IntSummaryStatistics est = numeros.stream()
            .filter(n -> n % 2 == 0)
            .map( n -> n * n)
            .collect(Collectors.summarizingInt(Integer::intValue));

        System.out.println("Soma dos quadrados dos números pares: " + est.getSum());
    }
}
