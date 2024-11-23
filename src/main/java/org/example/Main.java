package org.example;

import org.example.Musica;
import org.example.PlayList;

import java.util.Scanner;

public class Main {
    public static PlayList playList = new PlayList();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("PLAYLIST TABAJARA!");

        while (true) {
            exibirMenu();
            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    adicionarMusica();
                    break;
                case 2:
                    playList.listarMusicas();
                    break;
                case 3:
                    buscarMusica();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("[1] Adicionar música");
        System.out.println("[2] Listar músicas");
        System.out.println("[3] Buscar música");
        System.out.println("[4] Sair");
    }

    private static void adicionarMusica() {
        System.out.print("Faixa: ");
        int faixa = sc.nextInt();
        sc.nextLine(); // Limpa o buffer do scanner
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Artista: ");
        String artista = sc.nextLine();
        System.out.print("Ano: ");
        String ano = sc.nextLine();
        System.out.print("Link: ");
        String link = sc.nextLine();

        Musica novaMusica = new Musica(faixa, titulo, artista, ano, link);
        playList.adicionarMusica(novaMusica);
        System.out.println("Música adicionada com sucesso!");
    }

    private static void buscarMusica() {
        System.out.print("Digite a faixa que deseja buscar: ");
        int faixa = sc.nextInt();

        Musica musica = playList.playlist.buscaIndice(faixa - 1);

        if (musica != null) {
            System.out.println("Música encontrada:");
            System.out.println(musica);
        } else {
            System.out.println("Música não encontrada!");
        }
    }
}
