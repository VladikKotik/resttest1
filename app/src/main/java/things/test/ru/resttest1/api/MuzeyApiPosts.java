package things.test.ru.resttest1.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import things.test.ru.resttest1.PostModel;

public interface MuzeyApiPosts {
    @GET("/muzey/api/posts.php")
    Call<List<PostModel>> getData();
}
