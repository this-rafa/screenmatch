package br.com.estudos.screenmatch.desafios;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProdutoMain {

    public static void main(String[] args) {
        List<Produto> produtos = Arrays.asList(
            new Produto("Smartphone", 800.0, "Eletrônicos"),
            new Produto("Notebook", 1500.0, "Eletrônicos"),
            new Produto("Teclado", 200.0, "Eletrônicos"),
            new Produto("Cadeira", 300.0, "Móveis"),
            new Produto("Monitor", 900.0, "Eletrônicos"),
            new Produto("Mesa", 700.0, "Móveis")
        );

        List<Produto> eletronicosMenosDeMil = produtos.stream()
            .filter( p -> p.getCategoria().equals("Eletrônicos") && p.getPreco() < 1000)
            .sorted(Comparator.comparing(Produto::getPreco).reversed())
            .collect(Collectors.toList());
        
        System.out.println("Eletrônicos com preço menor que 1000: ");
        System.out.println(eletronicosMenosDeMil);


        Map<String, List<Produto>> agrupandoPorCategoria = produtos.stream()
            .collect(Collectors.groupingBy(Produto::getCategoria));

        System.out.println("\nProdutos agrupados por categoria: ");
        System.out.println(agrupandoPorCategoria);

        Map<String, Long> quantidadePorCategoria = produtos.stream()
            .collect(Collectors.groupingBy(Produto::getCategoria, Collectors.counting()));

        System.out.println("\nQuantidade de produtos por categoria: ");
        System.out.println(quantidadePorCategoria);

        Map<String, Optional<Produto>> produtoMaisCaro = produtos.stream()
            .collect(Collectors.groupingBy(Produto::getCategoria, Collectors.maxBy(Comparator.comparing(Produto::getPreco))));

        System.out.println("\nProduto mais caro por categoria: ");
        System.out.println(produtoMaisCaro);

        Map<String, Double> totalPorCategoria = produtos.stream()
            .collect(Collectors.groupingBy(Produto::getCategoria, Collectors.summingDouble(Produto::getPreco)));

        System.out.println("\nSoma dos produtos por categoria: ");
        System.out.println(totalPorCategoria);


    }

}
