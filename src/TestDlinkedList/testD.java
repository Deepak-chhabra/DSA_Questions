package TestDlinkedList;

   /*

 * Complete LinkedList Implementation
 *
 * Operations Covered:
 * 1. Insert at Beginning
 * 2. Insert at End
 * 3. Insert at Position
 * 4. Delete from Beginning
 * 5. Delete from End
 * 6. Delete at Position
 * 7. Delete by Value
 * 8. Search Element
 * 9. Get Length
 * 10. Reverse LinkedList
 * 11. Detect Cycle
 * 12. Find Middle Element
 * 13. Remove Duplicates
 * 14. Merge Two Sorted Lists
 * 15. Check if Palindrome

 */

class Node{
     int data ;
     Node next ;

    Node(int data ){
        this.data = data ;
        next = null ;
    }
}

class LinkedList{
    private Node head ;
    private int size ;

    LinkedList(){
        this.head = null ;
        this.size = 0 ;
    }

    // Inserting the element at the beginning of the linked list
    // Time complexity :: O(1) and Space complexity :: O(1)

    public void insertAtBeginning(int data ){
        Node newNode = new Node(data);
        newNode.next = head ;
        head = newNode;
        size++;
    }


    // Inserting at the end of the linked list
    // Time complexity :: O(n) and space complexity :: O(n)
    public void insertAtEnd(int data ){
        Node newNode = new Node(data);
        if(head == null ){          // if head ==  null inserting in the beginning
            head = newNode;
            size++;
            return ;
        }

        Node temp = head ;
        while(temp.next != null){
             temp = temp.next;
        }
        temp.next = newNode ;
        size++;
    }


    // insert at the particular position
    // time complexity :: O(n) and space complexity :: O(n)
    public void insertAtPosition(int data, int pos ){

        if(pos == 0 ){
            insertAtBeginning(data);
            return ;
        }
        if(pos < 0 || pos > size ){
             throw new IllegalArgumentException("Position of the element should be in between");
        }

        if(pos == 0  ){
            insertAtBeginning(data);
            return ;
        }

        Node newNode = new Node(data);
        Node temp = head ;
        for(int i = 0 ; i < pos -1  ; i++){
             temp = temp.next;
        }
        newNode.next = temp.next ;
        temp.next = newNode ;
        size++;
    }

    // -------------------DELETION METHODS---------------------------------------

    public void deletingFromBegin(){
           if(head == null ){
               throw new IllegalArgumentException("List is already empty");
           }
           head = head.next ;
           size--;
    }

    public void deletingFromEnd(){
        if(head == null ){
            throw new IllegalArgumentException("List is already empty ");
        }

        if(head.next == null){ // Only one node
            head = null ;
            size--;
            return ;
        }

        Node temp = head ;
        while(temp.next.next != null){
            temp = temp.next ;
        }
        temp.next = null ;
        size--;
    }

    public void deletingAtPosition(int pos ){
        if(pos < 0 || pos >= size ){
            throw new IllegalArgumentException("invalid Position :: " + pos );
        }

        if(pos == 0 ){
            deletingFromBegin();
            return ;
        }
        Node temp = head ;

      for(int i  = 0 ; i < pos-1 ; i++){
           temp = temp.next ;
      }

        if(temp.next != null) {
            temp.next = temp.next.next;
            size--;

        }
    }

    public void deleteByValue(int value){

        if(head == null){
            throw new IllegalArgumentException("List is empty ");
        }

        if(head.data == value ){
            head = head.next ;
            size--;
            return ;
        }

        Node temp = head ;

        while(temp.next != null){
             if(temp.next.data == value ){
                     temp.next = temp.next.next ;
                     size--;
                     return ;
             }

             temp = temp.next ;
        }
        throw new IllegalArgumentException("value is not found ");
    }

    // SEARCHING

    public boolean searchElement(int value ){
        if(head == null){
            throw new IllegalArgumentException("list is empty");
        }

        Node temp = head;
        while(temp != null){
            if(temp.data == value ) return true ;
            else temp = temp.next ;
        }
        return false ;
    }

    // Get the length of the list
    public int getLength(){
        return size ;
    }

    // Display the Linkedlist
    // time complexity :: O(n) and space complexity :: O(n)
    public void display(){
        Node temp = head ;
        while(temp != null){
            System.out.print(temp.data);
            temp = temp.next;
            System.out.print("->");
        }
        System.out.print("null");
        System.out.println();
    }
}
public class testD {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        // creating the list with the data  4->5->78->0->12->56->90;
        list.insertAtBeginning(4);
        list.insertAtEnd(5);
        list.insertAtEnd(78);
        list.insertAtEnd(0);
        list.insertAtEnd(56);
        list.insertAtEnd(90);
        System.out.println("List(A):: ");
        list.display();  // List(A):: 4->5->78->0->56->90->null
        System.out.println("Size of the list :: " + list.getLength());


        // ----------------INSERTING AT THE POSITION ---------------------------
        LinkedList list1 = new LinkedList();
        list1.insertAtBeginning(4);
        list1.insertAtBeginning(5);
        list1.insertAtEnd(0);
        list1.insertAtEnd(56);
        System.out.println("Before inserting at the position ");
        list1.display();
        list1.insertAtPosition(78, 2);
        System.out.println("List(B) after inserting 78 at position 2  :: ");
        list1.display();


        list1.insertAtBeginning(0);
        list1.insertAtEnd(56);
        list1.insertAtBeginning(90);
        System.out.println("\nList(B) :: ");
        list1.display();
        System.out.println("Size: " + list1.getLength());

        // Test 3: Delete operations (TESTING DELETE BY VALUE FIX)
        System.out.println("\n--- Testing Delete by Value ---");
        list1.deletingFromEnd();
        System.out.println("After delete from end:");
        list1.display();

        list1.deletingFromEnd();
        System.out.println("After delete from end:");
        list1.display();

        list1.deletingAtPosition(4);
        System.out.println("After delete at position 4:");
        list1.display();

        System.out.println("Before delete value 90:");
        list1.display();
        list1.deleteByValue(90);
        System.out.println("After delete value 90:");
        list1.display();

        System.out.println("\nList(C) :: ");
        list1.display();
        System.out.println("Size: " + list1.getLength());

        // Test 4: Search
        System.out.println("\n--- Testing Search ---");
        System.out.println("Element 78 is present: " + list1.searchElement(78));
        System.out.println("Element 100 is present: " + list1.searchElement(100));

        // Test 5: Edge cases for delete by value
        System.out.println("\n--- Testing Delete by Value Edge Cases ---");
        LinkedList list2 = new LinkedList();
        list2.insertAtEnd(10);
        list2.insertAtEnd(20);
        list2.insertAtEnd(30);
        System.out.println("Original list:");
        list2.display();

        list2.deleteByValue(10); // Delete head
        System.out.println("After deleting head (10):");
        list2.display();

        list2.deleteByValue(30); // Delete tail
        System.out.println("After deleting tail (30):");
        list2.display();

        list2.deleteByValue(20); // Delete last element
        System.out.println("After deleting last element (20):");
        list2.display();

        // Test 6: Insert at position edge cases
        System.out.println("\n--- Testing Insert at Position Edge Cases ---");
        LinkedList list3 = new LinkedList();
        list3.insertAtPosition(5, 0); // Insert at beginning of empty list
        System.out.println("After insert 5 at position 0:");
        list3.display();

        list3.insertAtPosition(10, 1); // Insert at end
        System.out.println("After insert 10 at position 1:");
        list3.display();

        list3.insertAtPosition(7, 1); // Insert in middle
        System.out.println("After insert 7 at position 1:");
        list3.display();

        list3.insertAtPosition(1, 0); // Insert at beginning
        System.out.println("After insert 1 at position 0:");
        list3.display();
    }
}
