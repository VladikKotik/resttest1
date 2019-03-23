package things.test.ru.resttest1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<PostPreviewModel> posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        posts = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.posts_recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        PostsAdapter adapter = new PostsAdapter(this,posts);
        recyclerView.setAdapter(adapter);

        //App.getApi().getData("bash", 50).enqueue(new Callback<List<PostPreviewModel>>() {
        //App.getUmoriliApiRandom().getRandomData( 10).enqueue(new Callback<List<PostPreviewModel>>() {
        App.getMuzeyApiPosts().getData().enqueue(new Callback<List<PostPreviewModel>>() {
            @Override
            public void onResponse(Call<List<PostPreviewModel>> call, Response<List<PostPreviewModel>> response) {
                posts.addAll(response.body());
                recyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<PostPreviewModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "An error occurred during networking", Toast.LENGTH_SHORT).show();
            }
        });

    }



}