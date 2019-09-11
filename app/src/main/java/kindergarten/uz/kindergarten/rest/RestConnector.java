package kindergarten.uz.kindergarten.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestConnector {

    private static RestConnector instance;
    private Retrofit retrofit;
    private RestBasicApi restBasicApi;

    public static RestConnector getInstance(){
        if (instance==null)
            instance = new RestConnector();
        return instance;
    }

    private RestConnector(){
         retrofit= new Retrofit.Builder().baseUrl("http://192.168.43.248:8080/")
                .addConverterFactory(GsonConverterFactory.create()).build();
         restBasicApi = retrofit.create(RestBasicApi.class);
    }

    public RestBasicApi getRestBasicApi(){
        return restBasicApi;
    }




    }


