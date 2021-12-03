/**
 * @author_DieProgrammiere
 */

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Vertice {

    String nombre;
    Hashtable<String, Arco> arcos;
    boolean visto;

    public Vertice(String nombre) {
        this.nombre = nombre;
        this.arcos = new Hashtable<>();
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
        vertice.arcos.forEach((String, Arco) -> {
            Vertice vecino = buscarVertice(Arco.nombre_destino);
            if (vecino.visto == false) {
                q.add(vecino);
            }
        });
    }

    public void agregarVecinos(Stack<Vertice> s, Vertice vertice) {
        vertice.arcos.forEach((String, Arco) -> {
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
        limpiarVisto();
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
            for (String vertice : ruta) {
                System.out.print("(" + vertice + ") ");
                System.out.println();
            }
        } else {
            System.out.println("NO HAY un camino entre " + inicio + " y " + destino);
        }
        return ruta;
    }

    public Queue<String> BreadthFirstSearch(String inicio, String destino) {
        limpiarVisto();
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
        } while (cola.isEmpty() == false && ENCONTRADO == false);
        System.out.println("BREADTH FIRST SEARCH");
        if (ENCONTRADO == true) {
            System.out.println("Existe un camino entre " + inicio + " y " + destino);
            for (String vertice : ruta) {
                System.out.print("(" + vertice + ") ");
                System.out.println();
            }
        } else {
            System.out.println("NO HAY un camino entre " + inicio + " y " + destino);
        }
        return ruta;

    }

    public char[][] llenarMapa(Queue<String> ruta, char[][] matriz) {
        char[][] matrizAux = copiarMatriz(matriz);
        for (String nombre : ruta) {
            String[] arreglo_aux = nombre.split(",");
            int i = Integer.parseInt(arreglo_aux[0]);
            int j = Integer.parseInt(arreglo_aux[1]);
            matrizAux[i][j] = '#';
        }
        return matrizAux;
    }

    public char[][] copiarMatriz(char[][] matriz) {
        char[][] matrizAux = new char[matriz.length][matriz[0].length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matrizAux[i][j] = matriz[i][j];
            }
        }
        return matrizAux;
    }

    public String generaGrafo_ruta(Queue<String> ruta, boolean esDFS) {
        HashSet<String> impresos = new HashSet<>();
        String cadena = "";
        if (esDFS) {
            cadena = "subgraph DFS {\nedge[color= \"blue\"]\n";
        } else {
            cadena = "subgraph BFS {\nedge[color= \"red\"]\n";
        }
        for (String nombre_vertice : ruta) {
            Vertice verticito = this.vertices.get(nombre_vertice);
            Enumeration<String> enumeration = verticito.arcos.keys();
            if (!verticito.arcos.isEmpty()) {
                impresos.add(nombre_vertice);
            }
            while (enumeration.hasMoreElements()) {
                Arco arquito = verticito.arcos.get(enumeration.nextElement());
                if (ruta.contains(arquito.nombre_destino) && !(impresos.contains(arquito.nombre_destino))) {
                    cadena += "\"" + nombre_vertice + "\"" + " -> " + "\"" + arquito.nombre_destino + "\"" + " [label= \"" + 1 + "\"]\n";
                    impresos.add(arquito.nombre_destino);

                }
            }
        }
        cadena += "}";
        return cadena;

    }

    public String generaGrafo(String BFS, String DFS) {
        String cadena = "digraph G{\n";
        Enumeration<String> enumeration = this.vertices.keys();
        while (enumeration.hasMoreElements()) {
            String vertice_nombre = enumeration.nextElement();
            Vertice vertice = this.vertices.get(vertice_nombre);
            Enumeration<String> enumeration1 = vertice.arcos.keys();
            while (enumeration1.hasMoreElements()) {
                String arco_nombre = enumeration1.nextElement();
                Arco arco = vertice.arcos.get(arco_nombre);
                cadena = cadena + "\"" + vertice.nombre + "\"";
                cadena += " -> " + "\"" + arco.nombre_destino + "\"";
                cadena += " [label = \"" + 1 + "\"];";
                cadena += "\n";
            }
        }
        cadena += BFS;
        cadena += DFS;
        cadena += "}";
        return cadena;
    }

}

public class Laberinto {
    public static int ancho;
    public static int largo;

    public static void main(String[] args) {
        formPrincipal ventana = new formPrincipal();
        ventana.setVisible(true);
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
            JOptionPane.showMessageDialog(null, "Ocurrió un error al tratar de procesar el archivo,"
                    + " verifique que el archivo exista", "Error", 0);
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
                    if (i == 0 || j == 0) {
                        if (matriz[i][j] == ' ') {

                        }
                    }
                    grafo.vertices.put(nombre_vertice, vertice);
                }
            }
        }
        return grafo;
    }

    public static Queue<String> EncontrarEntradaSalida(char[][] matriz) {
        Queue<String> auxCola = new LinkedList<>();
        boolean entradaEncontrada = false;
        boolean salidaEncontrada = false;
        ancho = matriz.length;
        largo = matriz[0].length;
        String entrada = "";

        if (matriz.length != 0) {
            for (int j = 0; j < largo; j++) {
                if (matriz[0][j] == ' ' && !entradaEncontrada) {
                    entrada = (0 + "," + j);
                    auxCola.add(entrada);
                    entradaEncontrada = true;
                }

                if (matriz[ancho - 1][j] == ' ' && !salidaEncontrada) {
                    entrada = ((ancho - 1) + "," + j);
                    auxCola.add(entrada);
                    salidaEncontrada = true;
                }
            }

            for (int i = 0; i < ancho; i++) {
                if (matriz[i][0] == ' ' && !entradaEncontrada) {
                    entrada = (i + "," + 0);
                    auxCola.add(entrada);
                    entradaEncontrada = true;
                }
                if (matriz[i][largo - 1] == ' ' && !salidaEncontrada) {
                    entrada = (i + "," + (largo - 1));
                    auxCola.add(entrada);
                    salidaEncontrada = true;
                }
            }
        }
        return auxCola;
    }

    public static void mostrarMapa(char[][] mapa, JTextArea areaTexto) {
        ancho = mapa.length;
        largo = mapa[0].length;
        String cadenita = "";
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < largo; j++) {
                cadenita += mapa[i][j];
            }
            cadenita += "\n";
        }
        areaTexto.setText(cadenita);
    }
}
