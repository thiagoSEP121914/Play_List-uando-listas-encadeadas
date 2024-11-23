package org.example;

public class Musica {

    private int Faixa;
    private String titulo;
    private String artista;

    private String periodo;

    private String link;

    public Musica () {
    }

    public Musica(int faixa, String titulo, String artista, String periodo, String link) {
        Faixa = faixa;
        this.titulo = titulo;
        this.artista = artista;
        this.periodo = periodo;
        this.link = link;

    }

    public int getFaixa() {
        return Faixa;
    }

    public void setFaixa(int faixa) {
        Faixa = faixa;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


    @Override
    public String toString() {
        return  "Faixa=" + Faixa + "\n" +
                "Titulo='" + titulo + "\n" +
                "Artista='" + artista + "\n" +
                "Priodo='" + periodo + "\n" +
                "Link=" + link + "\n";
    }
}
