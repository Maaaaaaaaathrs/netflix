package com.netflix.movies.dtos;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {

    @ApiModelProperty(notes = "Identificação do filme", required = true, name = "id", example = "1", position = 1)
    private Integer id;

    @ApiModelProperty(notes = "Nota do filme", required = true, name = "reviewScore", example = "9", position = 1)
    private Float reviewScore;
}
