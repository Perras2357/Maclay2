package com.example.maclay;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    List<Button> btns = new ArrayList<>();
    LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        layout = findViewById(R.id.eventContainer);
        List<Evenement> evenements = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < random.nextInt(10)+3; i++) {
            evenements.add(Evenement.genererEvenementAleatoire());
        }

        //ajouter les evenements dans le layout
        for (Evenement evenement : evenements) {
            Button btn = new Button(this);
            //ajouter des bordure avec radius de 10 et coleur #63003C
            btn.setBackgroundResource(R.drawable.rounded_border);
            btn.setText(evenement.getIntitule());
            //set margin left and right
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(60, 10, 60, 10);
            btn.setLayoutParams(params);
            layout.addView(btn);
            btns.add(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openMainView(evenement);
                }
            });
        }

    }

    private void openMainView(Evenement evenement) {
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("evenement",evenement);
        startActivity(intent);
    }
}