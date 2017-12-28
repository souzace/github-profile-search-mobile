package api;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by fsouza on 27/12/17.
 */


public class GitHubProfileItems {
    @SerializedName("login")
    @Expose
    private String login;

    public GitHubProfileItems(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }



}
