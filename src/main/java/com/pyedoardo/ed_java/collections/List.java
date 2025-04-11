/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pyedoardo.ed_java.collections;
import java.util.Iterator;
import java.util.Arrays;
import java.util.Comparator;
/**
 *
 * @author Edoardo Tombolesi
 * Implementação genérica de uma lista dinâmica, semelhante à ArrayList
 * Os nomes em inglês é para dar a sensação de estar a usar uma lista nativa do java.
 * O uso de @SuppressWarnings("unchecked") é bem necessário ao trabalhar com arrays genéricos.
 * @param <T> Tipo dos elementos armazenados na lista
 */

public class List<T> implements Iterable<T>{

    protected int maxSize;        // Capacidade máxima atual do array
    protected int actualSize;     // Quantidade real de elementos inseridos na lista
    protected Object[] values;    // Array que armazena os elementos da lista

    /**
     * Construtor com capacidade inicial definida.
     * @param maxSize capacidade inicial do array
     */
    public List(int maxSize) {
        this.maxSize = maxSize;
        this.values = new Object[maxSize];
        this.actualSize = 0;
    }

    /**
     * Construtor padrão com capacidade inicial de 10.
     */
    public List() {
        this(10);
    }

    /**
     * Exibe todos os elementos da lista em ordem direta.
     */
    public void show() {
        for (int i = 0; i < actualSize; i++) {
            System.out.println(values[i]);
        }
    }

    /**
     * Exibe os elementos da lista em ordem reversa.
     */
    public void reverseShow() {
        for (int i = actualSize - 1; i >= 0; i--) {
            System.out.println(values[i]);
        }
    }

    /**
     * Adiciona um novo elemento no final da lista.
     * @param obj elemento a ser adicionado
     */
    public void append(T obj) {
        ensureCapacity();
        values[actualSize++] = obj;
    }

    /**
     * Adiciona um novo elemento numa posição específica da lista,
     * deslocando os elementos posteriores.
     * @param pos posição onde o elemento será inserido
     * @param obj elemento a ser inserido
     */
    public void append(int pos, T obj) {
        if (pos < 0 || pos > actualSize) {
            return; // posição inválida
        }
        ensureCapacity();

        // Move os elementos à frente para abrir espaço
        for (int i = actualSize; i > pos; i--) {
            values[i] = values[i - 1];
        }

        values[pos] = obj;
        actualSize++;
    } 
    
    /**
     * Adiciona múltiplos elementos ao final da lista.
     * @param objs varargs de elementos a serem inseridos.
     */
    public void append(@SuppressWarnings("unchecked") T... objs) {
        for (T obj : objs) {
            append(obj);
        }
    }
    
    /**
     * Insere um elemento no início da lista (índice 0), deslocando os demais.
     * Equivalente a chamar append(0, obj).
     * @param obj objeto a ser adicionado na lista.
     */
    public void appendStart(T obj){
        append(0, obj);
    }

    /**
    * Insere um elemento no final da lista.
    * Equivalente a chamar append(obj), mas com nome mais descritivo.
    * 
    * @param obj o elemento a ser inserido no final da lista
    */
    public void appendEnd(T obj) {
        append(obj);
    }
    
    /**
    * Remove o elemento na posição especificada, deslocando os elementos subsequentes.
    * 
    * @param index o índice do elemento a ser removido
    * @throws IndexOutOfBoundsException se o índice for inválido
    */
    public void removeAt(int index) {
        if (index < 0 || index >= actualSize) {
            throw new IndexOutOfBoundsException("Índice inválido: " + index);
        }

        for (int i = index; i < actualSize - 1; i++) {
            values[i] = values[i + 1];
        }

        values[--actualSize] = null; // Limpa a referência para evitar memory leak
    }

    /**
     * Remove a primeira ocorrência do elemento informado, se existir.
    * 
    * @param obj o elemento a ser removido
    * @return true se o elemento foi removido, false se não encontrado
     */
    public boolean remove(T obj) {
        int index = indexOf(obj);
        if (index != -1) {
            removeAt(index);
            return true;
        }
        return false;
    }

    /**
    * Remove todos os elementos da lista, esvaziando-a.
    */
    public void clear() {
        for (int i = 0; i < actualSize; i++) {
            values[i] = null;
        }
        actualSize = 0;
    }

    /**
    * Verifica se a lista contém o elemento especificado.
    * 
    * @param obj o elemento a verificar
    * @return true se o elemento estiver presente, false caso contrário
    */
    public boolean contains(T obj) {
        return indexOf(obj) != -1;
    }

    /**
    * Cria uma cópia profunda da lista.
    * @return nova instância da lista com os mesmos elementos
    */
    @SuppressWarnings("unchecked")
    @Override
    public List<T> clone() {
        List<T> cloned = new List<>(this.maxSize);
        for (int i = 0; i < this.actualSize; i++) {
            cloned.append((T) this.values[i]);
        }
        return cloned;
    }


    /**
     * Retorna a capacidade máxima atual da lista.
     */
    public int getMaxSize() {
        return maxSize;
    }

    /**
     * Retorna o número de elementos atualmente armazenados na lista.
     */
    public int getActualSize() {
        return actualSize;
    }

    /**
     * Verifica se a lista está cheia (atingiu a capacidade máxima).
     */
    public boolean isFull() {
        return actualSize == maxSize;
    }
    
    public boolean isEmpty(){
        return actualSize == 0;
    }
    
    /**
     * Garante que haja espaço para novos elementos. Se a lista estiver cheia,
     * dobra a capacidade criando um array e copiando os dados para ele.
     */
    private void ensureCapacity() {
        if (isFull()) {
            int newSize = maxSize * 2;
            Object[] newArray = new Object[newSize];
            System.arraycopy(values, 0, newArray, 0, actualSize);
            values = newArray;
            maxSize = newSize;
        }
    }
    
    /**
     * Retorna o índice de um objeto da lista.
     * @param obj objeto que queremos o índice.
     * @return qual posição da lista o objeto está.
     */
    public int indexOf(T obj){
        for (int i = 0; i < actualSize; i++){
            if (obj == null && values[i] == null){
                return i;
            } 
            if (obj != null && obj.equals(values[i])){
                return i;
            }
        }
        return -1;
    }
       
    /**
     * Adiciona um valor "objeto" numa posição específica.
     * @param index é a posição da lista em que vamos trocar um item.
     * @param value é o valor, um generic.
     */
    public void set(int index, T value){
        if (index < 0 || index > maxSize){
            throw new IndexOutOfBoundsException("Índice está inválido" + index);
        }
        values[index] = value;
    }
    
    /**
     * Ordena os elementos da lista utilizando um comparador personalizado.
     *
     * @param comparator o comparador que define a ordem dos elementos
     * @throws NullPointerException se o comparador for nulo
     */
    @SuppressWarnings("unchecked")
    public void sort(Comparator<T> comparator) {
        if (comparator == null) {
            throw new NullPointerException("Comparador não pode ser nulo.");
        }
        T[] tempArray = (T[]) Arrays.copyOf(values, actualSize);
        Arrays.sort(tempArray, comparator);
        for (int i = 0; i < actualSize; i++) {
            values[i] = tempArray[i];
        }
    }
    
    /**
     * Inverte a ordem dos elementos na lista.
     * <p>
     * Após a execução, o primeiro elemento será o último e vice-versa.
     */
    public void reverse() {
        for (int i = 0; i < actualSize / 2; i++) {
            Object temp = values[i];
            values[i] = values[actualSize - 1 - i];
            values[actualSize - 1 - i] = temp;
        }
    }
    
    /**
     * Retorna o elemento armazenado numa posição específica.
     * @param index índice desejado
     * @return elemento do tipo T
     * @throws IndexOutOfBoundsException se o índice for inválido
     */
    public T get(int index) {
        if (index < 0 || index >= actualSize) {
            throw new IndexOutOfBoundsException("Índice inválido: " + index);
        }
        @SuppressWarnings("unchecked")
        T value = (T) values[index];
        return value;
    }
    
    /**
     * Retorna um iterador que percorre os elementos da lista do início ao fim.
     * <p>
     * Esse método permite o uso da lista com o laço "for-each", fornecendo
     * uma forma conveniente de iterar sobre os elementos armazenados.
     *
     * @return um Iterator que percorre os elementos da lista
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < actualSize;
            }

            @Override
            @SuppressWarnings("unchecked")
            public T next() {
                return (T) values[index++];
            }
        };
    }

    /**
     * Retorna uma representação textual da lista, com um elemento por linha.
     */
    @Override
    public String toString() {
        StringBuilder sReturn = new StringBuilder();
        for (int i = 0; i < actualSize; i++) {
            sReturn.append(values[i]).append("\n");
        }
        return sReturn.toString();
    }

    /**
     * Retorna uma representação textual da lista, com um elemento por linha
     * Com o seu respetivo tipo.
     * @return Uma ‘string’ com todos os elementos da lista.
     */
    public String toStringType(){
        String sReturn = "\n";
        for (int i = 0; i < actualSize; i++){
            if (values[i] instanceof String){
                sReturn += "Value: " + values[i] + " Type: String\n";
            }
            else if (values[i] instanceof Integer){
                sReturn += "Value: " + values[i] + " Type: Integer\n";
            }
            else if (values[i] instanceof Double){
                sReturn += "Value: " + values[i] + " Type: Double\n";
            }
            else if (values[i] instanceof Float){
                sReturn += "Value: " + values[i] + " Type: Float\n";
            }
            else if (values[i] instanceof Long){
                sReturn += "Value: " + values[i] + " Type: Long\n";
            }
            else if (values[i] instanceof Boolean){
                sReturn += "Value: " + values[i] + " Type: Boolean\n";
            }
            else if (values[i] instanceof Character){
                sReturn += "Value: " + values[i] + " Type: Character\n";
            }
            else if (values[i] != null){
                sReturn += "Value: " + values[i] + " Type: Object\n";
            }
            else {
                sReturn += "Value: null\n";
            }
        }
        return sReturn;
    }
}
