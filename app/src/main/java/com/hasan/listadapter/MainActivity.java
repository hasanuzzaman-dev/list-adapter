package com.hasan.listadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.hasan.listadapter.adapters.MovieListAdapter;
import com.hasan.listadapter.models.Movie;


public class MainActivity extends AppCompatActivity implements MovieListAdapter.MovieClickInterface {

    private MovieListAdapter movieListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        movieListAdapter = new MovieListAdapter(Movie.itemCallback,this);
        recyclerView.setAdapter(movieListAdapter);
    }

    public void addItem(View view) {
    }

    public void updateItem(View view) {
    }


    @Override
    public void onDelete(int position) {

    }
}