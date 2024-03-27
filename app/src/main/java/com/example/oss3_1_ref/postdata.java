package com.example.oss3_1_ref;

import android.util.Log;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.function.LongBinaryOperator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class postdata {
    @Expose
    @SerializedName("user") private String user;
    @SerializedName("data") private String data;

    public void set_data(String user, String data){
        this.user = user;
        this.data = data;
    }

    public void data_show(){
        Log.e("test", user+data);
    }
    public String get_data() {return data;}

    Gson gson = new GsonBuilder().setLenient().create(); //날짜/시간 구문 분석이 관대한지 여부를 지정합니다(setLenient)
    private static String url = "http://203.255.81.72:10021/";
    private final static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    protected void data_send(){
        comm_data service = retrofit.create(comm_data.class);
        Call<String>call = null;
        call = service.post(user, data);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.e("callOnResponse", response.body().toString());

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e("callOnFailure", t.toString());
            }
        });


    }
}
