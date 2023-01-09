package Classi;

import java.util.List;

public class Competenza {
    private String ruolo;
    private List<String> macchinari;

    public Competenza(String ruolo, List<String> macchinari) {
        this.macchinari = macchinari;
        this.ruolo = ruolo;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public List<String> getMacchinari() {
        return macchinari;
    }

    public void setMacchinari(List<String> macchinari) {
        this.macchinari = macchinari;
    }

    @Override
    public String toString() {
        return "Competenza{" +
                "ruolo='" + ruolo + '\'' +
                ", macchinari=" + macchinari +
                '}';
    }
}
