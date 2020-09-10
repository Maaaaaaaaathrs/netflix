package com.netflix.movies.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_MOVIES")
@ApiModel(value = "Modelo Entidade MOVIE")
public class Movie implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Column(name = "ID_MOVIE")
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Identificação do filme", required = true, name = "id", example = "1", position = 1)
    private Integer id;

    @Column(name = "NAME")
    @ApiModelProperty(notes = "Nome do filme", required = true, name = "name", example = "Piratas do Caribe: A Maldição do Pérola Negra", position = 2)
    private String name;

    @Column(name = "GENRE")
    @ApiModelProperty(notes = "Gênero do filme", required = true, name = "name", example = "action, comedy, fantasy, adventure", position = 3)
    private String genre;

    @Column(name = "IMAGE")
    @ApiModelProperty(notes = "Imagem que representa o filme", required = true, name = "image", example = "http://imagelink.com", position = 4)
    private String image;

    @Column(name = "SYNOPSES")
    @ApiModelProperty(notes = "Sinopse do filme", required = true, name = "synopses", example = "O pirata Jack Sparrow tem seu navio saqueado e roubado pelo capitão Barbossa e sua tripulação. Com o navio de Sparrow, Barbossa invade a cidade de Port Royal, levando consigo Elizabeth Swann, filha do governador. Para recuperar sua embarcação, Sparrow recebe a ajuda de Will Turner, um grande amigo de Elizabeth. Eles desbravam os mares em direção à misteriosa Ilha da Morte, tentando impedir que os piratas-esqueleto derramem o sangue de Elizabeth para desfazer a maldição que os assola.", position = 5)
    private String synopses;

    @Column(name = "LINK")
    @ApiModelProperty(notes = "Link para o filme", required = true, name = "link", example = "http://netflix.com/watch/movie/1", position = 6)
    private String link;

    @Column(name = "RELEASE_YEAR")
    @ApiModelProperty(notes = "Ano de lançamento", required = true, name = "releaseYear", example = "2003", position = 7)
    private String releaseYear;

    @Column(name = "REVIEWS")
    @ApiModelProperty(notes = "Quantidade de avaliações", name = "reviews", example = "10", position = 8)
    private Float reviews;

    @Column(name = "REVIEWS_SCORE")
    @ApiModelProperty(notes = "Pontuação do filme", required = true, name = "reviewsScore", example = "95", position = 9)
    private Float reviewsScore;

    @Column(name = "WATCHED_TIMES")
    @ApiModelProperty(notes = "Quantidade de vizualizações", required = true, name = "watchedTimes", example = "10", position = 10)
    private Float watchedTimes;
}
