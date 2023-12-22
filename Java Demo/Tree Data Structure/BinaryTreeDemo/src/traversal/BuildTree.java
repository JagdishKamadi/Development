package traversal;

import java.util.LinkedList;
import java.util.Queue;

public class BuildTree {

    private static int index = -1;
    private static int count = 0;

    public static Node createTree(Integer[] nodes) {
        index++;
//        {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1}
        // if element is -1 means value is null
        if (nodes[index] == -1) {
            return null;
        }

        Node node = new Node(nodes[index]);
        node.left = createTree(nodes);
        node.right = createTree(nodes);

        // we will return the root node here
        return node;
    }

    /**
     * preOrder traversal step
     * root
     * leftNode
     * rightNode
     *
     * @param node
     */
    public void preOrder(Node node) {

        if (node == null) {
            // if you want to print the null element you can print
            // we are skipping the null element
            return;
        }

        System.out.print(node.getData() + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * inOrder traversal step
     * leftNode
     * root
     * rightNode
     *
     * @param node
     */
    public void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.getData() + " ");
        inOrder(node.right);
    }

    /**
     * postOrder traversal step
     * leftNode
     * rightNode
     * root
     *
     * @param node
     */
    public void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.getData() + " ");
    }

    public void levelOrder(Node rootNode) {
        // check the base condition first
        if (rootNode == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        // push the root element first
        queue.add(rootNode);
        // push the line so we can get the next line
        queue.add(null);

        while (!queue.isEmpty()) {
            //if current is null we have to print the new line
            Node currentNode = queue.remove();

            if (currentNode == null) {
                System.out.println();
                if (queue.isEmpty()) {
                    break;
                } else {
                    // for the new line
                    queue.add(null);
                }
            } else {
                System.out.print(currentNode.getData() + " ");
                // if we print the current node data
                // then we have to store the current child node as well
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }

        }
    }


    // but this is not the right method
    // please refer the countNumberOfNode2 method
    public Integer countNumberOfNode(Node rootNode) {
        if (rootNode == null) {
            return 0;
        }

        // we are following the preorder approach to count the number of the nodes
        count++;
        countNumberOfNode(rootNode.left);
        countNumberOfNode(rootNode.right);

        return count;
    }

    public Integer countNumberOfNode2(Node rooNode) {
        if (rooNode == null) {
            return 0;
        }

        int leftNodeCount = countNumberOfNode2(rooNode.left);
        int rightNodeCount = countNumberOfNode2(rooNode.right);

        return leftNodeCount + rightNodeCount + 1;
    }

    public Integer sumOfTreeNode(Node rootNode) {
        if (rootNode == null) {
            return 0;
        }

        int leftSum = sumOfTreeNode(rootNode.left);
        int rightSum = sumOfTreeNode(rootNode.right);
        
        return leftSum + rightSum + rootNode.getData();
    }
}
