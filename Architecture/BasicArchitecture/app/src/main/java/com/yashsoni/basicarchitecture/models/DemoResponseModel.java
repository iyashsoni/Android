package com.yashsoni.basicarchitecture.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yashsoni on 23/03/18.
 */

public class DemoResponseModel {
    @SerializedName("qotd_date")
    public String qotd_date;
    @SerializedName("quote")
    public Quote quote;
    public class Quote {
        @SerializedName("body")
        public String body;
        @SerializedName("author")
        public String author;
    }
}