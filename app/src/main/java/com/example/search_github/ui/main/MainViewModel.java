package com.example.search_github.ui.main;

import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.search_github.api.Api;
import com.example.search_github.api.RetrofitClient;
import com.example.search_github.data.model.User;
import com.example.search_github.data.model.UserResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {
    private final MutableLiveData<ArrayList<User>> listUsers = new MutableLiveData<>();

    public void setSearchUsers(String query) {
        Api apiInstance = RetrofitClient.getApiInstance();
        apiInstance.getSearchUsers(query).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.isSuccessful()) {
                    listUsers.postValue(response.body().getItems());
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.d("Failure", t.getMessage());
            }
        });
    }

    public LiveData<ArrayList<User>> getSearchUsers() {
        return listUsers;
    }
}
