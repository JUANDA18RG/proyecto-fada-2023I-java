/**
 * Clase de decodificacion de Huffman
 * Esta clase se encarga de decodificar un texto en base a un arbol de huffman
 * @Author: <Estudiantes>
 * @Version: <1>
 */
package project;

public class HuffmanDecoding {
/**
 * @Author:
 * Juan David Ramírez Grismaldo 202067654
 * Jenifer Castaño Ledesma 2067525
 * Santiago García Gil 2060017
 * Mónica Andrea Cifuentes Salcedo 2067536
 * @Version: <1>
 */



  /**
   * Decodifica un texto en base a un arbol de huffman.
   *
   * @param text texto a decodificar
   * @param tree arbol de huffman
   * @return texto decodificado
   */

  String resultado = "";//se crea el string resultado
  char[] arreglo;//se crea el arreglo

  public String decode(String text, HuffmanBinaryTree tree) {//se crea el metodo decode
    arreglo = new char[text.length()];//se crea el arreglo
    for (int i = 0; i < text.length(); i++) {//se crea el for
      arreglo[i] = text.charAt(i);//se crea el arreglo
    }
    return auxiliarDecode(tree, arreglo);//se retorna el auxiliar decode
  }

  public String auxiliarDecode(HuffmanBinaryTree arbol, char[] arreglo) {//se crea el metodo auxiliar decode
    HuffmanBinaryTree arbolPivote = arbol;//se crea el arbol pivote
    StringBuilder resultado = new StringBuilder();//se crea el stringbuilder

    for (int cnt = 0; cnt < arreglo.length; cnt++) {//se crea el for
      int num = arreglo[cnt];//se crea el int num
      if (num == '0') {//se crea el if
        arbolPivote = arbolPivote.getLeft();//se crea el arbol pivote
      } else if (num == '1') {//se crea el else if
        arbolPivote = arbolPivote.getRight();//se crea el arbol pivote
      }

      if (arbolPivote.getLeft() == null && arbolPivote.getRight() == null) {//se crea el if
        resultado.append(arbolPivote.keyC());//se crea el append
        arbolPivote = arbol; // Reiniciar el árbol pivote para decodificar el siguiente carácter
      }
    }

    return resultado.toString();//se retorna el resultado
  }



}