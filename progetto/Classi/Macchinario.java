package Classi;

import java.util.List;

public class Macchinario {
    private String id;
    private String zona;
    private String[] orario;
    private String tipologia;
    private String[] conflitto;

    public Macchinario(String id, String zona, String[] orario, String tipologia, String[] conflitto) {
        this.id = id;
        this.zona = zona;
        this.orario = orario;
        this.tipologia = tipologia;
        this.conflitto = conflitto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String[] getOrario() {
        return orario;
    }

    public void setOrario(String[] orario) {
        this.orario = orario;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public String[] getConflitto() {
        return conflitto;
    }

    public void setConflitto(String[] conflitto) {
        this.conflitto = conflitto;
    }

    @Override
    public String toString() {
        return "Macchinario{" +
                "id='" + id + '\'' +
                ", zona='" + zona + '\'' +
                ", orario=" + orario +
                ", tipologia='" + tipologia + '\'' +
                ", conflitto=" + conflitto +
                '}';
    }
}
