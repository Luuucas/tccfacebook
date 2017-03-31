package com.example.hp.teste1;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by HP on 29/03/2017.
 */

public class FeedNoticia {

    public Collection<DadosFeed> data;
    public String id;
    public ArrayList<String> paging;


    public FeedNoticia(Collection<DadosFeed> data, String id, ArrayList<String> paging) {
        this.data = data;
        this.id = id;
        this.paging = paging;
    }

    public FeedNoticia(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public Collection<DadosFeed> getDatas() {
        return data;
    }

    public void setData(Collection<DadosFeed> data) {
        this.data = data;
    }
}
