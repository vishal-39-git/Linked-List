import java.util.*;

class Node
{
    int data;
    Node next = null;
    
    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}

public class SLL
{
    Node head = null;
   
    public void addFirst(int data)
    {
        Node newNode = new Node(data);
        if(head == null)
        {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data)
    {
        Node newNode = new Node(data);
        if(head == null)
        {
            head = newNode;
            return;
        }
        Node currNode = head;

        while(currNode.next != null)
        {
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    public void addAtPosition(int data,int position)
    {
        Node newNode = new Node(data);
        Node currNode = head;
        Node temp = head;

        if(position == 0)
        {
            if(head == null)
            {
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }
        for(int i=0; currNode != null && i< position-1; i++)
        {
            currNode = currNode.next;
        }
        if(currNode == null)
        {
            System.out.println("wrong position");
            return;
        }
        temp = currNode.next;
        currNode.next = newNode;
        newNode.next = temp;
    }

    public void displayList()
    {
        Node currNode = head;

        while(currNode != null)
        {
            System.out.print(currNode.data +" -> ");
            currNode = currNode.next;
        }
        System.out.println("NULL");
    }
    public void deleteFirst()
    {
        if(head == null)
        {
            System.out.println("List is empty");
            return;   
        }
        head = head.next;

        System.out.println("First node is deleted");
    }

    public void deleteLast()
    {
        if(head == null)
        {
            System.out.println("List is empty");
            return;
        }
        if(head.next == null)
        {
            head = null;
            return;
        }

        Node currNode = head;

        while(currNode.next.next != null)
        {
            currNode = currNode.next;
        }
        currNode.next = null;
        System.out.println("Last node is deleted");
    }

    public void deleteByValue(int data)
    {
        if(head == null)
        {
            System.out.println("List is empty nothing to delete");
            return;
        }
        if(head.data == data)
        {
             head = head.next;

            System.out.println(data+" deleted");
            return;
        }
        Node currNode = head;
        Node prevNode = null;

        while(currNode !=null && currNode.data != data )
        {
            prevNode = currNode;
            currNode = currNode.next;
        }
        if(currNode != null)
        {
            prevNode.next = currNode.next;

            System.out.println(data+" Deleted");
            return;
        }
        System.out.println("This number is not present in list");
    }

    public void deleteByPosition(int position)
    {
        if(head == null)
        {
            System.out.println("List is empty");
            return;
        }
        if(position == 0)
        {
            System.out.println(head.data+" is on position "+position+" which is deleted");
            head = head.next;
            return;
        }

        Node currNode = head;
        Node temp = head;
        for(int i = 0;currNode !=null && i < position-1;i++)
        {
            currNode = currNode.next;
        }
        if(currNode == null || currNode.next == null)
        {
            System.out.println("wrong position");
            return;
        }
        temp = currNode.next;
        currNode.next = currNode.next.next;

        System.out.println(temp.data+" is on position "+position+" which is deleted");
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int num,position,choice;

        SLL list = new SLL();
        while(true)
        {
            System.out.println("===========================================================================");
            System.out.println("1 . addFirst ");
            System.out.println("2 . addLast ");
            System.out.println("3 . addAtPosition ");
            System.out.println("4 . deleteFirst ");
            System.out.println("5 . deleteLast ");
            System.out.println("6 . deleteByValue ");
            System.out.println("7 . deleteByPosition ");
            System.out.println("8 . display list ");
            System.out.println("9 . Exit ");
            System.out.println("===========================================================================");
            System.out.println("Enter the choice");
            choice = sc.nextInt();

            switch(choice)
            {
                case 1 :
                    System.out.println("Enter number");
                    num = sc.nextInt();
                    list.addFirst(num);
                    break;

                case 2 :
                    System.out.println("Enter number");
                    num = sc.nextInt();
                    list.addLast(num);
                    break;
                case 3 :
                    System.out.println("Enter number");
                    num = sc.nextInt();
                    System.out.println("Enter position");
                    position = sc.nextInt();
                    list.addAtPosition(num,position);
                    break;
                case 4 :
                    list.deleteFirst();
                    break;
                case 5 :
                    list.deleteLast();
                    break;
                case 6 :
                    System.out.println("Enter number");
                    num = sc.nextInt();
                    list.deleteByValue(num);
                    break;
                case 7 :
                    System.out.println("Enter position");
                    position = sc.nextInt();
                    list.deleteByPosition(position);
                    break;
                case 8 :
                    list.displayList();
                    break;
                case 9 :
                    return;
                default :
                 System.out.println("invalid choice");
            }
        }   
    }
}