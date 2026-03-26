import java.util.Stack;

import java.util.Queue;
import java.util.LinkedList;

public class PilhaFilaStackQueue{
    public static void main( String args[] ){

        //=========================================================

        Stack< String > pilha = new Stack<>();

        pilha.push( "Evandro" );
        pilha.push( "Viapas" );
        pilha.push( "Evan" );

        System.out.println("\nTopo : " + pilha.peek() );

        pilha.pop();

        System.out.println("\nTopo : " + pilha.peek() );

        System.out.println( "\n" + pilha + "\n" );

        //=========================================================

        Queue< String > fila  = new LinkedList<>();
        
        fila.add( "Volks" );
        fila.add( "Porsche" );
        fila.add( "Audi" );

        System.out.println("\nFrente : " + fila.peek() );

        fila.remove();

        System.out.println("\nFrente : " + fila.peek() );

        System.out.println( "\n" + fila + "\n" );

    }
}