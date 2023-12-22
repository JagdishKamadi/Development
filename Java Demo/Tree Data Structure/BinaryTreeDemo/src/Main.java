import traversal.BuildTree;
import traversal.Node;

public class Main {
    public static void main(String[] args) {
        Integer[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BuildTree tree = new BuildTree();
        Node rootNode = BuildTree.createTree(nodes);

        /*
        System.out.println("Root node element is : " + rootNode.getData());
        System.out.println("Pre Order Traversal");
        tree.preOrder(rootNode);
        System.out.println("\n");

        System.out.println("In Order Traversal");
        tree.inOrder(rootNode);
        System.out.println("\n");

        System.out.println("Post Order Traversal");
        tree.postOrder(rootNode);
        System.out.println("\n");

        System.out.println("Level Order Traversal");
        tree.levelOrder(rootNode);
        System.out.println("\n");

        System.out.println("Count of node in Tree : " + tree.countNumberOfNode(rootNode));
        System.out.println("Count of node in Tree using other method: " + tree.countNumberOfNode2(rootNode));
         */

        System.out.println("Sum of node " + tree.sumOfTreeNode(rootNode));
    }
}