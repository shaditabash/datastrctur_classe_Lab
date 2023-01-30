class LinkedList {
    Node head; // head of the list

    /* Linked list Node*/
    static class Node {
        int data;
        Node next;

        // Constructor to create a new node
        // Next is by default initialized
        // as null
        Node(int d) {
            data = d;
            next = null;
        }


    }

    /* This function is in LinkedList class. Inserts a
        new Node at front of the list. This method is
        defined inside LinkedList class shown above */
    public void push(int new_data) {
	/* 1 & 2: Allocate the Node &
			Put in the data*/
        Node new_node = new Node(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    /* This function is in LinkedList class.
       Inserts a new node after the given prev_node. This method is
       defined inside LinkedList class shown above */
    public void insertAfter(Node prev_node, int new_data) {
        /* 1. Check if the given Node is null */
        if (prev_node == null) {
            System.out.println(
                    "The given previous node cannot be null");
            return;
        }

        /*
        2. Allocate the Node &
        3. Put in the data*/
        Node new_node = new Node(new_data);

        /* 4. Make next of new Node as next of prev_node */
        new_node.next = prev_node.next;

        /* 5. make next of prev_node as new_node */
        prev_node.next = new_node;
    }

    /* Appends a new node at the end. This method is
       defined inside LinkedList class shown above */
    public void append(int new_data) {
	/* 1. Allocate the Node &
	2. Put in the data
	3. Set next as null */
        Node new_node = new Node(new_data);

	/* 4. If the Linked List is empty, then make the
		new node as head */
        if (head == null) {
            head = new Node(new_data);
            return;
        }

	/* 4. This new node is going to be the last node, so
		make next of it as null */
        new_node.next = null;

        /* 5. Else traverse till the last node */
        Node last = head;
        while (last.next != null)
            last = last.next;

        /* 6. Change the next of last node */
        last.next = new_node;
        return;
    }

    /* This function prints contents of linked list starting from
        the given node */
    public void printList() {
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
    }

    /* Given a key, deletes the first
       occurrence of key in
     * linked list */
    public void deleteNode(int key) {
        // Store head node
        Node temp = head, prev = null;

        // If head node itself holds the key to be deleted
        if (temp != null && temp.data == key) {
            head = temp.next; // Changed head
            return;
        }

        // Search for the key to be deleted, keep track of
        // the previous node as we need to change temp.next
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        // If key was not present in linked list
        if (temp == null)
            return;

        // Unlink the node from linked list
        prev.next = temp.next;
    }

    /* Given a reference (pointer to pointer) to the head of
       a list
       and a position, deletes the node at the given
       position */
    void deleteNodeByPosition(int position) {
        // If linked list is empty
        if (head == null)
            return;

        // Store head node
        Node temp = head;

        // If head needs to be removed
        if (position == 0) {
            head = temp.next; // Change head
            return;
        }

        // Find previous node of the node to be deleted
        for (int i = 0; temp != null && i < position - 1; i++)
            temp = temp.next;

        // If position is more than number of nodes
        if (temp == null || temp.next == null)
            return;

        // Node temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        Node next = temp.next.next;

        temp.next
                = next; // Unlink the deleted node from list
    }


    /* Function deletes the entire linked list */
    void deleteList() {
        head = null;
    }

    // Checks whether the value x is present in linked list
    public boolean iterativeSearch(Node head, int x) {
        Node current = head; // Initialize current
        while (current != null) {
            if (current.data == x)
                return true; // data found
            current = current.next;
        }
        return false; // data not found
    }

    // Checks whether the value x is present
    // in linked list
    public boolean recursiveSearch(Node head, int x) {
        // Base case
        if (head == null)
            return false;

        // If key is present in current node,
        // return true
        if (head.data == x)
            return true;

        // Recur for remaining list
        return recursiveSearch(head.next, x);
    }

    /* Returns count of nodes in linked list */
    public int getCount() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    /* Counts the no. of occurrences of a node
    (search_for) in a linked list (head)*/
    int count(int search_for)
    {
        Node current = head;
        int count = 0;
        while (current != null) {
            if (current.data == search_for)
                count++;
            current = current.next;
        }
        return count;
    }


    void removeDuplicates()
    {
        /*Another reference to head*/
        Node curr = head;

        /* Traverse list till the last node */
        while (curr != null) {
            Node temp = curr;
            /*Compare current node with the next node and
            keep on deleting them until it matches the current
            node data */
            while(temp!=null && temp.data == curr.data) {
                temp = temp.next;
            }
            /*Set current node next to the next different
            element denoted by temp*/
            curr.next = temp;
            curr = curr.next;
        }
    }

    /* Driver program to test above functions. Ideally this function
       should be in a separate user class.  It is kept here to keep
       code compact */
    public static void main(String[] args) {
        /* Start with the empty list */
        LinkedList llist = new LinkedList();

        // Insert 6.  So linked list becomes 6->NUllist
        llist.append(6);

        // Insert 7 at the beginning. So linked list becomes
        // 7->6->NUllist
        llist.push(7);

        // Insert 1 at the beginning. So linked list becomes
        // 1->7->6->NUllist
        llist.push(1);

        // Insert 4 at the end. So linked list becomes
        // 1->7->6->4->NUllist
        llist.append(4);

        // Insert 8, after 7. So linked list becomes
        // 1->7->8->6->4->NUllist
        llist.insertAfter(llist.head.next, 8);

        System.out.println("\nCreated Linked list is: ");
        llist.printList();

        System.out.println("\nCreated Linked list is:");
        llist.printList();

        llist.deleteNode(1); // Delete node with data 1

        System.out.println(
                "\nLinked List after Deletion of 1:");
        llist.printList();

        System.out.println("\nCreated Linked list is: ");
        llist.printList();

        llist.deleteNodeByPosition(4); // Delete node at position 4

        System.out.println(
                "\nLinked List after Deletion at position 4: ");
        llist.printList();

        // Function call
        System.out.println("\nCount of nodes is "
                + llist.getCount());

        // Function call
        if (llist.iterativeSearch(llist.head, 21))
            System.out.println("\nYes");
        else
            System.out.println("\nNo");


        // Function call
        if (llist.recursiveSearch(llist.head, 21))
            System.out.println("\nYes");
        else
            System.out.println("\nNo");


        /*Checking count function*/
        System.out.println("\nCount of 1 is " + llist.count(1));


        llist.printList();

        llist.removeDuplicates();

        System.out.println("\nList after removal of elements");
        llist.printList();
        System.out.println("\nDeleting the list");
        llist.deleteList();

        System.out.println("\nLinked list deleted");

    }

}
