package com.fsouza.githubprofilesearch.api;

import com.fsouza.githubprofilesearch.model.ItemResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by fsouza on 28/12/17.
 */

public interface Service {
    @GET("search/users")
    Call<ItemResponse> getItems(@Query("q") String user,
                             @Query("in") String login);
}
