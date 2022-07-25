package com.hadesfranklyn.pedrapapeltesoura;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view) {
        this.opcaoSelecionada("Pedra");
    }

    public void selecionadoPapel(View view) {
        this.opcaoSelecionada("Papel");
    }

    public void selecionadoTesoura(View view) {
        this.opcaoSelecionada("Tesoura");
    }

    public void opcaoSelecionada(String escolhaUsuario) {

        ImageView imageResultado = findViewById(R.id.imageResultado);
        TextView textResultado = findViewById(R.id.textResultado);

        int numero = new Random().nextInt(3);// 0 1 2

        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        String escolhaApp = opcoes[numero];

        switch (escolhaApp) {
            case "Pedra":
                imageResultado.setImageResource(R.drawable.pedra);
                break;
            case "Papel":
                imageResultado.setImageResource(R.drawable.papel);
                break;
            case "Tesoura":
                imageResultado.setImageResource(R.drawable.tesoura);
                break;
        }
        if (
                (escolhaApp == "Tesoura" && escolhaUsuario == "Papel")
                        || (escolhaApp == "Papel" && escolhaUsuario == "Pedra")
                        || (escolhaApp == "Pedra" && escolhaUsuario == "Tesoura")
        ) {// App ganhador
            textResultado.setText("Você perdeu :(");
        } else if (
                (escolhaUsuario == "Tesoura" && escolhaApp == "Papel")
                        || (escolhaUsuario == "Papel" && escolhaApp == "Pedra")
                        || (escolhaUsuario == "Pedra" && escolhaApp == "Tesoura")
        ) {// Usuario ganhador
            textResultado.setText("Você ganhou :)");
        } else {// Empate
            textResultado.setText("Empatamos ;)");
        }


        System.out.println("Item clicado: " + escolhaApp);

    }
}