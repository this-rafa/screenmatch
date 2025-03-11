package br.com.estudos.screenmatch.desafios;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AgruparStringPorTamanho {

    public static void main(String[] args) {
        List<String> palavras = Arrays.asList("java", "stream", "lambda", "code");

        Map<Integer, List<String>> agrupadasPortamanho = palavras.stream()
            .collect(Collectors.groupingBy(String::length));

        System.out.println(agrupadasPortamanho);
    }

}
