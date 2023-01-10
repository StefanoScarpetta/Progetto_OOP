package Classi;

import java.util.List;

public class Prodotto {
    private String id;
    private String categoria;
    private Integer tempo;
    private String[] sequenza;

    public Prodotto(String id, String categoria, Integer tempo, String[] sequenza) {
        this.id = id;
        this.categoria = categoria;
        this.tempo = tempo;
        this.sequenza = sequenza;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getTempo() {
        return tempo;
    }

    public void setTempo(Integer tempo) {
        this.tempo = tempo;
    }

    public String[] getSequenza() {
        return sequenza;
    }

    public void setSequenza(String[] sequenza) {
        this.sequenza = sequenza;
    }

    @Override
    public String toString() {
        return "Prodotto{" +
                "id='" + id + '\'' +
                ", categoria='" + categoria + '\'' +
                ", tempo=" + tempo +
                ", sequenza=" + sequenza +
                '}';
    }
}
