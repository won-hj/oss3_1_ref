package com.example.oss3_1_ref;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface comm_data {
    @FormUrlEncoded
    @POST("destsensor/commtest/")
    Call<String> post(
            @Field("user")String user,
            @Field("data")String data
    );

    @POST("dusstsensor/commtest-json/")
    Call<postdata> post_json(@Body postdata pd);

    @POST("dustsensor/commtest-get/")
    Call<String> get(@Query("user") String user,@Query("data") String data);
}
