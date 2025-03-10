package br.com.estudos.screenmatch.desafios;

import java.util.Arrays;
import java.util.List;

public class RemovendoDuplicatas {

    public RemovendoDuplicatas(){

        List<String> palavras = Arrays.asList("apple", "banana", "apple", "orange", "banana");
        palavras.stream()
        .distinct().forEach(System.out::println);

    }

}
