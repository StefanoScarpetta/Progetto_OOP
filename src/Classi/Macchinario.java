package Classi;

import java.util.List;

public class Macchinario {
    private String id;
    private String zona;
    private List<Integer> orario;
    private String tipologia;
    private List<String> conflitto;

    public Macchinario(String id, String zona, List<Integer> orario, String tipologia, List<String> conflitto) {
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

    public List<Integer> getOrario() {
        return orario;
    }

    public void setOrario(List<Integer> orario) {
        this.orario = orario;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public List<String> getConflitto() {
        return conflitto;
    }

    public void setConflitto(List<String> conflitto) {
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
