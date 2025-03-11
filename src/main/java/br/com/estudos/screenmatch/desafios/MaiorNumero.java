package br.com.estudos.screenmatch.desafios;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class MaiorNumero {

    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(10, 20, 30, 40, 50);

        IntSummaryStatistics maiorNumero = numeros.stream()
            .collect(Collectors.summarizingInt(Integer::intValue));

        System.out.println("Maior número: " + maiorNumero.getMax());
    }

}
