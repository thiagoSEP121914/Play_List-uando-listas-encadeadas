package org.example;

public class PlayList {

    public ListasEncadeada<Musica> playlist = new ListasEncadeada();

    public PlayList () {
    }

    public void adicionarMusica (Musica musica) {
        playlist.adiciona(musica);
    }

    public void removerMusica (int faixa) {
        playlist.remove(faixa);
    }

    public void listarMusicas() {
        System.out.println("LISTA DE MUSICAS");
        for (int i = 0; i < playlist.getTamanho(); i++) {
            Musica musica = playlist.buscaIndice(i);
            if (musica != null) {
                System.out.println("Faixa: " + musica.getFaixa() + " "  + musica.getTitulo());
            }
        }
    }

    public void exibirAnterior (int faixa) {
        int faixaAnterior = faixa - 2;
        verificarFaixa(faixaAnterior);
        Musica musica = playlist.buscaIndice(faixaAnterior);
        System.out.println(musica);
    }

    public void exibirProximo (int faixa) {
        int proximaFaixa = faixa;
        verificarFaixa(faixa);
        Musica musica = playlist.buscaIndice(faixa);
        System.out.println(musica);
    }

    public void exibirFaixa (int faixa) {
        verificarFaixa(faixa -1);
        Musica musica = playlist.buscaIndice(faixa -1);
        System.out.println(musica);
    }

    private void verificarFaixa (int faixa) {
        if (faixa < 0 || faixa >=  playlist.getTamanho()) {
            throw new IllegalArgumentException("FAIXA NAO ENCONTRADA");
        }
    }

}
