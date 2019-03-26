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

    private ImageButton boutonIMC;
    private ImageButton boutonPoids;
    private ImageButton boutonHisto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


    }

    private void cliquerMenu(final ImageButton boutonClick, final Class classe) {

        boutonClick.setOnClickListener(new View.OnClickListener()      //Creation du listener sur ce bouton
        {
            public void onClick(View actuelView)    //au clic sur le bouton
            {
                Intent intent = new Intent(MainActivity.this, classe);  //Lancer l'activité DisplayVue
                startActivity(intent);    //Afficher la vue
            }
        });
    }

    private void init(){
        boutonIMC = (ImageButton) findViewById(R.id.imcButton);
        boutonPoids = (ImageButton) findViewById(R.id.poidsIdealButton);
        boutonHisto = (ImageButton) findViewById(R.id.historiqueButton);

        cliquerMenu(boutonIMC, CalculIMCActivity.class);
        cliquerMenu(boutonPoids, CalculPoidsIdealActivity.class);
        cliquerMenu(boutonHisto, HistoriqueActivity.class);

    }

}
