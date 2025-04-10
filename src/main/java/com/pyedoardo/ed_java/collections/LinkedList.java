/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pyedoardo.ed_java.collections;

/**
 *
 * @author Edoardo Tombolesi
 * Implementação genérica de uma lista encadeada, semelhante à LinkedList
 * Os nomes em inglês é para dar a sensação de estar usando uma lista nativa do java.
 * @param <T> Tipo dos elementos armazenados na lista.
 * A Classe nó irá ser a base da lista encadeada.
 * Essa é uma implementação de lista circular, teoricamente poderia fazer sem usar o último.
 * porém dessa forma fica mais simples.
 */
public class LinkedList<T> extends List<T> {
    
    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;
        
        Node(T value){
            this.value = value;
        }
    }
    
    private Node<T> head;
    private Node<T> tail;
    
    public LinkedList(){
        this.head = null;
        this.tail = null;
        this.actualSize = 0;
    }
}
