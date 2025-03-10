package br.com.estudos.screenmatch.desafios;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FiltrarNumerosImpares {

    public FiltrarNumerosImpares() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> novosNumeros = numeros.stream()
                .filter(n -> n % 2 != 0)
                .map( n -> n * 2)
                .collect(Collectors.toList());

        System.out.println(novosNumeros);
                
    }

}
