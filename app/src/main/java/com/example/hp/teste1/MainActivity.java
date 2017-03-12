package com.example.hp.teste1;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.github.nisrulz.sensey.OrientationDetector;
import com.github.nisrulz.sensey.Sensey;
import com.github.nisrulz.sensey.TouchTypeDetector;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    TextToSpeech textoParaFalar;
    private static final String TAG = "TesteTCC";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Sensey.getInstance().startTouchTypeDetection(this,touchTypListener);
        Sensey.getInstance().init(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textoParaFalar = new TextToSpeech(this,this);
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

            TextToSpeechFunction("Bem vindo ao Facebook ! Escolha uma das opções," +
                    "para fazer publicação deslize o dedo para cima," +
                    "para escutar o feed de notícias deslize o dedo para baixo");
        }

    }

    TouchTypeDetector.TouchTypListener touchTypListener = new TouchTypeDetector.TouchTypListener() {
        @Override
        public void onTwoFingerSingleTap() {

        }

        @Override
        public void onThreeFingerSingleTap() {

        }

        @Override
        public void onDoubleTap() {
            TextToSpeechFunction("Confirmar Ação");
            Log.d(TAG,"DUPLO TOQUE OK");
        }

        @Override
        public void onScroll(int direcaoScoll) {
            switch (direcaoScoll) {
                case TouchTypeDetector.SCROLL_DIR_UP: {
                    TextToSpeechFunction("Fazer Publicação");
                    Log.d(TAG,"SCROLL CIMA OK");
                }
                case TouchTypeDetector.SCROLL_DIR_DOWN: {
                    TextToSpeechFunction("Ir para Feed de Notícias");
                    Log.d(TAG,"SCROLL BAIXO OK");
                }
                default:
                    // nada a fazer
                    break;
            }

        }

        @Override
        public void onSingleTap() {

        }

        @Override
        public void onSwipe(int i) {

        }

        @Override
        public void onLongPress() {

        }
    };
}
