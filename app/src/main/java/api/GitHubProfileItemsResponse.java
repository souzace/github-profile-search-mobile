package api;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by fsouza on 27/12/17.
 */


public class GitHubProfileItemsResponse {
    @SerializedName("items")
    @Expose

    private List<GitHubProfileItems> items;

    private List<GitHubProfileItems> getItems(){
        return items;
    }


   

}
