package api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryName;


/**
 * Created by fsouza on 27/12/17.
 */



public interface GitHubClientProfile {
    @GET("search/users")
    Call<List<GitHubProfileItemsResponse>> users( @Query("q") String user,
                                     @Query("in") String login);
}