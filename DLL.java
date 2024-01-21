import java.util.*;

public class DLL 
{
    class Node
    {
        int data;
        Node next;
        Node prev;

       Node(int data)
       {
            this.data = data;
            this.next = null;
            this.prev = null;
       } 
    }
    Node head = null;

    public void addFirst(int data)
    {
        Node newNode = new Node(data);
        
        if(head == null)
        {
            head = newNode ;
            head.next = null;
            head.prev = null;
            
            return;
        }
        head.prev = newNode;
        newNode.next = head;
        head = newNode;
    }

    void addLast(int data)
    {
        Node newNode = new Node(data);
         if(head == null)
        {
            head = newNode ;
            head.next = null;
            head.prev = null;
            
            return;
        }
        Node currNode = head;
        
        while(currNode.next != null)
        {
            currNode = currNode.next;
        }
        currNode.next = newNode;
        newNode.prev = currNode;
    }

    void addByPosition(int data,int position)
    {
        Node newNode = new Node(data);

        if(position == 0)
        {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        Node currNode = head;
        Node temp = head;
 
        for(int i=0; currNode != null && i < position-1;i++)
        {
            currNode = currNode.next;
        }
        if(currNode == null)
        {
            System.out.println("Wrong postion");
            return;
        }
        temp = currNode.next;
        currNode.next = newNode;
        newNode.next = temp;
        System.out.println(data+" is added in the list at "+position);
    }

    int listLenght()
    {
        Node currNode = head;
        int i = 0;
        for(i = 1; currNode.next != null; i++)
        {
            currNode = currNode.next;
        }
    
        return i;
    }

    boolean searchNum(int data)
    {
        Node currNode = head;
        int size = listLenght();

        for(int i=1 ; i <= size; i++)
        {
            if(data == currNode.data)
            {
                return true;
            }
            currNode = currNode.next;
        }
        return false;
    }

    void reverseList()
    {
        Node currNode = head;
        Node temp = null;

       while(currNode != null)
       {
            temp = currNode.prev;
            currNode.prev = currNode.next;
            currNode.next = temp;

            currNode = currNode.prev;
       }
       if(temp != null)
       {
        head = temp.prev;
       }
    }

    public void deleteByValue(int data)
    {
        if(head == null)
        {
            return;
        }
        Node currNode = head;
      

        if(head.data == data)
        {
            head = head.next;
            return;
        }
        while(currNode != null && currNode.data != data)
        {
            currNode = currNode.next;
        }
        if(currNode == null)
        {
            System.out.println(data+" is not found in the list");
            return;
        }
        if(currNode.next == null)
        {
            currNode.prev.next = null;
            System.out.println(data+" is deleted from the list");
            return;
        }
        
         currNode.prev.next = currNode.next;
         currNode.next.prev = currNode.prev;

        System.out.println(data+" is deleted from the list");
    }

    public void displayList()
    {
        Node currNode = head;

        if(head == null)
        {
            System.out.println("List is empty");
            return;
        }
        while(currNode != null)
        {
            System.out.print(currNode.data+" -> ");
            currNode = currNode.next;
        }
        System.out.println("NULL");
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int iRet = 0, num =0, choice = 1, position;
        boolean bRet = false;

        DLL dl = new DLL();

        while(true)
        {
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("             !!! Doubly LinkedList Operations !!!");
            System.out.println();
            System.out.print("1 . addFirst \t\t");
            System.out.print("2 . addLast\t\t");
            System.out.println("3 . addByPosition");
            System.out.print("4 . listLength\t\t");
            System.out.print("5 . searchNum\t\t");
            System.out.println("6 . reverseList");
            System.out.print("7 . deleteByValue\t");
            System.out.print("8 . display\t\t");
            System.out.println("9 . Exit");
            System.out.println();
            System.out.println("                       Enter any choice");
            System.out.println();
            System.out.println("---------------------------------------------------------------------------");
            
            choice = sc.nextInt();

            switch(choice)
            {
                case 1 :
                        System.out.println("Enter the number :");
                        num = sc.nextInt();
                        dl.addFirst(num);
                        System.out.println(num+" is added in the list");
                        break;
                case 2 :
                        System.out.println("Enter the number :");
                        num = sc.nextInt();
                        dl.addLast(num);
                        System.out.println(num+" is added in the list");
                        break;
                case 3 :
                        System.out.println("Enter the number :");
                        num = sc.nextInt();
                        System.out.println("Enter the position :");
                        position = sc.nextInt();
                        dl.addByPosition(num, position);
                    
                        break;
                case 4 :
                        iRet = dl.listLenght();
                        System.out.println("Lenght of this list : "+ iRet);
                        break;
                case 5 :
                        System.out.println("Enter the number to search in the list :");
                        num = sc.nextInt();

                        bRet = dl.searchNum(num);
                        if(bRet == true)
                        {
                            System.out.println(num+" is persent in the list ");
                        }else
                        {
                            System.out.println(num+" is not present in the list");
                        }
                        break;
                case 6 :
                        dl.reverseList();
                        dl.displayList();
                        break;
                case 7 :
                        iRet = dl.listLenght();

                        System.out.println("Enter number to delete:");
                        num = sc.nextInt();

                        dl.deleteByValue(num);
                        break;
                case 8 :
                        dl.displayList();
                        break;
                case 9 :
                        return;
                default :
                    System.out.println("Wrong choice Enter correct choice ");
            }
        }
    }
}
