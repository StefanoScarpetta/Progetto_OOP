package Classi;

import java.io.File;
import java.util.List;

public class Gestione {
    private List<Lavoratore> lavoratori;
    private List<Macchinario> macchinari;
    private List<Prodotto> prodotti;
    private List<Competenza> competenze;

    public Gestione(File file) {
        /*Scrivere parser file testo*/
    }

    public List<Lavoratore> getLavoratori() {
        return lavoratori;
    }

    public void setLavoratori(List<Lavoratore> lavoratori) {
        this.lavoratori = lavoratori;
    }

    public List<Macchinario> getMacchinari() {
        return macchinari;
    }

    public void setMacchinari(List<Macchinario> macchinari) {
        this.macchinari = macchinari;
    }

    public List<Prodotto> getProdotti() {
        return prodotti;
    }

    public void setProdotti(List<Prodotto> prodotti) {
        this.prodotti = prodotti;
    }

    public List<Competenza> getCompetenze() {
        return competenze;
    }

    public void setCompetenze(List<Competenza> competenze) {
        this.competenze = competenze;
    }

    @Override
    public String toString() {
        return "Gestione{" +
                "lavoratori=" + lavoratori +
                ", macchinari=" + macchinari +
                ", prodotti=" + prodotti +
                ", competenze=" + competenze +
                '}';
    }
}
