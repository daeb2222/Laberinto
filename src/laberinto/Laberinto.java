/***
 *El programa principal de JAVA deberá contar con un encabezado con nombre del programa,
 *un ejemplo de cómo puede utilizarse el programa en la línea de comando, nombre de los integrantes del equipo,
 *  fecha (1 punto).
 */
package laberinto;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Vertice {
    String nombre;
    Hashtable<String, Arco> arcos;
    boolean flag;
    boolean visto;

    public Vertice(String nombre) {
        this.nombre = nombre;
        this.arcos = new Hashtable<>();
        this.flag = false;
        this.visto = false;
    }

    public void agregarArco(int i, int j) {
        String nombre_destino = (i + "," + j);
        Arco arco = new Arco(nombre_destino);
        this.arcos.put(nombre_destino, arco);
    }
}

class Arco {
    String nombre_destino;

    public Arco(String nombre_destino) {
        this.nombre_destino = nombre_destino;
    }


}

class Grafo {
    Hashtable<String, Vertice> vertices;

    public Grafo() {
        this.vertices = new Hashtable<>();
    }

    public Vertice buscarVertice(String nombre_vertice) {
        if (this.vertices.get(nombre_vertice) != null) {
            return this.vertices.get(nombre_vertice);
        }
        return null;
    }

    public void agregarVecinosQ(Queue<Vertice> q, Vertice vertice) {
        vertice.arcos.forEach((String, Arco)->{
            Vertice vecino = buscarVertice(Arco.nombre_destino);
            if(vecino.visto == false){
                q.add(vecino);
            }
        });
    }

    public void agregarVecinos(Stack<Vertice> s, Vertice vertice) {
        vertice.arcos.forEach((String, Arco)->{
            Vertice vecino = buscarVertice(Arco.nombre_destino);
            if (vecino.visto == false) {
                s.push(vecino);
            }
        });
    }

    public void limpiarVisto() {
        vertices.forEach((String, Vertice) -> {
            Vertice.visto = false;
        });
    }

    public Queue<String> DepthFirstSearch(String inicio, String destino) {
        limpiarVisto(); //Ponemos en false los campos "visto" de vertices
        Queue<String> ruta = new LinkedList<>();
        boolean ENCONTRADO = false;
        Stack<Vertice> pila = new Stack<>();
        Vertice v = buscarVertice(inicio);
        pila.push(v);
        do {
            v = pila.pop();
            if (v.nombre.equals(destino)) {
                ENCONTRADO = true;
            } else {
                v.visto = true;
                agregarVecinos(pila, v);
            }
            ruta.add(v.nombre);

        } while (pila.isEmpty() == false && ENCONTRADO == false);
        System.out.println("DEPTH FIRST SEARCH");
        if (ENCONTRADO == true) {
            System.out.println("Existe un camino entre " + inicio + " y " + destino);
            for (String vertice:ruta) {
                System.out.print("("+vertice + ") " );
                System.out.println();
            }
        } else {
            System.out.println("NO HAY un camino entre " + inicio + " y " + destino);
        }
        return ruta;
    }

    public Queue<String> BreadthFirstSearch(String inicio, String destino) {
        limpiarVisto(); //Ponemos en false los campos "visto" de vertices
        Queue<String> ruta = new LinkedList<>();
        boolean ENCONTRADO = false;
        Queue<Vertice> cola = new LinkedList<>();
        Vertice v = buscarVertice(inicio);
        cola.add(v);
        do {
            v = cola.remove();
            if (v.nombre.equals(destino)) {
                ENCONTRADO = true;
            } else {
                v.visto = true;
                agregarVecinosQ(cola, v);
            }
            ruta.add(v.nombre);
            //despliegaStack(pila);
        } while (cola.isEmpty() == false && ENCONTRADO == false);
        System.out.println("BREADTH FIRST SEARCH");
        if (ENCONTRADO == true) {
            System.out.println("Existe un camino entre " + inicio + " y " + destino);
            for (String vertice:ruta) {
                System.out.print("("+vertice + ") " );
                System.out.println();
            }
        } else {
            System.out.println("NO HAY un camino entre " + inicio + " y " + destino);
        }
        return ruta;

    }

    public void llenarMapa(Queue<String> ruta, char[][] matriz) {
        for (String nombre: ruta) {
            String[] arreglo_aux = nombre.split(",");
            int i = Integer.parseInt(arreglo_aux[0]);
            int j = Integer.parseInt(arreglo_aux[1]);
            matriz[i][j] = '#';
        }
    }



}

public class Laberinto {
//probando un push jajaja
    public static int ancho;
    public static int largo;

    public static void main(String[] args) {

        if (args.length == 1) {
            char[][] mapa = cargaLaberinto(args[0]);
            Queue<String> cola = EncontrarEntradaSalida(mapa);
            Queue<String> ruta;
            Grafo laberinto = creaGrafo(mapa);
            String entrada = cola.remove();
            String salida = cola.remove();
            System.out.println("-------Mapa sin resolver-------");
            mostrarMapa(mapa);
            System.out.println("Introduzca 1 para resolver con DFS, cualquier otra cosa para resolver con BFS");
            Scanner scanner = new Scanner(System.in);
            String metodo = scanner.nextLine();
            if (metodo.equalsIgnoreCase("1")) {
                ruta = laberinto.DepthFirstSearch(entrada,salida);
            } else {
                ruta = laberinto.BreadthFirstSearch(entrada,salida);
            }
            laberinto.llenarMapa(ruta, mapa);
            System.out.println("-------Mapa resuelto-------");
            mostrarMapa(mapa);

        } else {
            System.out.println("Ingrese una cantidad de argumentos permitidos, actualmente hay: " + args.length);
            JOptionPane.showMessageDialog(null, "Ingrese una cantidad de argumentos permitidos: " +
                    "\n Actualmente hay: " + args.length + "\n Argumentos permitidos: " + 1, "Advertencia", 2);
        }
    }
    public static char[][] cargaLaberinto(String archivo) {
        int i = 0;
        ArrayList<String> lineas = new ArrayList<>();
        try {
            File f = new File(archivo);
            f.setReadOnly();
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine = "";
            while ((readLine = b.readLine()) != null) {
                //System.out.println(readLine);
                lineas.add(readLine);
            }
            int ancho = lineas.get(0).length();
            int largo = lineas.size();
            char[][] mapa = new char[largo][ancho];
            for (String linea : lineas) {
                char[] caracteres = linea.toCharArray();
                for (int j = 0; j < caracteres.length; j++) {
                    mapa[i][j] = caracteres[j];
                }
                i++;
            }
            return mapa;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al tratar de procesar el archivo," +
                    " verifique que el archivo exista", "Error", 0);
            e.printStackTrace();
            return null;
        }
    }

    public static Grafo creaGrafo(char[][] matriz) {
        Grafo grafo = new Grafo();
        ancho = matriz.length;
        largo = matriz[0].length;
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < largo; j++) {
                if (matriz[i][j] == ' ') {
                    String nombre_vertice = (i + "," + j);
                    Vertice vertice = new Vertice(nombre_vertice);
                    if ((i + 1) < ancho) {
                        if (matriz[i + 1][j] == ' ') {
                            vertice.agregarArco((i + 1), j);
                        }
                    }
                    if ((i - 1) >= 0) {
                        if (matriz[i - 1][j] == ' ') {
                            vertice.agregarArco((i - 1), j);
                        }
                    }
                    if ((j + 1) < largo) {
                        if (matriz[i][j + 1] == ' ') {
                            vertice.agregarArco(i, (j + 1));
                        }
                    }
                    if ((j - 1) >= 0) {
                        if (matriz[i][j - 1] == ' ') {
                            vertice.agregarArco(i, (j - 1));
                        }
                    }
                    if (i==0 || j==0){
                        if (matriz[i][j] == ' '){

                        }
                    }
                    grafo.vertices.put(nombre_vertice, vertice);
                }
            }
        }
        return grafo;
    }

    public static Queue<String> EncontrarEntradaSalida(char[][] matriz){
        Queue<String> auxCola = new LinkedList<>();
        boolean entradaEncontrada = false;
        boolean salidaEncontrada = false;
        ancho = matriz.length;
        largo = matriz[0].length;
        String entrada = "";

        if(matriz.length != 0){
            for (int j = 0; j < largo; j++) {
                if(matriz[0][j] == ' ' && !entradaEncontrada){
                    entrada = (0 + "," + j);
                    auxCola.add(entrada);
                    entradaEncontrada = true;
                }

                if(matriz[ancho-1][j] == ' ' && !salidaEncontrada){
                    entrada = ((ancho-1) + "," + j);
                    auxCola.add(entrada);
                    salidaEncontrada = true;
                }
            }

            for (int i = 0; i < ancho; i++) {
                if(matriz[i][0] == ' ' && !entradaEncontrada){
                    entrada = (i + "," + 0);
                    auxCola.add(entrada);
                    entradaEncontrada = true;
                }
                if(matriz[i][largo-1] == ' ' && !salidaEncontrada){
                    entrada = (i + "," + (largo-1));
                    auxCola.add(entrada);
                    salidaEncontrada = true;
                }
            }
        }
        return auxCola;
    }
    public static void mostrarMapa(char[][] mapa){
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < largo; j++) {
                System.out.print(mapa[i][j]);
            }
            System.out.println();
        }
    }


}


