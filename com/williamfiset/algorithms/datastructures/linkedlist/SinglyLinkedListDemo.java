package williamfiset.algorithms.datastructures.linkedlist;

public class SinglyLinkedListDemo {
    public static void main(String[] args) throws Exception {
        //LinkedList1 list = new LinkedList1();
        SinglyLinkedList list = new SinglyLinkedList();

        list.addFirst ("Apples");
        list.addFirst("Bananas");
        list.addFirst("Cantaloupe");
        list.addLast("Peanut");
        list.addLast("Coke");

        System.out.println("List has " + list.size() + " nodes");

        System.out.println(list.toString());

        if (list.contains("Cantaloupe")) {

            System.out.println("Cantaloupe is in the list.");
        }
        else {
            System.out.println("Cantaloupe is NOT in the list.");
        }
        System.out.println(list);
        list.removeAt(1);
        list.removeFirst();
        System.out.println(list);
        list.addAt(2,"Orange");
        //list.removeFirst();

        if (list.contains("Cantaloupe")) {

            System.out.println("Cantaloupe is in the list.");
        }
        else {
            System.out.println("Cantaloupe is NOT in the list.");
        }

        //list.clear();

        System.out.println("Start of list:");
        System.out.println(list.toString());
        System.out.println("End of list.");


    }
}


