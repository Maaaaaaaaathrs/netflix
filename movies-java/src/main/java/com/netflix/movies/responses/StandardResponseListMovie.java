package com.netflix.movies.responses;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StandardResponseListMovie {

    private List<Movie> data;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Movie {

        @ApiModelProperty(notes = "Identificação do filme", required = true, name = "id", example = "1", position = 1)
        private Integer id;

        @ApiModelProperty(notes = "Nome do filme", required = true, name = "name", example = "Piratas do Caribe: A Maldição do Pérola Negra", position = 2)
        private String name;

        @ApiModelProperty(notes = "Gênero do filme", required = true, name = "name", example = "action, comedy, fantasy, adventure", position = 3)
        private String genre;

        @ApiModelProperty(notes = "Imagem que representa o filme", required = true, name = "image", example = "http://imagelink.com", position = 4)
        private String image;
    }
}
