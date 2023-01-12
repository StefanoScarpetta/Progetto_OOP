package Classi;

import java.io.File;
import java.util.*;

public class Gestione {
    private List<Lavoratore> lavoratori;
    private List<Macchinario> macchinari;
    private List<Prodotto> prodotti;
    private List<Competenza> competenze;
    private List<String> task;

    public Gestione(List<String> file) {

        String[] indici = file.get(0).split(" ");
        int L = Integer.parseInt(indici[0]);
        int M = Integer.parseInt(indici[1]);
        int P = Integer.parseInt(indici[2]);

        lavoratori = new ArrayList<Lavoratore>();
        macchinari = new ArrayList<Macchinario>();
        prodotti = new ArrayList<Prodotto>();
        competenze = new ArrayList<Competenza>();

        for (int i=1; i<L+1; i++) {
            String[] lavoratore = file.get(i).split(" ");
            String[] assegnazione = file.get(i+3+L+M+P).split(" ");
            lavoratori.add(new Lavoratore(
                    lavoratore[0], lavoratore[1], lavoratore[2],
                    Integer.parseInt(lavoratore[3]), lavoratore[4],
                    assegnazione[2].split(",")));
        }

        for (int i=L+1; i<L+4; i++) {
            String[] competenza = file.get(i).split(" ");
            competenze.add(new Competenza(
                    competenza[0], competenza[2].split(",")
            ));
        }

        for (int i=L+4; i<L+M+4; i++) {
            String[] macchinario = file.get(i).split(" ");
            macchinari.add(new Macchinario(
                    macchinario[0], macchinario[1], macchinario[2].split(","),
                    macchinario[3], macchinario[4].split(",")
            ));
        }

        for (int i=L+M+4; i<L+M+P+4; i++) {
            String[] prodotto = file.get(i).split(" ");
            prodotti.add(new Prodotto(
                    prodotto[0], prodotto[1], Integer.parseInt(prodotto[2]),
                    prodotto[3].split("->")
            ));
        }

        if (file.size() >= 1+L+3+M+P+L+1) {
            String[] controlloTask = file.get(L+3+M+P+L+1).split(" ");
            if (Objects.equals(controlloTask[0], "TASK1")) {
                task = new ArrayList<String>();
                task.add(controlloTask[0]);
            } else if (Objects.equals(controlloTask[0], "TASK2")) {
                task = new ArrayList<String>();
                task.add(controlloTask[0]);
                task.add(controlloTask[1]);
                task.add(controlloTask[2]);
                task.add(controlloTask[3]);
            } else if (Objects.equals(controlloTask[0], "TASK3")) {
                task = new ArrayList<String>();
                task.add(controlloTask[0]);
                task.add(controlloTask[1]);
                for (int i=2; i<2+Integer.parseInt(controlloTask[1]); i++) {
                    task.add(file.get(i+L+3+M+P+L));
                }
            } else {
                task = new ArrayList<String>();
                task.add("not valid");
            }
        } else {
            task = new ArrayList<String>();
            task.add("not valid");
        }

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

    public List<String> getTask() {
        return task;
    }

    public void setTask(List<String> task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "Gestione = {" +
                "lavoratori = " + lavoratori +
                ", macchinari = " + macchinari +
                ", prodotti = " + prodotti +
                ", competenze = " + competenze +
                ", task = " + task +
                '}';
    }
}
