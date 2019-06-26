package br.com.digitalhouse.exercicioroomdatabaseagendatelefonica.splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

import br.com.digitalhouse.exercicioroomdatabaseagendatelefonica.R;
import br.com.digitalhouse.exercicioroomdatabaseagendatelefonica.model.Contato;
import br.com.digitalhouse.exercicioroomdatabaseagendatelefonica.view.ContatosActivity;

public class SplashActivity extends AppCompatActivity {

    //Declaracao de atributos
    private ImageView imageViewSplash;
    private Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //Inicializa as views
        initViews();

        //Ação ao clicar na Imagem
        clickImage();

        //Tempo de execibiçãoda imagem na tela
        tempoExibirImagem();
    }

    private void initViews() {
        imageViewSplash = findViewById(R.id.imageViewSplash);
    }

    private void clickImage() {
        imageViewSplash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Chama a tela de Login
                jump();
            }
        });
    }

    private void tempoExibirImagem() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                jump();
            }
        }, 3000);
    }

    private void jump() {

        timer.cancel();

        Intent intent = new Intent(SplashActivity.this, ContatosActivity.class);

        try {
            startActivity(intent);
        }catch (Exception e){
            e.printStackTrace();
        }

        finish();
    }
}