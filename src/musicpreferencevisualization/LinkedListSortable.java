package musicpreferencevisualization;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LinkedListSortable<E> implements LList<E> {

    public static class Node<D> {

        private D data;

        private Node<D> next;


        public Node(D d) {
            data = d;
        }


        public void setNext(Node<D> n) {
            next = n;
        }


        public Node<D> next() {
            return next;
        }


        public D getData() {
            return data;
        }
    }

    private Node<E> head;
    private Node<E> sorted;

    private int size;


    public LinkedListSortable() {
        head = null;
        size = 0;

    }


    @Override
    public int size() {
        return size;
    }


    @Override
    public void add(int index, E obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Object is null");
        }

        if ((index < 0) || (index > size())) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        Node<E> current = head;

        if (isEmpty()) {
            head = new Node<E>(obj);
        }

        else if (index == 0) {
            Node<E> newNode = new Node<E>(obj);
            newNode.setNext(current);
            head = newNode;
        }

        else {
            int currentIndex = 0;
            while (current != null) {
                if ((currentIndex + 1) == index) {
                    Node<E> nextNext = current.next;
                    Node<E> newNode = new Node<E>(obj);
                    current.setNext(newNode);
                    newNode.setNext(nextNext);
                }
                current = current.next();
                currentIndex++;
            }
        }
        size++;
    }


    @Override
    public void add(E obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Object is null");
        }

        Node<E> current = head;

        if (isEmpty()) {
            head = new Node<E>(obj);
        }

        else {
            while (current.next != null) {
                current = current.next;
            }
            current.setNext(new Node<E>(obj));
        }
        size++;
    }


    @Override
    public boolean isEmpty() {
        return (size == 0);
    }


    @Override
    public boolean remove(E obj) {
        Node<E> current = head;

        if ((null != head) && (obj.equals(current.data))) {
            head = head.next;
            size--;
            return true;
        }

        while (size() >= 2 && (current.next != null)) {
            if ((obj.equals(current.next.data))) {
                if (current.next.next != null) {
                    current.setNext(current.next.next);
                }
                else {
                    current.setNext(null);
                }
                size--;
                return true;
            }
            current = current.next;
        }

        return false;
    }


    @Override
    public boolean remove(int index) {
        if (index < 0 || head == null) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        else {

            Node<E> current = head;
            int currentIndex = 0;

            if ((index == 0)) {
                head = head.next;
                size--;
                return true;
            }

            while (current.next != null) {
                if ((currentIndex + 1) == index) {
                    Node<E> newNext = current.next.next;
                    current.setNext(newNext);
                    size--;
                    return true;
                }
                current = current.next;
                currentIndex++;
            }

            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
    }


    @Override
    public E get(int index) {
        Node<E> current = head;
        int currentIndex = 0;
        E data = null;
        while (current != null) {
            if (currentIndex == index) {
                data = current.data;
            }
            currentIndex++;
            current = current.next;
        }

        if (data == null) {
            throw new IndexOutOfBoundsException("Index exceeds the size.");
        }
        return data;
    }


    @Override
    public boolean contains(E obj) {
        Node<E> current = head;
        while (current != null) {
            if (obj.equals(current.data)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }


    @Override
    public void clear() {
        if (head != null) {
            head.setNext(null);
            head = null;
            size = 0;
        }
    }


    @Override
    public int lastIndexOf(E obj) {
        int lastIndex = -1;
        Node<E> current = head;
        int currentIndex = 0;
        while (current != null) {
            if (obj.equals(current.data)) {
                lastIndex = currentIndex;
            }
            currentIndex++;
            current = current.next;

        }
        return lastIndex;
    }


    @Override
    public String toString() {
        String result = "{";

        Node<E> current = head;
        while (current != null) {
            result += "" + current.data;
            current = current.next;
            if (current != null) {
                result += ", ";
            }
        }
        result += "}";
        return result;
    }


    public Object[] toArray() {

        Object[] array = new Object[this.size()];

        Node<E> current = head;
        int count = 0;
        while (current != null) {
            array[count] = current.getData();
            current = current.next;
            count++;
        }

        return array;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            @SuppressWarnings("unchecked")
            LinkedListSortable<E> other = ((LinkedListSortable<E>)obj);
            if (other.size() == this.size()) {
                Node<E> current = head;
                Node<E> otherCurrent = other.head;
                while (current != null) {
                    if (!current.getData().equals(otherCurrent.getData())) {
                        return false;
                    }
                    current = current.next();
                    otherCurrent = otherCurrent.next();
                }
                return true;
            }
        }

        return false;
    }


    public void sort(String sortType) {
        sorted = null;
        Node<E> current = head;
        while (current != null) {
            Node<E> next = current.next();
            insert(current, sortType);
            current = next;
        }
        head = sorted;
    }


    private void insert(Node<E> current, String sortType) {
        if (sorted == null || ((Song)sorted.data).compareTo((Song)current.data,
            sortType) >= 0) {
            current.setNext(sorted);
            sorted = current;
        }
        else {
            Node<E> tempCurr = sorted;
            while (tempCurr.next() != null && ((Song)tempCurr.next().data).compareTo(
                (Song)current.data, sortType) < 0) {
                tempCurr = tempCurr.next();
            }
            current.setNext(tempCurr.next());
            tempCurr.setNext(current);
        }
    }


    @SuppressWarnings("resource")
    public void output(String representation) {
        try {
            @SuppressWarnings("unchecked")
            Node<Song> temp = (Node<Song>)head;
            File outFile = new File("output.txt");
            FileWriter fWriter;
            fWriter = new FileWriter(outFile);
            PrintWriter pWriter = new PrintWriter(fWriter);
            while (temp != null) {
                Song tempSong = temp.getData();
                pWriter.println("Song Title: " + tempSong.getTitle());
                pWriter.println("Song Artist: " + tempSong.getName());
                pWriter.println("Song Year: " + tempSong.getReleaseYear());

                int[] heard = tempSong.getHeard();
                int[] liked = tempSong.getLiked();
                pWriter.println("Heard");
                if (representation == "Hobby") {
                    pWriter.println("reading:" + heard[0] + " art:" + heard[1]
                        + " sports:" + heard[2] + " music:" + heard[3]);
                }
                else if (representation == "Major") {
                    pWriter.println("computer science:" + heard[0]
                        + " engineering:" + heard[1] + " math or CMDA:"
                        + heard[2] + " other:" + heard[3]);
                }
                else if (representation == "Region") {
                    pWriter.println("southwest:" + heard[0] + " southeast:"
                        + heard[1] + " nortwest:" + heard[2] + " northeast:"
                        + heard[3]);
                }
                else {
                    throw new IllegalArgumentException(
                        "Not a valid category to represent - refer to user specs");
                }
                pWriter.println("Liked");
                if (representation == "Hobby") {
                    pWriter.println("reading:" + liked[0] + " art:" + liked[1]
                        + " sports:" + liked[2] + " music:" + liked[3]);
                }
                else if (representation == "Major") {
                    pWriter.println("computer science:" + liked[0]
                        + " engineering:" + liked[1] + " math or CMDA:"
                        + liked[2] + " other:" + liked[3]);
                }
                else if (representation == "Region") {
                    pWriter.println("southwest:" + liked[0] + " southeast:"
                        + liked[1] + " nortwest:" + liked[2] + " northeast:"
                        + liked[3]);
                }
                else {
                    throw new IllegalArgumentException(
                        "Not a valid category to represent - refer to user specs");
                }
                pWriter.println();
                temp = temp.next();
            }
            pWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
