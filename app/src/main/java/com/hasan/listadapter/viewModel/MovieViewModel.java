package com.hasan.listadapter.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hasan.listadapter.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieViewModel extends ViewModel {

    private static final String TAG = "MovieViewModel";
    private MutableLiveData<List<Movie>> mutableLiveData;


    public LiveData<List<Movie>> getMovieList(){
        if (mutableLiveData == null){
            mutableLiveData = new MutableLiveData<>();
            initMovieList();

        }

        return mutableLiveData;
    }


    private void initMovieList() {
        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("Captain America", "8.1"));
        movieList.add(new Movie("Iron Man", "8.4"));
        movieList.add(new Movie("Thor", "8.7"));
        movieList.add(new Movie("Spider-Man", "7.8"));
        movieList.add(new Movie("Civil War", "7.6"));

        mutableLiveData.setValue(movieList);
    }

    public void deleteMovie(int position){
        if (mutableLiveData.getValue() != null){
            List<Movie> movieList = new ArrayList<>(mutableLiveData.getValue());
            movieList.remove(position);
            mutableLiveData.setValue(movieList);
        }
    }

    public void addMovie(Movie movie){
        if (mutableLiveData.getValue() != null){
            List<Movie> movieList = new ArrayList<>(mutableLiveData.getValue());
            movieList.add(movie);
            mutableLiveData.setValue(movieList);
        }
    }

    public void updateMovie(Movie movie, int position){
        if (mutableLiveData.getValue() != null){
            List<Movie> movieList = new ArrayList<>(mutableLiveData.getValue());
            movieList.remove(position);
            movieList.add(position,movie);
            mutableLiveData.setValue(movieList);
        }

    }
}
