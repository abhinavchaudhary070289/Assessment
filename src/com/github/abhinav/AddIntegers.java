package com.github.abhinav;

// Class to implement addition of integers represented as LinkedList.
public class AddIntegers {
  int carry = 0;
  private LinkedListImp result = new LinkedListImp();
  private LinkedListImp.Node current;

  // Adds two linkedlist of same size.
  private void sumSameSize(LinkedListImp.Node listNode1, LinkedListImp.Node listNode2) {
    // Because both the lists are of same size, we can check for either of them.
    if (listNode1 == null) {
      return;
    }
    // recursively add elements from the end of each list.
    sumSameSize(listNode1.next, listNode2.next);
    int sum = carry + listNode1.data + listNode2.data;
    carry = sum / 10;
    sum = sum % 10;
    result.addFirst(sum);
  }
  // add the carry obtained after adding sublist of bigger list to the smaller list to the remaining
  // elements of bigger list.
  private void addCarry(LinkedListImp.Node node) {
    if (node != current) {
      // recursively add carry to the last element of remaining bigger list.
      addCarry(node.next);
      int sum = node.data + carry;
      carry = sum / 10;
      sum = sum % 10;
      result.addFirst(sum);
    }
  }

  // add two integers represented by linkedlist producing a new linkedlist of resulting sum.
  public LinkedListImp sumList(LinkedListImp firstList, LinkedListImp secondList) {

    // if both the list are null, return an empty result.
    if (firstList == null && secondList == null) {
      return new LinkedListImp();
    }
    // if first list is null return the second list as is.
    if (firstList == null) {
      return secondList;
    }
    // if second list is null return the first list as is.
    if (secondList == null) {
      return firstList;
    }

    int sizeFirstList = firstList.getSize();
    int sizeSecondList = secondList.getSize();

    // add if both list have same size.
    if (sizeFirstList == sizeSecondList) {
      sumSameSize(firstList.head, secondList.head);
    } else {
      // always keep the second list as bigger of both list.
      if (sizeFirstList > sizeSecondList) {
        LinkedListImp.Node temp = firstList.head;
        firstList.head = secondList.head;
        secondList.head = temp;
      }
      int diffInLength = Math.abs(sizeSecondList - sizeFirstList);
      LinkedListImp.Node temp = secondList.head;
      // skip the nodes in bigger list by difference.
      while (diffInLength >= 0) {
        current = secondList.head;
        secondList.head = secondList.head.next;
        diffInLength -= 1;
      }
      // add sublist of bigger list to same sized smaller list.
      sumSameSize(firstList.head, current);
      // add carry obtained from above step to the remaining elements of bigger list.
      addCarry(temp);
    }
    // add carry, if any, obtained after adding both lists.
    if (carry > 0) {
      result.addFirst(carry);
    }
    return result;
  }

  public static void main(String... args) {

    LinkedListImp firstList = new LinkedListImp();
    LinkedListImp secondList = new LinkedListImp();

    firstList.add(1);
    firstList.add(2);
    firstList.add(3);

    secondList.add(5);
    secondList.add(6);

    firstList.printList();
    secondList.printList();

    AddIntegers add = new AddIntegers();
    LinkedListImp resultList = add.sumList(firstList, secondList);
    resultList.printList();
  }
}
