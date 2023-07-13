package project;
/**
 * Clase que implementa un arbol binario de Huffman
 * @Author:
 * Juan David Ramírez Grismaldo 202067654
 * Jenifer Castaño Ledesma 2067525
 * Santiago García Gil 2060017
 * Mónica Andrea Cifuentes Salcedo 2067536
 * @Version: <1>
 */


public class Nodo//se crea la clase nodo
{
    public int frecuencia;//
    public char caracter;//se crea el caracter

    public Nodo(int frecuencia, char caracter)//se crea el nodo
    {
        this.frecuencia = frecuencia;//se crea la frecuencia
        this.caracter = caracter;//se crea el caracter
    }

    public int getFrecuencia()
    {
        return this.frecuencia;
    }//se crea la frecuencia

    public void setFrecuencia(int frecuencia)
    {
        this.frecuencia = frecuencia;
    }//se crea la frecuencia

    public char getCaracter()
    {
        return this.caracter;
    }// se crea el caracter

    public void setCaracter(char caracter)
    {
        this.caracter = caracter;
    }// se crea el caracter
}
