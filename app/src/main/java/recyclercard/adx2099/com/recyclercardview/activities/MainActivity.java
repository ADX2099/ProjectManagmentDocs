package recyclercard.adx2099.com.recyclercardview.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import recyclercard.adx2099.com.recyclercardview.models.Movie;
import recyclercard.adx2099.com.recyclercardview.adapters.MyAdapter;
import recyclercard.adx2099.com.recyclercardview.R;

public class MainActivity extends AppCompatActivity {
    private List<Movie> movies;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movies = this.getAllMovies();
        mRecyclerView = findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);

        mAdapter = new MyAdapter(movies, R.layout.recycler_view_item, new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Movie movie, int position) {
                removeMovie(position);
            }
        });

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.add_name:
                this.addMovie(0);
                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }
    }



    private List<Movie> getAllMovies(){
        return  new ArrayList<Movie>(){
            {
                add(new Movie("Infinity War", R.drawable.poster1) );
                add(new Movie("Dragon Ball", R.drawable.poster2));
                add(new Movie("Star Wars", R.drawable.poster3));
                add(new Movie("Jedi", R.drawable.poster4));
            }
        };
    }

    private void addMovie(int position){
        movies.add(position, new Movie("New image " + (++counter),R.drawable.newmovie));
        mAdapter.notifyItemInserted(position);
        mLayoutManager.scrollToPosition(position);
    }

    private void removeMovie(int position){
        movies.remove(position);
        mAdapter.notifyItemRemoved(position);
    }
}
