package algorithms.problems.AlgorithmDesignAndAnalysis.kosaraju;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class Kosaraju {
static     Stack<Integer> stack = new Stack<Integer>();
    static String archivoGrafo = "kosaraju.txt";
    static int numVertices = 875714;
    static ArrayList<ArrayList<Integer>> G = new ArrayList<ArrayList<Integer>>();
    static ArrayList<ArrayList<Integer>> GInv = new ArrayList<ArrayList<Integer>>();
    static int[] explorados = new int[numVertices + 1];
    static int[] tiempos = new int[numVertices + 1];
    static int t = 0;
    static int cutntosPorGrupo = 0;
    //static ArrayList<ArrayList<Integer>> GTrad = new ArrayList<ArrayList<Integer>>();


    //static int [][] G = new int [9][];

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

		/*
         * Los pasos son:
		 * - Crear el arreglo: es un arreglo de arreglos.
		 * - Crear el arreglo invertido.
		 * - Ejecutar DFSLoop para computar el reordenamiento mtgico. Retornar un arreglo pa' c/ posici—n su nuevo valor.
		 * - Ejecutar DFSLoop con el arreglo anterior pa' traducir. 
		 * 
		 */

        //inicializarG ();

        System.out.println(java.lang.Runtime.getRuntime().maxMemory());

        inicializarGYGInv(archivoGrafo);

        System.out.println("G tiene " + G.size());
        System.out.println("GInv tiene " + GInv.size());


        //Aux.imprimirListaDeListasDeIntegers ( G );

        //invertirG ();

        //Aux.imprimirListaDeListasDeIntegers ( GInv );

        DFSLoop1();

        System.out.println("Sert un milagro...");

        //Aux.imprimirPosici—nYValorDeArreglo (tiempos);

        explorados = new int[numVertices + 1];

        //traducirGrafo ( );

        System.out.println("********");
        DFSLoop2();
		
		/* 
		for ( ArrayList<Integer> g:G ){
			for ( Integer q: g ){
				System.out.print ( q + " ");
			}
			System.out.println ("");
		}
		*/

    }

    /**
     * Traduce del grafo viejo al nuevo con la lista ordenada.
     */
    static void traducirGrafo() {

    }

    /**
     * Act usamos la lista inteligente de DFSLoop1 para hallar los componentes.
     */
    static void DFSLoop2() {
        for (int i = numVertices; i >= 1; i--) {

            int valorDelVertice = tiempos[i];
            cutntosPorGrupo = 0;
            if (explorados[valorDelVertice] == 0) {
                DFS(valorDelVertice);
                System.out.println("--> " + cutntosPorGrupo);
            }
        }
    }

    /**
     * DFS recibe la posici—n en la lista inteligente.
     *
     * @param s
     */
    static void DFS(int s) {
        stack.push(s);
        int i = 0;
        int element = s;
        explorados[s] = 1;
        cutntosPorGrupo++;
        while (!stack.isEmpty()) {
            element = stack.peek();
            for (Integer j : GInv.get(element)) {
                if (explorados[j] == 0) {
                    stack.push(j);
                    explorados[j] = 1;
                }
            }
            stack.pop();
            t++;
            tiempos [ t ] = s;
        }
    }


    /**
     * Este metodo ejecuta DFSLoop y retorna la "lista inteligente" que usaremos en DFSLoop2
     */
    static void DFSLoop1() {
        for (int i = numVertices; i >= 1; i--) {
            if (explorados[i] == 0) {
                //System.out.println ( "Bueee... Vamos por " + i );

                if (i == 874931) {
                    System.out.println("ÁPare!");
                }


                DFSInv(i);
            }
        }
    }

    static void DFSInv(int s) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(s);
        int i = 0;
        int element = s;
        cutntosPorGrupo++;
        explorados[s] = 1;
        while (!stack.isEmpty()) {
            element = stack.peek();
            for (Integer j : GInv.get(element)) {
                if (explorados[j] == 0) {
                    stack.push(j);
                    explorados[j] = 1;
                }
            }
            stack.pop();
        }
    }


    /**
     * La fea pero necesaria tarea de leer el archivo.
     *
     * @param archivo
     * @throws IOException
     */
    static void inicializarGYGInv(String archivo) throws IOException {

        for (int i = 0; i < numVertices + 1; i++) {
            ArrayList<Integer> g = new ArrayList<Integer>();
            G.add(g);
            g = new ArrayList<Integer>();
            GInv.add(g);
        }

        //Abrir el archivo
        BufferedReader reader = new BufferedReader(new FileReader(archivo));
        String line = null;

        int origen = 0, destino = 0;
        int cutntos = 0;
        while ((line = reader.readLine()) != null) {
            //Separar las l’neas
            String[] parts = line.split(" ");
            origen = Integer.parseInt(parts[0]);
            destino = Integer.parseInt(parts[1]);

            cutntos++;
            //if (cutntos%100000 == 0){ System.out.println ("Wepa" + cutntos);}
            G.get(origen).add(destino);
            GInv.get(destino).add(origen);
        }
    }

    /**
     *
     */
    static void inicializarG() {

        ArrayList<Integer> g = new ArrayList<Integer>();
        G.add(g);

        G.add(g);

        g = new ArrayList<Integer>();
        g.add(1);
        g.add(3);
        G.add(g);

        g = new ArrayList<Integer>();
        g.add(4);
        G.add(g);

        g = new ArrayList<Integer>();
        g.add(2);
        g.add(5);
        G.add(g);

        g = new ArrayList<Integer>();
        g.add(6);
        g.add(7);
        G.add(g);

        g = new ArrayList<Integer>();
        g.add(7);
        G.add(g);

        g = new ArrayList<Integer>();
        g.add(8);
        G.add(g);

        g = new ArrayList<Integer>();
        g.add(5);
        G.add(g);

    }

    static void invertirG() {
        GInv.clear();

        //ArrayList<Integer> g = new ArrayList<Integer>();

        for (int i = 0; i < G.size(); i++) {
            ArrayList<Integer> g = new ArrayList<Integer>();
            GInv.add(g);
        }

        int i = 0;
        for (ArrayList<Integer> g : G) {
            for (Integer q : g) {
                GInv.get(q).add(i);
            }
            i++;

            if (i % 100000 == 0) System.out.println(i);
        }


    }


    ArrayList<Integer> arrayToList(int[] array) {
        ArrayList<Integer> newOne = new ArrayList<Integer>();
        ;
        for (int i = 0; i < array.length; i++) {
            newOne.add(i);
        }
        return newOne;
    }


}