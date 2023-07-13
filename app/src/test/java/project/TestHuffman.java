/**
 * Pruebas unitarias para el algoritmo de Huffman.
 * @Authores:
 * Juan David Ramírez Grismaldo 202067654
 * Jenifer Castaño Ledesma 2067525
 * Santiago García Gil 2060017
 * Mónica Andrea Cifuentes Salcedo 2067536
 * @Version: 1
 * @Date: 03/JUL/2023
 */
package project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;


import org.junit.jupiter.api.Test;


public class TestHuffman {

  private ClassLoader classLoader = getClass().getClassLoader();

  /**
   * Verifica que el árbol de Huffman sea válido.
   *
   * @param tree árbol de Huffman
   * @return true si el árbol es válido, false de lo contrario
   */
  public boolean verifyTree(HuffmanBinaryTree tree) {
    int key = tree.getNumberKey();
    if (key != -1) {
      HuffmanBinaryTree left = tree.getLeft();
      HuffmanBinaryTree right = tree.getRight();

      if (left != null && right != null) {
        boolean condition = key >= left.getNumberKey() && key >= right.getNumberKey();
        return condition && verifyTree(left) && verifyTree(right);
      } else {
        if (left == null) {
          boolean condition = key >= right.getNumberKey();
          return condition && verifyTree(right);
        } else {
          if (right == null) {
            boolean condition = key >= left.getNumberKey();
            return condition && verifyTree(left);
          } else {
            return true;
          }
        }
      }
    } else {
      return true;
    }
  }





  private String loadFile(String fileName) {
    try {
      InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);//se carga el archivo
      if (inputStream != null) {//si el archivo no es nulo
        BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(inputStream, StandardCharsets.UTF_8));//se lee el archivo
        StringBuilder stringBuilder = new StringBuilder();//se crea un string builder
        String line;//se crea una variable line
        while ((line = reader.readLine()) != null) {//mientras la linea no sea nula
          stringBuilder.append(line);//se agrega la linea al string builder
          stringBuilder.append(System.lineSeparator());//se agrega un salto de linea
        }
        return stringBuilder.toString();//se retorna el string builder
      }
    } catch (IOException e) {//si hay una excepcion
      e.printStackTrace();//se imprime la excepcion
    }
    return null;//se retorna nulo
  }




  @Test
  public void testFile1() {
    //Setup
    HuffmanCoding coding = new HuffmanCoding();
    String text = loadFile("ejemplo1.in");;
    HuffmanDecoding decoding = new HuffmanDecoding();

    //Execute
    String encoded = coding.encode(text);
    HuffmanBinaryTree tree = coding.getTree();
    String decoded = decoding.decode(encoded, tree);

    //Assert
    System.out.println("Prueba 1");
    assertTrue(verifyTree(tree));
    System.out.println(encoded);
    assertEquals(text,decoded);
    System.out.println(text.equals(decoded));
  }

  @Test
  public void testFile2() {
    //Setup
    HuffmanCoding coding = new HuffmanCoding();
    String text2 = loadFile("ejemplo2.in");
    HuffmanDecoding decoding = new HuffmanDecoding();

    //Execute
    String encoded = coding.encode(text2);
    HuffmanBinaryTree tree = coding.getTree();
    String decoded = decoding.decode(encoded, tree);

    //Assert
    System.out.println("Prueba 2");
    assertTrue(verifyTree(tree));
    System.out.println(encoded);
    assertEquals(text2,decoded);
    System.out.println(text2.equals(decoded));
  }

  @Test
  public void testFile3() {
    //Setup
    HuffmanCoding coding = new HuffmanCoding();
    String text3 = loadFile("ejemplo3.in");
    HuffmanDecoding decoding = new HuffmanDecoding();

    //Execute
    String encoded = coding.encode(text3);
    HuffmanBinaryTree tree = coding.getTree();
    String decoded = decoding.decode(encoded, tree);

    //Assert
    System.out.println("Prueba 3");
    assertTrue(verifyTree(tree));
    System.out.println(encoded);
    assertEquals(text3,decoded);
    System.out.println(text3.equals(decoded));
  }

}