package edu.westga.CS3151.AnimalGuessing.model; 

public class Guesser {

    public enum YesOrNo {
        YES, NO
    }

    private BinaryTree<String> tree;
    private BinaryNode<String> currentNode;


    public Guesser() {
        this.tree = new BinaryTree<String>();
        this.currentNode = this.tree.getRoot();
    }

    public Boolean questionAnswered(YesOrNo answer) {
        switch (answer) {
            case YES:
            this.currentNode = this.currentNode.getLeftChild();
                break;
            
            case NO:
            this.currentNode = this.currentNode.getRightChild();
                break;
        }

        return this.currentNode.isLeafNode();
    }

    public void guessedWrong(String playerAnimal, String question, YesOrNo answer) {
        BinaryNode<String> questionNode = new BinaryNode<String>(question);
        BinaryNode<String> answerNode = new BinaryNode<String>(playerAnimal);

        questionNode.setLeftChild(answerNode);
        questionNode.setRightChild(this.currentNode);
        BinaryNode<String> parentNode = this.currentNode.getParent();

        switch (answer) {
            case YES:
            parentNode.setLeftChild(questionNode);
                break;
            
            case NO:
            parentNode.setRightChild(questionNode);
                break;
        }
        this.currentNode = this.tree.getRoot();
    }

    public String getCurrentValue() {
        return this.currentNode.getValue();
    }

    
}
