package com.archer.gitdroid.login;

import com.archer.gitdroid.net.NetApi;
import com.archer.gitdroid.net.NetClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Author: qixuefeng on 2016/7/29 0029.
 * E-mail: 377289596@qq.com
 */
public class LoginPresenter {

    private Call<AccessTokenResult> oAuthToken;

    public void login(String code) {

        if (oAuthToken != null) {
            oAuthToken.cancel();
        }
        oAuthToken = NetClient.getInstance().getOAuthToken(NetApi.CLIENT_ID, NetApi.CLIENT_SECRET, code);
        oAuthToken.enqueue(callback);

    }

    private Callback<AccessTokenResult> callback = new Callback<AccessTokenResult>() {
        @Override
        public void onResponse(Call<AccessTokenResult> call, Response<AccessTokenResult> response) {

            if (response != null && response.isSuccessful()) {

                AccessTokenResult body = response.body();

                if (body == null) {
                    return;
                }

                body.getAccessToken();

            }

        }

        @Override
        public void onFailure(Call<AccessTokenResult> call, Throwable t) {

        }
    };

}
