package com.example.hp.teste1;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.Locale;

public class LoginActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    CallbackManager callbackManager;
    TextToSpeech textoParaFalar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        FacebookSdk.sdkInitialize(this);
        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions("email");
        callbackManager= CallbackManager.Factory.create();



        textoParaFalar = new TextToSpeech(this,this);

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this,MainActivity.class);

                startActivity(intent);

                finish();

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });
    }

    public void TextToSpeechFunction(String textholder) {


        textoParaFalar.speak(textholder, TextToSpeech.QUEUE_FLUSH, null);

    }

    @Override
    public void onDestroy() {

        textoParaFalar.shutdown();

        super.onDestroy();
    }


    @Override
    public void onInit(int Text2SpeechCurrentStatus) {

        if (Text2SpeechCurrentStatus == TextToSpeech.SUCCESS) {

            textoParaFalar.setLanguage(new Locale("pt", "BR"));

            TextToSpeechFunction("Olá! Seja bem vindo ao Senhora pô!" +
                    "Eu serei seu guia durante toda sua experiência no Facebook," +
                    "Para que possa fazer login, pessa a alguém de sua confiança para fazê-lo," +
                    "Prometo que esta será a única vez que precisará da ajuda de alguém!");
        }

    }
}
