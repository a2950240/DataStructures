package com.lin;

/**
 * Created by l on 2018/5/6.
 * 增删 O(n)
 * 改查 已知索引O(1) 未知索引O(n)
 */
public class Array<E> {

    private E[] data;
    //有效元素
    private int size;

    /**
     * 构造函数，传入数组的容量capacity构造Array
     *
     * @param capacity
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 无参数的构造函数，默认数组的容量capacity=10
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组中的元素个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组的容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 返回数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向所有元素后添加一个新元素O(1)
     *
     * @param e
     */
    public void addLast(E e) {
//        if (size == data.length)
//            throw new IllegalArgumentException("AddLast failed. Array is full");
//        data[size] = e;
//        size++;
        add(size, e);
    }

    // 在所有元素前添加一个新元素O(n)
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在第index个位置插入一个新元素e
     * O(n/2)=O(n)
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        //保证数连续
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >=0 and <=size");
        }
        //动态数组
        if (size == data.length)
            //throw new IllegalArgumentException("AddLast failed. Array is full");
            resize(2 * data.length);
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    //扩容 缩容 O(n)
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    // 获取index索引位置的元素O(1)
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    public  E getLast(){
        return get(size-1);
    }

    public E getFirst(){
        return get(0);
    }

    //修改index索引位置的元素为e O(1)
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        data[index] = e;
    }

    //查找数组中是否有元素e O(n)
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    //O(n)
    //查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    //从数组中删除index位置的元素，返回删除的元素O(n/2)=O(n)
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;// loitering(闲散的) objects != memory leak
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    //从数组中删除第一个元素，返回删除的元素O(n)
    public E removeFirst() {
        return remove(0);
    }

    //从数组中删除最后一个元素，返回删除的元素O(1)
    public E removeLast() {
        return remove(size - 1);
    }

    //从数组中删除元素e
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }
    //TODO 删除重复元素

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity= %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }



}
