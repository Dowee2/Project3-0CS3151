package edu.westga.CS3151.AnimalGuessing.model; 

public class Guesser {

    public enum YesOrNo {
        YES, NO
    }

    public BinaryTree<String> tree;
    public BinaryNode<String> currentNode;


    public Guesser() {
        this.tree = new BinaryTree<String>();
        this.currentNode = this.tree.getRoot();
    }

    public void questionAnswered(YesOrNo answer) {
        switch (answer) {
            case YES:
            this.currentNode = this.currentNode.getLeftChild();
                break;
            
            case NO:
            this.currentNode = this.currentNode.getRightChild();
                break;
        }
    }

    public void guessedWrong(String playerAnimal, String question, YesOrNo answer) {
        BinaryNode<String> questionNode = new BinaryNode<String>(question);
        BinaryNode<String> answerNode = new BinaryNode<String>(playerAnimal);

        questionNode.setLeftChild(answerNode);
        questionNode.setRightChild(this.currentNode);
        BinaryNode<String> parentNode = this.currentNode.getParent();

        if(parentNode.getLeftChild() == this.currentNode) {
            parentNode.setLeftChild(questionNode);
            
        } else {
            parentNode.setRightChild(questionNode);
        }
    }

    public String getCurrentValue() {
        return this.currentNode.getValue();
    }
}
