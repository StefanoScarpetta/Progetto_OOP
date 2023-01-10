package Classi;

import java.util.List;

public class Lavoratore {
    private String id;
    private String nome;
    private String cognome;
    private Integer eta;
    private String ruolo;
    private String[] macchinari;

    public Lavoratore(String id, String nome, String cognome, Integer eta, String ruolo, String[] macchinari) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.ruolo = ruolo;
        this.macchinari = macchinari;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Integer getEta() {
        return eta;
    }

    public void setEta(Integer eta) {
        this.eta = eta;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public String[] getMacchinari() {
        return macchinari;
    }

    public void setMacchinari(String[] macchinari) {
        this.macchinari = macchinari;
    }

    @Override
    public String toString() {
        return "Lavoratore{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", eta=" + eta +
                ", ruolo='" + ruolo + '\'' +
                ", macchinari=" + macchinari +
                '}';
    }
}
