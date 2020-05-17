package ru.progwards.java2.lessons.basetypes;

public class DoubleHashTable {
//    Реализовать класс DoubleHashTable - хэш таблица с двойным хэшированием
//
//    В качестве размера таблицы выбирать простое число, первоначальное значение 101
//
//    При количестве коллизий более 10% при одной серии пробирований - перестраивать таблицу, увеличивая размер
//
//    Стратегия роста - удвоение размера, но с учетом правила - размер таблицы простое число. Т.е. искать ближайшее простое
//
//    Ключи должны реализовывать интерфейс
//    interface HashValue {
//        int getHash();
//
//    }
//
//    Для числовых значение взять хэш 2 функции - деление и умножение
//
//    Для строковых - выбрать что-то, из представленных в лекции
//
//    Методы
//
//2.1 public void add(K key, V value) - добавить пару ключ-значение
//
//2.2 public V get(K key) - получить значение по ключу
//
//2.3 public void remove(K key) - удалить элемент по ключу
//
//2.4 public void change(K key1, Key key2) - изменить значение ключа у элемента с key1 на key2
//
//2.5 public int size() - получить количество элементов
//
//2.6 public Iterator<DoubleHashTable<K,V>> getIterator()
}
