package com.github.abhinav;

// Implementation of singly linkedlist.

public class LinkedListImp {

  // head of the linkedlist.
  Node head;

  // Implementation of a linkedlist node.
  class Node {
    int data;
    Node next;

    // Constructor.
    Node(int data) {
      this.data = data;
    }
  }

  /* Prints all the values of the linkedlist.
   */
  public void printList() {
    Node currNode = head;
    while (currNode != null) {
      System.out.print(currNode.data + " ");
      currNode = currNode.next;
    }
    System.out.println();
  }

  /* Add a new element to the end of the linkedlist.
   * @param data: the value to add at the end of the linkedlist.
   */
  public void add(int data) {

    Node newNode = new Node(data);
    newNode.next = null;

    if (head == null) {
      head = newNode;
    } else {
      Node interim = head;
      while (interim.next != null) {
        interim = interim.next;
      }
      interim.next = newNode;
    }
  }

  /* Add a new element to the start of the linkedlist.
   * @param data: the value to add at the start of the linkedlist.
   */
  public void addFirst(int data) {

    Node newNode = new Node(data);
    newNode.next = null;

    if (head == null) {
      head = newNode;
    } else {
      newNode.next = head;
      head = newNode;
    }
  }

  /* Calculate the size of a linkedlist.
   * @return size: the size of the linkedlist
   */
  public int getSize() {
    int size = 0;
    Node currentNode = head;
    while (currentNode != null) {
      size += 1;
      currentNode = currentNode.next;
    }
    return size;
  }
}
