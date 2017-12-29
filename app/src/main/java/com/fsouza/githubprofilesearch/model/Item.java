package com.fsouza.githubprofilesearch.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by fsouza on 28/12/17.
 */

public class Item {
    @SerializedName("login")
    @Expose
    private String login;

    @SerializedName("avatar")
    @Expose
    private String avarUrl;

    @SerializedName("html_url")
    @Expose
    private String htmlUrl;

    public Item(String login, String avarUrl, String htmlUrl) {
        this.login = login;
        this.avarUrl = avarUrl;
        this.htmlUrl = htmlUrl;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login){
        this.login = login;
    }


    public String getAvarUrl() {
        return avarUrl;
    }

    public void setAvarUrl(String avarUrl){
        this.avarUrl = avarUrl;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl){
        this.htmlUrl = htmlUrl;
    }

}
