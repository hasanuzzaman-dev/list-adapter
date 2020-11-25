package com.hasan.listadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.hasan.listadapter.adapters.MovieListAdapter;
import com.hasan.listadapter.models.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity implements MovieListAdapter.MovieClickInterface {

    private MovieListAdapter movieListAdapter;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        movieListAdapter = new MovieListAdapter(Movie.itemCallback,this);
        recyclerView.setAdapter(movieListAdapter);

        initMovieList();
    }

    private void initMovieList() {
        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("Captain America", "8.1"));
        movieList.add(new Movie("Iron Man", "8.4"));
        movieList.add(new Movie("Thor", "8.7"));
        movieList.add(new Movie("Spider-Man", "7.8"));
        movieList.add(new Movie("Civil War", "7.6"));

        movieListAdapter.submitList(movieList);
    }

    public void addItem(View view) {
        Movie movie = new Movie("Avenger's", "8.9");

        List<Movie> movieList = new ArrayList<>(movieListAdapter.getCurrentList());
        movieList.add(movie);
        movieListAdapter.submitList(movieList);
    }

    public void updateItem(View view) {
        int randomPosition = new Random().nextInt(movieListAdapter.getItemCount());
        Log.d(TAG, "randomPosition: "+randomPosition);
        Movie movie = movieListAdapter.getCurrentList().get(randomPosition);
        Log.d(TAG, "Movie: "+movie.toString());

        Movie updateMovie = new Movie(movie.getName(),movie.getRating());
        updateMovie.setId(movie.getId());
        updateMovie.setName(movie.getName() +" :updated");

        List<Movie> movieList = new ArrayList<>(movieListAdapter.getCurrentList());
        movieList.remove(movie);
        movieList.add(randomPosition,updateMovie);

        movieListAdapter.submitList(movieList);
    }


    @Override
    public void onDelete(int position) {

        List<Movie> movieList = new ArrayList<>(movieListAdapter.getCurrentList());
        movieList.remove(position);
        movieListAdapter.submitList(movieList);

    }
}