package com.example.maclay;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Récupérez la chaîne de titre envoyée depuis l'activité précédente
        Evenement evenement = (Evenement) getIntent().getSerializableExtra("evenement");

        // Affichez la chaîne de titre dans votre TextView
        TextView eventName = findViewById(R.id.eventName);
        eventName.setText(evenement.getIntitule());

        TextView eventDescription = findViewById(R.id.eventDescription);
        eventDescription.setText(evenement.getDescription());

        TextView eventDate = findViewById(R.id.eventDate);
        eventDate.setText(evenement.getDate());

        TextView plateauMoulonFormation = findViewById(R.id.plateauMoulonFormation);
        plateauMoulonFormation.setText(evenement.getPlateuMoulon().getIntitule());

        TextView plateauMoulonDateOuverture = findViewById(R.id.plateauMoulonDateOuverture);
        plateauMoulonDateOuverture.setText(evenement.getPlateuMoulon().getHeureDebut());

        TextView plateauMoulonDateFermeture = findViewById(R.id.plateauMoulonDateFermeture);
        plateauMoulonDateFermeture.setText(evenement.getPlateuMoulon().getHeureFin());

        TextView plateauMoulonEvent = findViewById(R.id.plateauMoulonEvent);
        plateauMoulonEvent.setText(evenement.getPlateuMoulon().getEvent());

        TextView valleeFormation = findViewById(R.id.ValleeFormation);
        valleeFormation.setText(evenement.getVallee().getIntitule());

        TextView valleeDateOuverture = findViewById(R.id.ValleeDateOuverture);
        valleeDateOuverture.setText(evenement.getVallee().getHeureDebut());

        TextView valleeDateFermeture = findViewById(R.id.ValleeDateFermeture);
        valleeDateFermeture.setText(evenement.getVallee().getHeureFin());

        TextView valleeEvent = findViewById(R.id.ValleeEvent);
        valleeEvent.setText(evenement.getVallee().getEvent());

    }
}