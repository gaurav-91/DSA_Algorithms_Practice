public class MaxSumOfMirrorImageNodeInSingleLL {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        //Node {int data; Node next;}

        //1->2->3->5->null output: 6
        //1->2->8->5->null output: 10

        //1->2->4->8->5->null output: 10
        //1->2->11->8->5->null output: 11
        //Node root = null;
        Node head = new Node(1, null);
        Node root = head;
        head.next = new Node(20,null);
        head = head.next;
        head.next = new Node(11, null);
        head = head.next;
        head.next = new Node(8, null);
        head = head.next;
        head.next = new Node(5, null);
        //System.out.print(root);
        System.out.print(maxSum(root));
    }

    private static int maxSum(Node head){
        Node startPointer = head;
        Node secondPointer = head;
        int length = 0;
        while(startPointer!=null){
            startPointer = startPointer.next;
            length++;
            //secondPointer = secondPointer.next.next;
        }
        //System.out.print("length: "+length);
        int i = 1;
        int j = length;
        int sum = Integer.MIN_VALUE;
        while(i<j) {
            sum = Math.max(sum,sumOfNode(head, i, j));
            i++;
            j--;
        }
        if(i==j){
            int counter = 1;
            Node temp = head;
            while(counter!=i){
                temp = temp.next;
                counter++;
            }
            sum = Math.max(sum,temp.data);
        }
        return sum;
    }

    private static int sumOfNode(Node head, int i, int j) {
        Node temp = head;
        int counter = 1;
        while(counter!=i){
            temp = temp.next;
            counter++;
        }
        int sum = temp.data;

        counter = 1;
        temp = head;
        while(counter!=j){
            temp = temp.next;
            counter++;
        }
        sum += temp.data;
      //  System.out.print(sum);
        return sum;
    }

    static class Node{
        int data;
        Node next;
        public Node(int data, Node next){
                this.data = data;
                this.next = next;

        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }
}