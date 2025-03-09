package br.com.estudos.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSeries(  @JsonProperty("Title") String titulo, 
                            @JsonProperty("totalSeasons") Integer totalTemporadas, 
                            @JsonProperty("imdbRating")String avaliacao) {

}
