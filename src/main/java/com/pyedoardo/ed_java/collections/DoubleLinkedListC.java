package com.pyedoardo.ed_java.collections;

import org.jetbrains.annotations.NotNull;

public class DoubleLinkedListC<T> extends LinkedList<T> {

    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        Node(){
            this.next = null;
            this.prev = null;
            this.value = null;
        }

        Node(T value){
            this.value = value;
            next = null;
            prev = null;
        }

        Node(T value, Node<T> prev, Node<T> next){
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node<T> head;
    private Node<T> tail;

    public DoubleLinkedListC(){
        this.head = null;
        this.tail = null;
        this.actualSize = 0;
    }

    @Override
    public void append(T value){
        if (actualSize == 0){
            head = tail = new Node<>(value, tail, head);
        }
        else {
            head.prev = head = new Node<>(value, tail, head);
            tail.next = head;
        }
        actualSize++;
    }

    @Override
    public void append(@NotNull T... values){
        for (T value : values){
            append(value);
        }
    }

    public void remove(){
        if (actualSize == 0){
            return;
        }
        else if (actualSize == 1){
            head = tail = null;
        }
        else {
            tail.prev.next = head;
            tail.next = head;
            head.prev = tail;
        }
        actualSize--;
    }

    @Override
    public void show(){
        Node<T> aux = head;
        for (int i = 0; i < actualSize; i++){
            System.out.println(aux.value);
            aux = aux.next;
            if (i == actualSize-1){
                break;
            }
        }
    }

    @Override
    public void reverseShow(){
        Node<T> aux = head;
        for (int i = 0; i < actualSize; i++){
            System.out.println(aux.prev.value);
            aux = aux.prev;
            if (i == actualSize-1){
                break;
            }
        }
    }

    /**
     * Método sobrescrito e inacessível pois a lista ligada não precisa de um método que aumente o tamanho dela.
     * @throws UnsupportedOperationException por conta do sistema de nós, então o método retorna apenas uma excessão e não faz nada.
     */
    @Override
    protected void ensureCapacity(){
        throw new UnsupportedOperationException("Método não suportado");
    }
}
