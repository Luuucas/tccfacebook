package com.example.hp.teste1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.Collection;

public class FeedNoticiasActivity extends AppCompatActivity {

    Gson gson = new Gson();
    FeedNoticia feedNoticia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_noticias);

        FacebookSdk.sdkInitialize(this);

        GraphRequest request = GraphRequest.newMeRequest(
                AccessToken.getCurrentAccessToken(),
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        // Insert your code here
                        Toast.makeText(FeedNoticiasActivity.this, response.getJSONObject().toString(), Toast.LENGTH_SHORT).show();
                    }
                });

        Bundle parameters = new Bundle();
        parameters.putString("fields", "feed.limit(10)");
        request.setParameters(parameters);
        request.executeAsync();
    }
}
