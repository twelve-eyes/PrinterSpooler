/* 
Nomes: 
Allan Carneiro da Cunha Silveira
Isadora Voss Brugnera
Jenifer Beatriz Nunes Ribeiro
*/
package twelveeyes.allanisadorajenifer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Impressao {
    private String arquivo;
    private String situacao;

    public Impressao(String arquivo) {
        this.arquivo = arquivo;
        this.situacao = "Pendente"; // Imprimindo
    }

    // Métodos para acessar as variáveis
    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}

public class AllanIsadoraJenifer {

    static Scanner scanner = new Scanner(System.in);
    static Queue<Impressao> filaImpressao = new LinkedList<>();
    static int totalImpressos = 0;

    public static void main(String[] args) {
        // menu
        int opcao = 0;
        do {
            exibirMenu();
            opcao = lerInteiro("Escolha a opcao: ");
            limparTela();
            switch (opcao) {
                case 1:
                    incluirImpressao();
                    break;
                case 2:
                    iniciarImpressao();
                    break;
                case 3:
                    finalizarImpressao();
                    break;
                case 4:
                    mostrarFila();
                    break;
                case 5:
                    mostrarQuantidade();
                    break;
                case 0:
                    System.out.println("\nBYE. THANK YOU!");
                    break;
                default:
                    System.out.println("\nOpcao invalida.");
            }
        } while (opcao != 0);
    }

    public static void exibirMenu() {

        System.out.println("\n--------------------------------------------");
        System.out.println("SISTEMA DE IMPRESSÃO");
        System.out.println("--------------------------------------------");

        System.out.println(" 1 - Chegada de um pedido de impressão: inserir um documento na fila. ");
        System.out.println(" 2 - Iniciar uma impressão: iniciar a impressão do primeiro documento da fila.");
        System.out.println(" 3 - Finalizar a impressão: finalizar a impressão do documento atual.");
        System.out.println(" 4 - Mostrar fila de impressão: exibir todos os documentos na fila.");
        System.out.println(" 5 - Mostrar totalizador: mostrar quantos documentos já foram impressos.");
        System.out.println(" 6 - Cancelar próximo pedido: remover o próximo documento, sem imprimí-lo.");
        System.out.println(" 7 - Mostrar o documento: mostra qual o documento que está sendo impresso.");
        System.out.println(" 0 - Encerrar o sistema.");

        System.out.println("==============================");
    }

    public static void incluirImpressao() {
        System.out.println("--------Incluindo documentos na fila de impressão---------");
        System.out.print("Nome do documento: ");
        String arquivo = scanner.nextLine();

        Impressao documento = new Impressao(arquivo);

        filaImpressao.add(documento);
        System.out.println("Documento incluindo na fila de impressão!");
    }

    public static void iniciarImpressao() {
        if (filaImpressao.isEmpty()) {
            System.out.println("Fila vazia. Nenhum documento para imprimir.");
            return;
        }
        Impressao documentoAtual = filaImpressao.peek(); // Pega o primeiro documento da fila, mas não remove

        if (documentoAtual.getSituacao() == "Imprimindo") {
            System.out.println("O documento já está sendo impresso: " + documentoAtual.getArquivo());
        } else if (documentoAtual.getSituacao() == "Pendente") {
            System.out.println("Iniciando impressão do documento: " + documentoAtual.getArquivo());
            documentoAtual.setSituacao("Imprimindo");
        }
    }

    public static void finalizarImpressao() {
        if (filaImpressao.isEmpty()) {
            System.out.println("Fila vazia. Nenhum documento para finalizar.");
            return;
        }

        Impressao documentoAtual = filaImpressao.peek(); // Pega o primeiro documento da fila, mas não remove

        if (documentoAtual.getSituacao() == "Pendente") {
            System.out.println("Nenhum documento está sendo impresso. Inicie a impressão primeiro.");
        } else if (documentoAtual.getSituacao() == "Imprimindo") {
            System.out.println("Finalizando impressão do documento: " + documentoAtual.getArquivo());
            filaImpressao.remove(); // Remove o documento da fila após finalizar
            totalImpressos++;
        }
    }

    public static void mostrarFila() {

        if (filaImpressao.isEmpty()) {
            System.out.println("A fila está vazia.");
            return;
        }

        System.out.println("----------Mostrar documentos na fila de impressão----------");

        int contador = 1;
        for (Impressao documento : filaImpressao) {
            System.out.println(
                    contador++ + " - Documento: " + documento.getArquivo() + " | Situação: " + documento.getSituacao());
        }
    }

    public static void mostrarQuantidade() {
        System.out.println("-------------Quantidade de Impressoes-------------");
        System.out.println("Quantidade de documentos impressos: " + totalImpressos);
    }

    public static int lerInteiro(String mensagem) {

        while (true) {

            try {

                System.out.print(mensagem);
                return Integer.parseInt(scanner.nextLine());

            } catch (Exception e) {

                System.out.println("*** ATENCAO: Digite um numero inteiro valido");
            }
        }
    }

    public static void limparTela() { // Limpar tela, kaue ensinou :)
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}