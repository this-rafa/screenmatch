package br.com.estudos.screenmatch.desafios;

import java.util.Arrays;
import java.util.List;

public class ConverterLetrasMaiuscula {

    public ConverterLetrasMaiuscula(){
        List<String> palavras = Arrays.asList("java", "stream", "lambda");
        palavras.stream()
            .map( m -> m.toUpperCase())
            .forEach(System.out::println);
    }

}
