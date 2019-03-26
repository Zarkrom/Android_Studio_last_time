package com.example.marobine.premierprojet.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.marobine.premierprojet.R;

import static com.example.marobine.premierprojet.R.id.imcButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(MainActivity.this, CalculIMCActivity.class);
        // MainActivity.this : instance de classe où on est au moment du clic, puis classe où on va
        startActivity(intent);
        clicIMC();
    }


    private void clicIMC() {
        // appel de l'évènement
        ((ImageButton) findViewById(imcButton)).setOnClickListener(new ImageButton.OnClickListener() {
            // on redéfini à la volée la méthode onClick
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalculIMCActivity.class);
                // MainActivity.this : instance de classe où on est au moment du clic, puis classe où on va
                startActivity(intent);
            }
        });
    }

    private void clicPoidsIdeal() {
        // appel de l'évènement
        ((ImageButton) findViewById(imcButton)).setOnClickListener(new ImageButton.OnClickListener() {
            // on redéfini à la volée la méthode onClick
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalculPoidsIdealActivity.class);
                // MainActivity.this : instance de classe où on est au moment du clic, puis classe où on va
                startActivity(intent);
            }
        });
    }

    private void clicHisto() {
        // appel de l'évènement
        ((ImageButton) findViewById(imcButton)).setOnClickListener(new ImageButton.OnClickListener() {
            // on redéfini à la volée la méthode onClick
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HistoriqueActivity.class);
                // MainActivity.this : instance de classe où on est au moment du clic, puis classe où on va
                startActivity(intent);
            }
        });
    }
}
