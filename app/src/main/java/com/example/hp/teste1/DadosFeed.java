package com.example.hp.teste1;

import java.util.Calendar;

/**
 * Created by HP on 28/03/2017.
 */

public class DadosFeed {

    public String message;
    public String story;
    public Calendar created_time;
    public String id;


    public DadosFeed(String message, String story,Calendar created_time){


        message = this.message;
        story = this.story;
        created_time= this.created_time;
        id= this.id;
    }

    public DadosFeed(){

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public Calendar getCreated_time() {
        return created_time;
    }

    public void setCreated_time(Calendar created_time) {
        this.created_time = created_time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }






}
