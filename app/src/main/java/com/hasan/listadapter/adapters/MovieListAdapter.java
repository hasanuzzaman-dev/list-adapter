package com.hasan.listadapter.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.hasan.listadapter.R;
import com.hasan.listadapter.models.Movie;

public class MovieListAdapter extends ListAdapter<Movie, MovieListAdapter.MovieViewHolder> {

    MovieClickInterface movieClickInterface;

    public MovieListAdapter(@NonNull DiffUtil.ItemCallback<Movie> diffCallback, MovieClickInterface movieClickInterface) {
        super(diffCallback);
        this.movieClickInterface = movieClickInterface;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row,parent,false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {

        Movie movie = getItem(position);
        holder.nameTV.setText(movie.getName());
        holder.ratingTV.setText(movie.getRating());

    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView nameTV, ratingTV;
        ImageButton deleteBtn;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTV = itemView.findViewById(R.id.nameTextview);
            ratingTV = itemView.findViewById(R.id.ratingTextView);
            deleteBtn = itemView.findViewById(R.id.deleteButton);

            deleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    movieClickInterface.onDelete(getAdapterPosition());

                }
            });
        }
    }

    public interface MovieClickInterface{
        void onDelete(int position);
    }
}
