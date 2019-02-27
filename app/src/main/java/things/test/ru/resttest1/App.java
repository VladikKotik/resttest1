package things.test.ru.resttest1;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import things.test.ru.resttest1.api.MuzeyApiPosts;
import things.test.ru.resttest1.api.UmoriliApi;
import things.test.ru.resttest1.api.UmoriliApiRandom;

public class App extends Application {

    private static UmoriliApi umoriliApi;
    private static UmoriliApiRandom umoriliApiRandom;
    private static MuzeyApiPosts muzeyApiPosts;
    private Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        retrofit = new Retrofit.Builder()
                //.baseUrl("https://umorili.herokuapp.com") //Базовая часть адреса
                .baseUrl("http://82.179.9.49") //Базовая часть адреса
                .addConverterFactory(GsonConverterFactory.create()) //Конвертер, необходимый для преобразования JSON'а в объекты
                .build();
        umoriliApi = retrofit.create(UmoriliApi.class); //Создаем объект, при помощи которого будем выполнять запросы
        umoriliApiRandom = retrofit.create(UmoriliApiRandom.class);// для рандома
        muzeyApiPosts = retrofit.create(MuzeyApiPosts.class);
    }

    public static UmoriliApi getApi() {
        return umoriliApi;
    }

    public static UmoriliApiRandom getUmoriliApiRandom(){
        return umoriliApiRandom;
    }

    public static MuzeyApiPosts getMuzeyApiPosts(){return muzeyApiPosts;}
}