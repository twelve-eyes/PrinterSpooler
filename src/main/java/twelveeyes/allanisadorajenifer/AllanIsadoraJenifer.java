
/* 
Nomes: 
Allan Carneiro da Cunha Silveira
Isadora Voss Brugnera
Jenifer Beatriz Nunes Ribeiro
*/
package twelveeyes.allanisadorajenifer;

import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

class Impressao {
    private String arquivo;
    private int codigo;
    private String tipoArq;

    public Impressao(String arquivo, int codigo, String tipoArq) {
        this.arquivo = arquivo;
        this.codigo = codigo;
        this.tipoArq = tipoArq;
    }

    // Métodos para acessar as variáveis
    public String getAqruivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipoAr() {
        return tipoArq;
    }

    public void setTipoArq(String tipoArq) {
        this.tipoArq = tipoArq;
    }
}

public class AllanIsadoraJenifer {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Queue<Impressao> filaImpressao = new LinkedList<>();
        // menu
        int opcao = 0;
        do {
            exibirMenu();
            opcao = lerInteiro("Escolha a opcao: ");
            switch (opcao) {
                case 1:
                    incluirImpressao(opcao, filaImpressao);
                    break;
                case 4:
                    mostrarFila(opcao, filaImpressao);
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

    public static void incluirImpressao(int posicao, Queue<Impressao> filaImpressao) {
        // Falta colocar uma condicao se já existe o documento na fila!
        System.out.println("--------Incluindo documentos na fila de impressão---------");
        System.out.println("Nome do documento:");
        String arquivo = scanner.nextLine();
        int codigo = lerInteiro("Código do documento:");
        System.out.println("Tipo do arquivo:");
        String tipoArq = scanner.nextLine();

        Impressao documento = new Impressao(arquivo, codigo, tipoArq);

        filaImpressao.add(documento);
        System.out.println("Documento incluindo na fila de impressão!");
    }

    public static void mostrarFila(int posicao, Queue<Impressao> filaImpressao) {
        System.out.println("----------Mostrar documentos na fila de impressão----------");
        if (filaImpressao.isEmpty()) {
            System.out.println("A fila está vazia.");
        }
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
}