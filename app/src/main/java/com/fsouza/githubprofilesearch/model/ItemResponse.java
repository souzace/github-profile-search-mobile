package com.fsouza.githubprofilesearch.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


/**
 * Created by fsouza on 28/12/17.
 */

public class ItemResponse {
    @SerializedName("items")
    @Expose

    private List<Item> items;

    public List<Item> getItems(){
        return items;
    }

    public void setItems(List<Item> items){
        this.items = items;
    }

}
