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
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;

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


}

public class Laberinto {


    public static void main(String[] args) {

        if (args.length == 1) {
            char[][] mapa = cargaLaberinto(args[0]);
            Grafo laberinto = creaGrafo(mapa);
            for (int i = 0; i < mapa.length; i++) {
                for (int j = 0; j < mapa.length; j++) {
                    System.out.print(mapa[i][j]);
                }
                System.out.println();
            }
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
        int ancho = matriz.length;
        int largo = matriz[0].length;
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
    public static String obtenerEntrada(char[][] matriz){
        String entrada = "";

        return entrada;
    }
    public static String obtenerSalida(char[][] matriz){
        String salida = "";
        
        return salida;
    }

}


