package com.example.search_github.api;

import com.example.search_github.data.model.UserResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface Api {
    @GET("search/users")
    @Headers("Authorization: token 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")
    Call<UserResponse> getSearchUsers(
            @Query("q") String query
    );
}