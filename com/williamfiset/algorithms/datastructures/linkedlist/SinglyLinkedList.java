package williamfiset.algorithms.datastructures.linkedlist;

import java.util.Iterator;

public class SinglyLinkedList <T> implements Iterable<T>{
    private int size = 0;
    private SinglyLinkedList.Node<T> head = null;
    private SinglyLinkedList.Node<T> tail = null;

    // Internal node class to represent data
    private static class Node<T> {
        private T data;
        private SinglyLinkedList.Node<T>  next;

        public Node(T data, SinglyLinkedList.Node<T> next) {
            this.data = data;
            this.next = next;
        }
        public T getData(){return data;}
        public Node<T> getNext(){return next;}
        public void setNext(Node<T> next){this.next=next;}

        @Override
        public String toString() {
            return data.toString();
        }
    }


    // Empty this linked list, O(n)
    public void clear() {
        SinglyLinkedList.Node<T> trav = head;
        while (trav != null) {
            SinglyLinkedList.Node<T> next = trav.next;

            trav.data = null;
            trav = next;
        }
        head = tail = trav = null;
        size = 0;
    }

    // Return the size of this linked list
    public int size() {
        return size;
    }

    // Is this linked list empty?
    public boolean isEmpty() {
        return size() == 0;
    }

    // Add an element to the tail of the linked list, O(1)
    public void add(T elem) {
        addLast(elem);
    }

    // Add a node to the tail of the linked list, O(1)
    public void addLast(T elem) {
        if (isEmpty()) {
            head = tail = new SinglyLinkedList.Node<T>(elem, null);
        } else {
            SinglyLinkedList.Node<T> trav1 = head;
            for(int i=0; i<size-1;i++){
                trav1=trav1.next;
            }
            SinglyLinkedList.Node<T> newNode = new SinglyLinkedList.Node<>(elem,trav1.next);
            trav1.next = newNode;

        }
        size++;
    }


    // Add an element to the beginning of this linked list, O(1)
    public void addFirst(T elem) {
        if (isEmpty()) {
            head = new SinglyLinkedList.Node<T>(elem, null);
        } else {
            head= new SinglyLinkedList.Node<T>(elem,head);

        }
        size++;
    }

    // Add an element at a specified index
    public void addAt(int index, T data) throws Exception {
        if (index < 0) {
            throw new Exception("Illegal Index");
        }
        if (index == 0) {
            addFirst(data);
            return;
        }

        if (index == size) {
            addLast(data);
            return;
        }

        SinglyLinkedList.Node<T> temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        SinglyLinkedList.Node<T> newNode = new SinglyLinkedList.Node<>(data,temp.next);
        temp.next = newNode;



        size++;
    }

    // Check the value of the first node if it exists, O(1)
    public T peekFirst() {
        if (isEmpty()) throw new RuntimeException("Empty list");
        return head.data;
    }

    // Check the value of the last node if it exists, O(1)
    public T peekLast() {
        if (isEmpty()) throw new RuntimeException("Empty list");
        return tail.data;
    }

    // Remove the first value at the head of the linked list, O(1)
    public T removeFirst() {
        // Can't remove data from an empty list
        if (isEmpty()) throw new RuntimeException("Empty list");

        // Extract the data at the head and move
        // the head pointer forwards one node
        T data = head.data;
        head = head.next;
        --size;

        // If the list is empty set the tail to null
        if (isEmpty()) tail = null;

            // Do a memory cleanup of the previous node


        // Return the data that was at the first node we just removed
        return data;
    }

    // Remove the last value at the tail of the linked list, O(1)
    public T removeLast() {
        // Can't remove data from an empty list
        if (isEmpty()) throw new RuntimeException("Empty list");

        // Extract the data at the tail and move
        // the tail pointer backwards one node
        T data = tail.data;

        --size;

        // If the list is now empty set the head to null
        if (isEmpty()) head = null;

            // Do a memory clean of the node that was just removed
        else tail.next = null;

        // Return the data that was in the last node we just removed
        return data;
    }

    // Remove an arbitrary node from the linked list, O(1)
    private T remove(SinglyLinkedList.Node<T> node) {
        // If the node to remove is somewhere either at the
        // head or the tail handle those independently

        if (node.next == null) return removeLast();

        // Make the pointers of adjacent nodes skip over 'node'

        node.next= node.next.next;


        // Temporarily store the data we want to return
        T data = node.data;

        // Memory cleanup
        //node.data = null;
        //node = node.next = null;

        --size;

        // Return the data in the node we just removed
        return data;
    }

    // Remove a node at a particular index, O(n)
    public T removeAt(int index) {
        // Make sure the index provided is valid
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }

        int i;
        SinglyLinkedList.Node<T> trav1 = head;
        SinglyLinkedList.Node<T> trav2=head.next;

        // Search from the front of the list
        if (index < size / 2) {
            for (i = 0, trav1=head; i != index; i++) {
                trav1 = trav1.next;
               // trav2=trav2.next;
            }
            // Search from the back of the list
        }

        return remove(trav1);
    }

    // Remove a particular value in the linked list, O(n)
    public boolean remove(Object obj) {
        SinglyLinkedList.Node<T> trav = head;

        // Support searching for null
        if (obj == null) {
            for (trav = head; trav != null; trav = trav.next) {
                if (trav.data == null) {
                    remove(trav);
                    return true;
                }
            }
            // Search for non null object
        } else {
            for (trav = head; trav != null; trav = trav.next) {
                if (obj.equals(trav.data)) {
                    remove(trav);
                    return true;
                }
            }
        }
        return false;
    }

    // Find the index of a particular value in the linked list, O(n)
    public int indexOf(Object obj) {
        int index = 0;
        SinglyLinkedList.Node<T> trav = head;

        // Support searching for null
        if (obj == null) {
            for (; trav != null; trav = trav.next, index++) {
                if (trav.data == null) {
                    return index;
                }
            }
            // Search for non null object
        } else
            for (; trav != null; trav = trav.next, index++) {
                if (obj.equals(trav.data)) {
                    return index;
                }
            }

        return -1;
    }

    // Check is a value is contained within the linked list
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            private SinglyLinkedList.Node<T> trav = head;

            @Override
            public boolean hasNext() {
                return trav != null;
            }

            @Override
            public T next() {
                T data = trav.data;
                trav = trav.next;
                return data;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        SinglyLinkedList.Node<T> trav = head;
        while (trav != null) {
            sb.append(trav.data);
            if (trav.next != null) {
                sb.append(", ");
            }
            trav = trav.next;
        }
        sb.append(" ]");
        return sb.toString();
    }
}
