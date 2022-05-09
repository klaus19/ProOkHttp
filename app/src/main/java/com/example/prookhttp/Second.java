package com.example.prookhttp;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.prookhttp.databinding.SecondBinding;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class Second extends AppCompatActivity {

    private SecondBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = SecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setOkhhtp();

    }

    private void setOkhhtp() {
        OkHttpClient client = new OkHttpClient();

        Request get = new Request.Builder()
                .url("https://reqres.in/api/users?page=2")
                .build();

        client.newCall(get).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
               e.printStackTrace();

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {

                 try {
                     ResponseBody responseBody = response.body();
                     if (response.isSuccessful()){
                         throw new IOException("Unexpected Code" +response);
                     }
                     Log.i("data",responseBody.string());
                 }catch (Exception e){
                     e.printStackTrace();
                 }
            }
        });
    }
}
