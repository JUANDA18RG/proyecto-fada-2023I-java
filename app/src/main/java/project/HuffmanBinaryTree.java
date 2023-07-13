/**
 * Clase que implementa un arbol binario de Huffman
 * @Author:
 * Juan David Ramírez Grismaldo 202067654
 * Jenifer Castaño Ledesma 2067525
 * Santiago García Gil 2060017
 * Mónica Andrea Cifuentes Salcedo 2067536
 * @Version: <1>
*/

package project;

public class HuffmanBinaryTree {
  private Nodo key;//llave del arbol
  private HuffmanBinaryTree left;//hijo izquierdo del arbol
  private HuffmanBinaryTree right;//hijo derecho del arbol

  /**
   * Retorna el valor de la llave, si es un string retorna -1, si es un numero retorna el numero.
   * @return valor de la llave
   */

  public HuffmanBinaryTree(Nodo key, HuffmanBinaryTree left,HuffmanBinaryTree right)
  {
    this.key = key;//llave del arbol
    this.left = left;//hijo izquierdo del arbol
    this.right= right;//hijo derecho del arbol
  }

  public int keyF()//retorna la frecuencia de la llave
  {
    return this.key.getFrecuencia();
  }


  public char keyC()//retorna el caracter de la llave
  {
    return this.key.getCaracter();
  }


  public int getNumberKey()//retorna el valor de la llave, si es un string retorna -1, si es un numero retorna el numero.
  {
    char caracter = this.key.getCaracter();
    if (Character.isDigit(caracter))//si es un numero
    {
      return Character.getNumericValue(caracter);//retorna el numero
    }
    else
    {
      return -1;//si es un string retorna -1
    }
  }

  /**
   * Retorna el hijo izquierdo del arbol.
   * @return hijo izquierdo del arbol
   */
  public HuffmanBinaryTree getLeft()//retorna el hijo izquierdo del arbol
  {
    if(this.left != null)
    {
      return this.left;
    }
    else
    {
      return null;
    }
  }


  /**
   * Retorna el hijo derecho del arbol.
   * @return hijo derecho del arbol
   */
  public HuffmanBinaryTree getRight()//retorna el hijo derecho del arbol
  {
    if(this.right != null)
    {
      return this.right;
    }
    else
    {
      return null;
    }
  }

}
