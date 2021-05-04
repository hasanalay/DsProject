public class BinarySearchTree<AnyType> {
    private Node<AnyType> root;
    private Student studentInfo;


    public void insertRecursively(AnyType newValue) {
        root = insertRecursively(newValue, root);
    }

    private Node<AnyType> insertRecursively(AnyType newValue, Node<AnyType> tempNode) {
        this.studentInfo = (Student) newValue;
        if (tempNode == null)
            return new Node<>(null, this.studentInfo, null);

        if (this.studentInfo.getStudentId() < tempNode.data.getStudentId())
            tempNode.left = insertRecursively((AnyType) this.studentInfo, tempNode.left);
        else
            tempNode.right = insertRecursively((AnyType) this.studentInfo, tempNode.right);

        return tempNode;
    }

    public void printPreorder() {
        printPreorder(root);
    }

    private void printPreorder(Node<AnyType> tempNode) {
        if (tempNode == null)
            return;

        System.out.print(tempNode.data.toString());
        printPreorder(tempNode.left);
        printPreorder(tempNode.right);
    }

    public void printPostorder() {
        printPostorder(root);
    }

    private void printPostorder(Node<AnyType> tempNode) {
        if (tempNode == null)
            return;

        printPostorder(tempNode.left);
        printPostorder(tempNode.right);
        System.out.print(tempNode.data.toString());
    }

    public void printInorder() {
        printInorder(root);
    }

    private void printInorder(Node<AnyType> tempNode) {
        if (tempNode == null)
            return;

        printInorder(tempNode.left);
        System.out.print(tempNode.data.toString());
        printInorder(tempNode.right);
    }

    public boolean isEmpty() {

        return root == null;
    }

    // delete method
    void deleteRec(int data) {
        root = deleteRec(root, data);
    }


    Node deleteRec(Node<AnyType> root, int data) {

        if (root == null)
            return root;


        if (data < root.data.getStudentId())
            root.left = deleteRec(root.left, data);
        else if (data > root.data.getStudentId())
            root.right = deleteRec(root.right, data);


        else {

            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.data = minValue(root.right);
            root.right = deleteRec(root.right, root.data.getStudentId());
        }

        return root;
    }

    Student minValue(Node root) {
        int minv = root.data.getStudentId();
        while (root.left != null) {
            minv = root.left.data.getStudentId();
            root = root.left;
        }
        return root.data;
    }


    public void findNode(int x) {
        Node<AnyType> tempNode;

        tempNode = root;  ///ALWAYS START AT THE ROOT NODE

        int findControl = 0;
        while (tempNode != null) {
            if (x == tempNode.data.getStudentId()) {

                /// FOUND SEARCH VALUE IN BST
                System.out.println(tempNode.data.toString());
                System.out.println("TREE: LEVEL " + findControl);
                break;
            } else if (x < tempNode.data.getStudentId()) {
                tempNode = tempNode.left;
            } else {
                tempNode = tempNode.right;
            }
            findControl++;

        }
    }

    public static class Node<AnyType> {
        private Node<AnyType> left;
        private Student data;
        private Node<AnyType> right;


        public Node(Node<AnyType> l, Student d, Node<AnyType> r) {
            left = l;
            data = d;
            right = r;
        }

        public Node<AnyType> getLeft() {
            return left;
        }

        public void setLeft(Node<AnyType> left) {
            this.left = left;
        }

        public Student getData() {
            return data;
        }

        public void setData(Student data) {
            this.data = data;
        }

        public Node<AnyType> getRight() {
            return right;
        }

        public void setRight(Node<AnyType> right) {
            this.right = right;
        }
    }

}
