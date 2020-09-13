package com.example.gads.leaderboard.webservice.builder;

import android.util.Log;

import com.example.gads.leaderboard.common.ApiEndPoints;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GoogleFormRetrofitServiceBuilder {

    private static final String LOG_TAG = RetrofitServiceBuilder.class.getSimpleName();

    private static Retrofit retrofit;

    static {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(message -> Log.d(LOG_TAG, message));
        loggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(2, TimeUnit.MINUTES)
                .writeTimeout(2, TimeUnit.MINUTES)
                .addInterceptor(loggingInterceptor);

        retrofit = new Retrofit.Builder().baseUrl(ApiEndPoints.GADS_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .client(okHttpClientBuilder.build())
                .build();
    }

    public static <S> S buildService(Class<S> serviceType) {
        return retrofit.create(serviceType);
    }
}
