package android.com.jumpco.io.clearscore.interfaces;

import android.com.jumpco.io.clearscore.pojo.ClearScoreModel;

import retrofit2.Call;

public interface Api {

    public String BASE_URL = "https://android-interview.s3.eu-west-2.amazonaws.com/endpoint.json";
    Call<ClearScoreModel> getCurrentSuperheroDataInfo();

}
