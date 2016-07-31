package com.archer.gitdroid.net;

import com.archer.gitdroid.login.AccessTokenResult;
import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;

/**
 * Author: qixuefeng on 2016/7/29 0029.
 * E-mail: 377289596@qq.com
 */
public class NetClient implements NetApi {

    public static final String URL_BASE = "https://api.github.com/";

    private OkHttpClient okHttpClient;

    private Retrofit retrofit;

    private Gson gson;

    private NetApi netApi;

    private static NetClient netClient;

    private NetClient() {

        gson = new Gson();

        okHttpClient = new OkHttpClient();

        retrofit = new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();



    }

    public static NetClient getInstance() {
        if (netClient == null) {
            netClient = new NetClient();
        }
        return netClient;
    }

    @Override
    public Call<AccessTokenResult> getOAuthToken(@Field("client_id") String client, @Field("client_secret") String clientSecret, @Field("code") String code) {
        return retrofit.create(NetApi.class).getOAuthToken(client, clientSecret, code);
    }
}
