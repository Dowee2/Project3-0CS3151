package edu.westga.CS3151.AnimalGuessing.model;

import java.util.Iterator;
import java.util.Random;

public class Guesser {

    public enum YesOrNo {
        YES, NO
    }

    private BinaryTree<String> tree;
    private BinaryNode<String> currentNode;
    public boolean guessMade;


    public Guesser() {
    	
        this.tree = new BinaryTree<String>(this.initializeRoot());
        this.currentNode = this.tree.getRoot();
        
        if(this.currentNode.isLeafNode()) {
        	this.guessMade = true;
        } else {
        	this.guessMade = false;
        }
    }
    
	private BinaryNode<String> initializeRoot() {
		String[] startingAnimals = new String[] {"Cow", "Dolphin","Whale","EarthWorm","Kangaroo","Penguin","Rabbit","Cat","Horse"};
		Random rand = new Random();
		BinaryNode<String> node = new BinaryNode<String>(startingAnimals[rand.nextInt(startingAnimals.length)]);
		return node;
		
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
    
    public void guessCorrectly() {
    	this.currentNode = this.tree.getRoot();
    }

    public void guessedWrong(String playerAnimal, String question, YesOrNo answer) {
        BinaryNode<String> questionNode = new BinaryNode<String>(question);
        BinaryNode<String> answerNode = new BinaryNode<String>(playerAnimal);
        

        if(this.currentNode == this.tree.getRoot()) {
        	this.tree.setRoot(questionNode);
        } else {
        	
        	if(this.currentNode.getParent().getLeftChild() == this.currentNode) {
        		this.currentNode.getParent().setLeftChild(questionNode);
        	} else {
        		this.currentNode.getParent().setRightChild(questionNode);
        	}
        }
        
        switch (answer) {
        case YES:
      	  questionNode.setLeftChild(answerNode);
      	  questionNode.setRightChild(this.currentNode);
            break;
        
        case NO:
      	  questionNode.setLeftChild(this.currentNode);
      	  questionNode.setRightChild(answerNode);
            break;
    	}
        this.currentNode = this.tree.getRoot();
    }

    public String getCurrentValue() {
        return this.currentNode.getValue();
    }

    public String Iterate() {
    	String tree = "";
    	
    	 Iterator<BinaryNode<String>> iterate = this.tree.postOrderIterator();
         while(iterate.hasNext()) {
        	 BinaryNode<String> node = iterate.next();
        	 if(node.isLeafNode()) {
        		tree += "Answer: " + node.getValue() + System.lineSeparator();
        	 } else {
        		 tree += "Question: " + node.getValue() + System.lineSeparator();
        	 }
         }
    	return tree;
    }
    
}
