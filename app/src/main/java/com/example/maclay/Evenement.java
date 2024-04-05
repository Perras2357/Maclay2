package com.example.maclay;

import java.io.Serializable;
import java.util.Random;

public class Evenement implements Serializable {
    private String intitule = "";
    private String description = "";
    private String date = "";
    private String lieu = "";
    private Formation plateuMoulon;
    private Formation vallee;

    public Evenement(String intitule, String description, String date, String lieu) {
        this.intitule = intitule;
        this.description = description;
        this.date = date;
        this.lieu = lieu;
        this.plateuMoulon = new Formation();
        this.vallee = new Formation();
    }

    public String getIntitule() {
        return intitule;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getLieu() {
        return lieu;
    }

    public Formation getPlateuMoulon() {
        return plateuMoulon;
    }

    public void setPlateuMoulon(Formation plateuMoulon) {
        this.plateuMoulon = plateuMoulon;
    }

    public Formation getVallee() {
        return vallee;
    }

    public void setVallee(Formation vallee) {
        this.vallee = vallee;
    }

    // Méthode pour générer aléatoirement un jeu de données d'événement
    public static Evenement genererEvenementAleatoire() {
        Random random = new Random();
        String[] intitules = {"Soirée jeux de société", "Conférence sur l'intelligence artificielle", "Tournoi de tennis", "Exposition d'art contemporain", "Concert en plein air"};
        String[] lieux = {"Café Ludique", "Centre des Congrès", "Club de Tennis", "Galerie d'Art", "Parc Municipal"};
        String[] descriptions = {"Venez passer une soirée conviviale autour de jeux de société.", "Découvrez les dernières avancées en matière d'intelligence artificielle.", "Participez à notre tournoi de tennis ou venez encourager les joueurs !", "Admirez les œuvres des artistes locaux lors de notre exposition.", "Profitez d'une soirée musicale en plein air avec plusieurs artistes."};
        String[] dates = {"2024-04-10", "2024-04-15", "2024-04-20", "2024-04-25", "2024-04-30"};

        String intitule = intitules[random.nextInt(intitules.length)];
        String lieu = lieux[random.nextInt(lieux.length)];
        String description = descriptions[random.nextInt(descriptions.length)];
        String date = dates[random.nextInt(dates.length)];
        Evenement evenement = new Evenement(intitule, description, date, lieu);
        evenement.plateuMoulon = Formation.genererFormationAleatoire();
        evenement.vallee = Formation.genererFormationAleatoire();

        return evenement;
    }


}
