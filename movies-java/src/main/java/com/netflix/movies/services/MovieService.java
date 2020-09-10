package com.netflix.movies.services;

import com.netflix.movies.entities.Movie;
import com.netflix.movies.repositories.MovieRepository;
import com.netflix.movies.responses.StandardResponseListMovie;
import com.netflix.movies.responses.StandardResponseMovie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Autowired
    MovieRepository repository;

    public ResponseEntity<StandardResponseListMovie> findMoviesByGenre(String genre) {
        logger.info(MessageFormat.format("Searching movies by provided genre {0}", genre));
        List<Movie> movies = repository.findAll();

        List<StandardResponseListMovie.Movie> foundMoviesByGenre = new ArrayList<>();

        StandardResponseListMovie.Movie movieObject;

        for(Movie movie : movies) {
            if(movie.getGenre().contains(genre)) {
                movieObject = new StandardResponseListMovie.Movie();
                movieObject.setId(movie.getId());
                movieObject.setName(movie.getName());
                movieObject.setImage(movie.getImage());
                movieObject.setGenre(movie.getGenre());
                foundMoviesByGenre.add(movieObject);
            }
        }

        if(foundMoviesByGenre.isEmpty()) {
            logger.info("No movies found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        logger.info(MessageFormat.format("Listing {0} movies of the genre {1}", foundMoviesByGenre.size(), genre));

        return ResponseEntity.ok(new StandardResponseListMovie(foundMoviesByGenre));
    }

    public ResponseEntity<StandardResponseMovie> findById(Integer id) {
        Optional<Movie> movie = repository.findById(id);

        if(!movie.isPresent()) {
            logger.error("Movie not found!");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(new StandardResponseMovie(movie.get()));
    }
}
