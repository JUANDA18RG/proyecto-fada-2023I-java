/**
 * Clase huffmanCoding
 * Esta clase se encarga de codificar un texto en base a un arbol de huffman
 * @Author: <Estudiantes>
 * @Version: <1>
 */
package project;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * @Author:
 * Juan David Ramírez Grismaldo 202067654
 * Jenifer Castaño Ledesma 2067525
 * Santiago García Gil 2060017
 * Mónica Andrea Cifuentes Salcedo 2067536
 * @Version: <1>
 */

public class HuffmanCoding
{
  /**
   * Constructor de la clase HuffmanCoding.
   * @param text texto a codificar
   * @return texto codificado
   */

  HuffmanBinaryTree arbol;//se crea el arbol
  String mensaje;//se crea el mensaje
  HashMap<Character, Integer> listaFrecuencias = new HashMap<>();//se crea el hashmap
  HashMap<String, String> Tabla = new HashMap<>();//se crea el hashmap

  public String encode(String text)//se crea el metodo encode
  {
    mensaje = text;//se crea el mensaje
    for (int i = 0; i < text.length(); i++)//se crea el for
    {
      char letra = text.charAt(i);//se crea la letra
      if (listaFrecuencias.containsKey(letra))//se crea el if
      {
        listaFrecuencias.put(letra, listaFrecuencias.get(letra) + 1);//se crea el put
      } else//se crea el else
      {
        listaFrecuencias.put(letra, 1);//se crea el put
      }
    }

    Object[] keys = listaFrecuencias.keySet().toArray();//se crea el object
    List<HuffmanBinaryTree> hojas = new ArrayList<>(listaFrecuencias.size());//se crea el arraylist

    for (int i = 0; i < listaFrecuencias.size(); i++)// se crea el for
    {
      Nodo nodoHoja = new Nodo(listaFrecuencias.get(keys[i]), (Character) keys[i]);//se crea el nodo hoja
      HuffmanBinaryTree obj = new HuffmanBinaryTree(nodoHoja, null, null);//se crea el objeto
      hojas.add(obj);//se crea el add
    }

    arbol = crearArbol(hojas, text);//se crea el arbol
    generarTablaCodigos(arbol, "");//se crea la tabla de codigos

    return ordenarCadena(text);//se retorna la cadena ordenada
  }

  public HuffmanBinaryTree crearArbol(List<HuffmanBinaryTree> hojas, String codigo)//se crea el arbol
  {
    while (hojas.size() > 1)//se crea el while
    {
      hojas.sort(Comparator.comparing(HuffmanBinaryTree::keyF).thenComparing(HuffmanBinaryTree::keyC));//se crea el sort

      Nodo nuevoNodo = new Nodo((hojas.get(0).keyF() + hojas.get(1).keyF()),'\u0000');//se crea el nodo
      HuffmanBinaryTree nuevoArbol = new HuffmanBinaryTree(nuevoNodo, hojas.get(1), hojas.get(0));//se crea el arbol

      hojas.remove(0);//se remueve
      hojas.remove(0);//se remueve
      hojas.add(nuevoArbol);//se agrega
    }

    return hojas.get(0);//se retorna
  }

  private void generarTablaCodigos(HuffmanBinaryTree arbol, String codigo)//se crea la tabla de codigos
  {
    if (arbol.getLeft() != null)//se crea el if
    {
      generarTablaCodigos(arbol.getLeft(), codigo + "0");//se crea la tabla de codigos
    }
    if (arbol.getRight() != null)//se crea el if
    {
      generarTablaCodigos(arbol.getRight(), codigo + "1");//
    }
    if (arbol.getLeft() == null && arbol.getRight() == null)//se crea el if
    {
      Tabla.put( String.valueOf(arbol.keyC()), codigo);//se crea el put
    }

  }


  public String ordenarCadena(String cadena)//se crea el metodo ordenar cadena
  {
    String cadenaOrdenada = "";//se crea la cadena ordenada
    for (int i = 0; i < cadena.length(); i++)//se crea el for
    {
      cadenaOrdenada += Tabla.get(String.valueOf(cadena.charAt(i)));//se crea la cadena ordenada
    }
    return cadenaOrdenada;//se retorna la cadena ordenada
  }



  /**
   * Retorna el arbol de huffman.
   * @return arbol de huffman
   */
  public HuffmanBinaryTree getTree()
  {
    return arbol;
  }//se retorna el arbol

  /**
   * Retorna la tabla de codificacion.
   * @return tabla de codificacion
   */
  public HashMap<String,String> getTable()
  {
    return Tabla;
  }//se retorna la tabla
  
  /**
   * Retorna el resumen de la codificacion
   * @return resumen de la codificacion en formato string
   */

  //este metodo calcula la altura del arbol de huffman
  public int alturaArbol(HuffmanBinaryTree arbol)//se crea el metodo altura arbol
  {
    if (arbol == null)//se crea el if
    {
      return 0;//se retorna 0
    }
    else
    {
      int alturaIzquierda = alturaArbol(arbol.getLeft());//se crea la altura izquierda
      int alturaDerecha = alturaArbol(arbol.getRight());//se crea la altura derecha
      if (alturaIzquierda > alturaDerecha)//se crea el if
      {
        return alturaIzquierda + 1;//se retorna la altura izquierda
      }
      else
      {
        return alturaDerecha + 1;//se retorna la altura derecha
      }
    }
  }


  //este metodo calacula el numero de nodos del arbol de huffman
  public int numeroNodos(HuffmanBinaryTree arbol)//se crea el metodo numero nodos
  {
    if (arbol == null)//se crea el if
    {
      return 0;//se retorna 0
    }
    else
    {
      return 1 + numeroNodos(arbol.getLeft()) + numeroNodos(arbol.getRight());//se retorna el numero de nodos
    }
  }


  //este metodo hace el porcentaje de compresion de la cadena
  public double porcentajeCompresion(String cadena)//se crea el metodo porcentaje compresion
  {
    double porcentaje = 0;//se crea el porcentaje
    double bits = 0;//se crea el bits
    double bits2 = 0;//se crea el bits2
    for (int i = 0; i <= cadena.length(); i++)//
    {
      bits += 256;//se crea el bits
    }
    for (int i = 0; i < cadena.length(); i++)//se crea el for
    {
      bits2 += Tabla.get(cadena.charAt(i)).length();//se crea el bits2
    }
    porcentaje = 1-(bits2 / bits);//se crea el porcentaje
    return porcentaje;//se retorna el porcentaje
  }

  public HashMap<String, String> getSummary()//se crea el metodo get summary
  {
    HashMap<String, String> summary = new HashMap<>();//se crea el summary
    summary.put("Porcentaje de compresion", String.valueOf(porcentajeCompresion(this.mensaje)));//se crea el put
    summary.put("Numero de nodos", String.valueOf(numeroNodos(this.arbol)));//se crea el put
    summary.put("Profundidad del arbol", String.valueOf(alturaArbol(this.arbol)));//se crea el put
    return summary;//se retorna el summary
  }

}
