package com.example.maclay;

import java.io.Serializable;
import java.util.Random;

public class Formation implements Serializable {
    String intitule;
    String heureDebut;
    String heureFin;
    String event;


    public Formation(String intitule, String heureDebut, String heureFin, String event) {
        this.intitule = intitule;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.event = event;
    }

    public Formation() {
        this.intitule = "";
        this.heureDebut = "";
        this.heureFin = "";
        this.event = "";
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(String heureDebut) {
        this.heureDebut = heureDebut;
    }

    public String getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(String heureFin) {
        this.heureFin = heureFin;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    static Formation genererFormationAleatoire() {
        String[] intitules = {"Formation en développement mobile", "Formation en intelligence artificielle", "Formation en design graphique", "Formation en marketing digital", "Formation en gestion de projet"};
        String[] events = {"Café Ludique", "Centre des Congrès", "Club de Tennis", "Galerie d'Art", "Parc Municipal"};
        String[] heuresDebut = {"08:00", "09:00", "10:00", "11:00", "12:00"};
        String[] heuresFin = {"12:00", "13:00", "14:00", "15:00", "16:00"};

        Random random = new Random();
        String intitule = intitules[random.nextInt(intitules.length)];
        String event = events[random.nextInt(events.length)];
        String heureDebut = heuresDebut[random.nextInt(heuresDebut.length)];
        String heureFin = heuresFin[random.nextInt(heuresFin.length)];

        return new Formation(intitule, heureDebut, heureFin, event);
    }
}

