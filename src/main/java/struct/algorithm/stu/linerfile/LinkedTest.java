package struct.algorithm.stu.linerfile;

public class LinkedTest {
    private Node headNode;
    private Node rearNode;

    public LinkedTest() {
        this.headNode = new Node(0);
        rearNode = headNode;
    }

    public Node getHeadNode() {
        return headNode;
    }

    public Node getRearNode() {
        return rearNode;
    }

    public void addNode(int number){
        if (listByValue(number) != null)return;
        Node node = new Node(number);
        rearNode.next = node;
        rearNode = node;
        headNode.number++;
    }
    public void addDesignatedNode(int index, int number){
        Node lastNode = listByIndex(index);
        if (lastNode == null){
            addNode(number);
            return;
        }
        Node node = new Node(number);
        node.next = lastNode.next;
        lastNode.next = node;
    }
    public void deleteNode(int number){

    }
    public void alterNode(int originalValue, int presentValue){
        Node node = listByValue(originalValue);
        if (node == null){
            addNode(presentValue);
            return;
        }
        node.setNumber(presentValue);
    }

    @Override
    public String toString() {
        return "LinkedTest{" + getDescription(this, node -> node.toString()) + "}";
    }

    private Node listByValue(int number){//当前节点
        Node temp = headNode;
        while (temp != null){
            if (temp.number == number)break;
            temp = temp.next;
        }
        return temp;
    }
    private Node listByIndex(int index){//找的前一个节点
        Node temp = headNode;
        Node lastTemp = null;
        int count = 0;
        while (temp != null) {
            if (count == index - 1)break;
            count++;
            lastTemp = temp;
            temp = temp.next;
        }
        return lastTemp;
    }
    private String getDescription(LinkedTest linkedTest, IteratorTest iteratorTest){
        Node headNode = linkedTest.getHeadNode().next;
        String description = "";
        while (headNode != null) {
            description += iteratorTest.IteratingLinkedTable(headNode);
            headNode = headNode.next;
        }
        return description;
    }

    public class Node{
        private int number;
        private Node next;

        public Node(int number) {
            this.number = number;
        }
        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "number=" + number +
                    '}';
        }
    }
}
