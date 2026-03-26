import java.util.Collections; // Métodos utilitários para coleções. USADO NA ORDENACAO DA LISTA
import java.util.Comparator;  // Define regras de comparação para ordenar objetos
import java.util.LinkedList;  // Classe. Implementa uma lista encadeada
import java.util.List;        // Interface. Define operações de listas
                              // List define o que uma lista faz, enquanto LinkedList define como a lista é implementada
import java.util.Scanner;

// ============================== CLASSE ALUNO ===================================
class Aluno {

    // ATRIBUTOS
    private int    matricula;
    private String nome;
    private double notaN1;
    private double notaN2;

    // CONSTRUTOR
    public Aluno( int matricula , String nome , double notaN1 , double notaN2 ) {
        this.matricula = matricula;
        this.nome      = nome;
        this.notaN1    = notaN1;
        this.notaN2    = notaN2;
    }

    // MÉTODOS
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula( int matricula ) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome( String nome ) {
        this.nome = nome;
    }

    public double getNotaN1() {
        return notaN1;
    }

    public void setNotaN1( double notaN1 ) {
        this.notaN1 = notaN1;
    }

    public double getNotaN2() {
        return notaN2;
    }

    public void setNotaN2( double notaN2 ) {
        this.notaN2 = notaN2;
    }

    public double calcularMedia() {
        return ( notaN1 + notaN2 ) / 2.0;
    }

    public String verificarSituacao() {

        double media = calcularMedia();

        if ( media >= 7.0 ) {
            return "Aprovado";
        } else if ( media >= 5.0)  {
            return "REC";
        } else {
            return "Reprovado";
        }
    }

    public void mostrarDados() {

        System.out.println("Matricula : " + matricula );
        System.out.println("Nome      : " + nome );
        System.out.println("Nota N1   : " + notaN1 );
        System.out.println("Nota N2   : " + notaN2 );
        System.out.println("Media     : " + String.format( "%.1f", calcularMedia() ) );
        System.out.println("Situacao  : " + verificarSituacao() );

    }
}

public class ExemploAlunosList {

    static Scanner scanner = new Scanner(System.in);
    static List<Aluno> listaAlunos = new LinkedList<>();

    public static void main(String[] args) {

        int opcao;

        do {

            exibirMenu();
            opcao = lerInteiro( "Escolha uma opcao : " );

            switch (opcao) {

                case 1:
                    incluirAluno( 'F' );
                    break;

                case 2:
                    incluirAluno( 'I' );
                    break;

                case 3:
                    listarAlunos();
                    break;

                case 4:
                    buscarAlunoPorMatricula();
                    break;

                case 5:
                    alterarAluno();
                    break;

                case 6:
                    removerAlunoPorMatricula();
                    break;

                case 7:
                    mostrarQuantidadeAlunos();
                    break;

                case 8:
                    exibirMediaGeralTurma();
                    break;

                case 9:
                    ordenarPorNome();
                    break;

                case 10:
                    ordenarPorMediaDecrescente();
                    break;

                case 11:
                    listarAprovados();
                    break;

                case 12:
                    removerPrimeiroAluno();
                    break;

                case 13:
                    removerUltimoAluno();
                    break;

                case 0:
                    System.out.println( "\nBYE. THANK YOU!" );
                    break;

                default:
                    System.out.println( "\nOpcao invalida." );
            }

        } while ( opcao != 0 );

        scanner.close();
    }

    public static void exibirMenu() {

        System.out.println("\n--------------------------------------------");
        System.out.println("SISTEMA DE ALUNOS");
        System.out.println("--------------------------------------------");

        System.out.println(" 1 - Cadastrar aluno no final da lista");
        System.out.println(" 2 - Cadastrar aluno no inicio da lista");
        System.out.println(" 3 - Listar todos os alunos");
        System.out.println(" 4 - Buscar aluno por matricula");
        System.out.println(" 5 - Alterar dados de um aluno");
        System.out.println(" 6 - Remover aluno por matricula");
        System.out.println(" 7 - Mostrar quantidade de alunos");
        System.out.println(" 8 - Exibir media geral da turma");
        System.out.println(" 9 - Ordenar alunos por nome");
        System.out.println("10 - Ordenar alunos por media (decrescente)");
        System.out.println("11 - Listar apenas aprovados");
        System.out.println("12 - Remover primeiro aluno");
        System.out.println("13 - Remover ultimo aluno");
        System.out.println(" 0 - Sair");

        System.out.println("==============================");
    }

    public static void incluirAluno(char posicao) {

        System.out.println( "\n--- Cadastrar Aluno ---" );

        int matricula = lerInteiro( "Digite a matricula : " );

        if ( matriculaJaExiste( matricula ) ) {
            System.out.println( "*** ATENCAO: Ja existe um aluno com essa matricula" );
            return;
        }

        System.out.print( "Digite o nome : " );
        String nome = scanner.nextLine();

        double nota1 = lerDouble( "Digite a nota N1 : " );
        double nota2 = lerDouble( "Digite a nota N2 : " );

        Aluno aluno = new Aluno( matricula , nome , nota1 , nota2 );

        if ( posicao == 'F' ) {
            listaAlunos.addLast( aluno );
            //listaAlunos.add( aluno );
            System.out.println( "Aluno inserido no final da lista" );
        } 
        else{
            listaAlunos.addFirst( aluno );
            //listaAlunos.add( 0 , aluno );
            System.out.println( "Aluno inserido no inicio da lista" );
        } 
    }

    public static void listarAlunos() {

        System.out.println("\n--- Listar alunos ---");

        if ( listaAlunos.isEmpty() ) {
            System.out.println( "*** ATENCAO: Nenhum aluno cadastrado" );
            return;
        }

        int posicao = 1;

        for ( Aluno aluno : listaAlunos ) {

            System.out.println("\nAluno #" + posicao );
            aluno.mostrarDados();
            System.out.println("----------------------------");

            posicao++;
        }
    }

    public static void buscarAlunoPorMatricula() {

        System.out.println( "\n--- Busca por matricula ---" );

        int matricula = lerInteiro( "Digite a matricula : " );

        Aluno aluno = localizarAlunoPorMatricula( matricula );

        if ( aluno != null ) {

            System.out.println( "\nAluno encontrado : " );
            aluno.mostrarDados();

        } else {

            System.out.println("*** ATENCAO: Aluno nao encontrado");

        }
    }

    public static void alterarAluno() {

        System.out.println( "\n--- Alteracao de aluno ---" );

        int matricula = lerInteiro( "Digite a matricula do aluno : " );

        Aluno aluno = localizarAlunoPorMatricula( matricula );

        if ( aluno == null ) {

            System.out.println( "*** ATENCAO: Aluno nao encontrado" );
            return;
        }

        System.out.println("\nDados atuais :");
        aluno.mostrarDados();

        System.out.print("\n\nNovo nome : ");
        String novoNome = scanner.nextLine();

        double novaNota1 = lerDouble( "Nova nota N1 : " );
        double novaNota2 = lerDouble( "Nova nota N2 : " );

        aluno.setNome( novoNome );
        aluno.setNotaN1( novaNota1 );
        aluno.setNotaN2( novaNota2 );

        System.out.println( "Dados alterados com sucesso" );
    }

    public static void removerAlunoPorMatricula() {

        System.out.println( "\n--- Remocao por matricula ---" );

        int matricula = lerInteiro( "Digite a matricula do aluno : " );

        Aluno aluno = localizarAlunoPorMatricula( matricula );

        if ( aluno != null ) {

            listaAlunos.remove( aluno );
            System.out.println( "Aluno removido com sucesso" );

        } else {

            System.out.println( "*** ATENCAO: Aluno nao encontrado" );
        }
    }

    public static void mostrarQuantidadeAlunos() {

        System.out.println( "\nQuantidade de alunos : " + listaAlunos.size() );

    }

    public static void exibirMediaGeralTurma() {

        System.out.println( "\n--- Media geral da turma ---" );

        if ( listaAlunos.isEmpty() ) {
            System.out.println( "*** ATENCAO: Nao ha alunos cadastrados" );
            return;
        }

        double soma = 0;

        for ( Aluno aluno : listaAlunos ) {
            soma += aluno.calcularMedia();
        }

        double mediaGeral = soma / listaAlunos.size();

        System.out.println( "Media geral : " + String.format("%.1f", mediaGeral) );
    }

    public static void ordenarPorNome() {

        Collections.sort( listaAlunos, new Comparator<Aluno>() {

            public int compare( Aluno a1, Aluno a2 ) {
                return a1.getNome().compareToIgnoreCase( a2.getNome() );
            }

        });

        System.out.println( "Lista ordenada por nome" );
    }

    public static void ordenarPorMediaDecrescente() {

        Collections.sort(listaAlunos, new Comparator<Aluno>() {

            public int compare( Aluno a1 , Aluno a2 ) {
                return Double.compare( a2.calcularMedia() , a1.calcularMedia() );
            }

        });

        System.out.println("Lista ordenada por media");
    }

    public static void listarAprovados() {

        System.out.println("\n--- Alunos aprovados ---");

        boolean encontrou = false;

        for ( Aluno aluno : listaAlunos ) {

            if ( aluno.calcularMedia() >= 7.0 ) {

                aluno.mostrarDados();
                System.out.println("-------------------");

                encontrou = true;

            }
        }

        if ( !encontrou ) {
            System.out.println( "Nenhum aluno aprovado" );
        }
    }

    public static void removerPrimeiroAluno() {

        if ( listaAlunos.isEmpty() ) {

            System.out.println( "*** ATENCAO: Lista vazia" );
            return;
        }

        Aluno removido = listaAlunos.removeFirst();

        System.out.println( "Aluno removido : " );
        removido.mostrarDados();
    }

    public static void removerUltimoAluno() {

        if ( listaAlunos.isEmpty() ) {

            System.out.println( "*** ATENCAO: Lista vazia" );
            return;
        }

        Aluno removido = listaAlunos.removeLast();

        System.out.println( "Aluno removido : " );
        removido.mostrarDados();
    }

    public static Aluno localizarAlunoPorMatricula( int matricula ) {

        for ( Aluno aluno : listaAlunos ) {

            if ( aluno.getMatricula() == matricula ) {
                return aluno;
            }
        }

        return null;
    }

    public static boolean matriculaJaExiste( int matricula ) {

        return localizarAlunoPorMatricula( matricula ) != null;

    }

    public static int lerInteiro( String mensagem ) {

        while ( true ) {

            try {

                System.out.print( mensagem );
                return Integer.parseInt( scanner.nextLine() );

            } catch ( Exception e ) {

                System.out.println( "*** ATENCAO: Digite um numero inteiro valido" );
            }
        }
    }

    public static double lerDouble( String mensagem ) {

        while (true) {

            try {

                System.out.print( mensagem );
                return Double.parseDouble( scanner.nextLine().replace( "," , "." ) );

            } catch ( Exception e ) {

                System.out.println( "*** ATENCAO: Digite um numero decimal valido" );
            }
        }
    }
}