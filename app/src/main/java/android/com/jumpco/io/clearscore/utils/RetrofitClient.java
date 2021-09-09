package android.com.jumpco.io.clearscore.utils;

import android.com.jumpco.io.clearscore.interfaces.ClearScoreService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static RetrofitClient instance = null;
    private ClearScoreService myApi;
    private RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ClearScoreService.ENDPOINT_JSON)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi = retrofit.create(ClearScoreService.class);

    }

    public static synchronized RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }

    public ClearScoreService getMyApi() {
        return myApi;
    }


}
