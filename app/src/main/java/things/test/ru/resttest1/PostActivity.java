package things.test.ru.resttest1;

import android.support.v7.app.AppCompatActivity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostActivity extends AppCompatActivity {

    private ImageView post_image;
    private TextView post_title;
    private TextView post_content;
    PostModel post;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        //final PostModel[] post = new PostModel[1];
        int post_id=getIntent().getIntExtra("post_ID",-1); //аргумент приходит, а дальше хуй
        App.getMuzeyApiPosts().getPost(post_id).enqueue(new Callback<PostModel>() {
            @Override
            public void onResponse(Call<PostModel> call, Response<PostModel> response) {
                post=response.body();   //вот тут грит post null и пизда
                post_title=findViewById(R.id.post_title);
                post_content=findViewById(R.id.post_content);
                post_image=findViewById(R.id.post_image);

                post_title.setText(post.getPostTitle());
                post_content.setText(post.getPostContent());
                if (post != null) {
                    Glide.with(PostActivity.this).load(post.getGuid())
                            .placeholder(R.drawable.ic_cloud_off_red)
                            .into(post_image);
                }
            }

            @Override
            public void onFailure(Call<PostModel> call, Throwable t) {
                Toast.makeText(PostActivity.this, "An error occurred during networking", Toast.LENGTH_SHORT).show();
            }
        });

        //вот тут пост уже нулл cyfчала всё до запроса, а потом уже запрос так шо над все внутри во время выполнения запроса

        //тут мб сделать регеэкспом шоб игнорил <img * />



    }

}

