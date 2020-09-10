package com.netflix.movies.controllers;

import com.netflix.movies.responses.StandardResponseListMovie;
import com.netflix.movies.responses.StandardResponseMovie;
import com.netflix.movies.services.MovieService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "Movies API",tags = { "Movies" })
@RequestMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
@ApiResponses({
        @ApiResponse(code = 400, message = "Bad Request"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 422, message = "Unprocessable Entity"),
        @ApiResponse(code = 500, message = "Internal Server Error") })
public class MovieController {

    @Autowired
    MovieService service;

    @ApiOperation("Search movies by genre")
    @ApiResponse(code = 200, message = "OK", response = StandardResponseListMovie.class)
    @GetMapping(value = "/movie/genre/{genre}", produces = "application/json")
    public ResponseEntity<StandardResponseListMovie> findMoviesByGenre(@PathVariable @ApiParam(required = true) String genre) {
        return service.findMoviesByGenre(genre);
    }

    @ApiOperation("Get movie details by identification")
    @ApiResponse(code = 200, message = "OK", response = StandardResponseListMovie.class)
    @GetMapping(value = "/movie/{id}", produces = "application/json")
    public ResponseEntity<StandardResponseMovie> getMovieDetails(@PathVariable @ApiParam(required = true) Integer id) {
        return service.findById(id);
    }
}
