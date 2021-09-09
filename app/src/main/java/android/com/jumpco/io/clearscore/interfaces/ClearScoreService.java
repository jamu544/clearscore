package android.com.jumpco.io.clearscore.interfaces;

import android.com.jumpco.io.clearscore.pojo.ClearScoreModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ClearScoreService {

    public String ENDPOINT_JSON = "https://android-interview.s3.eu-west-2.amazonaws.com/";
//@Headers({
//        "Content-Type: application/json",
//        "x-amz-id-2: c8MpJ6K5U2M9eyQRkTPw4KH6n49xoaUnYfen8SFT5yzV+lEZVZJLlCA3dSkur5kEQOfMpbdxoyQ=",
//        "x-amz-request-id: 5J3Z1VH6M41W6CGQ",
//        "Server: AmazonS3",
//        "ETag: f5287a9a3dab90bebe24efe2f59bace5",
//        "Content-Length: 1288",
//        "Accept-Ranges: bytes",
//        "Date: Fri, 13 Aug 2021 06:27:23 GMT",
//        "Last-Modified: Wed, 25 Nov 2020 13:54:41 GMT"
//})
    @GET("/endpoint.json")
    Call<ClearScoreModel> getClearScoreInfo();

}
