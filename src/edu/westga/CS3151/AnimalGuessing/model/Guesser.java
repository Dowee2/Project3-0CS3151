package edu.westga.CS3151.AnimalGuessing.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class Guesser {

	public enum YesOrNo {
		YES, NO
	}

	private DecisionTree<String> tree;
	private DecisionNode<String> currentNode;
	public boolean guessMade;

	/**
	 * Instantiates a new guesser.
	 */
	public Guesser() {

		this.tree = new DecisionTree<String>(this.initializeRoot());
		this.currentNode = this.tree.getRoot();

		if (this.currentNode.isLeafNode()) {
			this.guessMade = true;
		} else {
			this.guessMade = false;
		}
	}

	private DecisionNode<String> initializeRoot() {
		String[] startingAnimals = new String[] { "Cow", "Dolphin", "Whale", "EarthWorm", "Kangaroo", "Penguin",
				"Rabbit", "Cat", "Horse" };
		Random rand = new Random();
		DecisionNode<String> node = new DecisionNode<String>(startingAnimals[rand.nextInt(startingAnimals.length)]);
		return node;

	}

	/**
	 * Handle if to move left or right down the tree.
	 *
	 * @param answer the answer
	 * @return true if currentNode is a leafNode
	 */
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
		this.guessMade = false;
	}

	/**
	 * Adds user .
	 *
	 * @param playerAnimal The animal the player was thinking of
	 * @param question     The question that helps identify playerAnimal
	 * @param answer       the answer
	 */
	public void guessedWrong(String playerAnimal, String question, YesOrNo answer) {
		DecisionNode<String> questionNode = new DecisionNode<String>(question);
		DecisionNode<String> answerNode = new DecisionNode<String>(playerAnimal);

		if (this.currentNode == this.tree.getRoot()) {
			this.tree.setRoot(questionNode);
		} else {

			if (this.currentNode.getParent().getLeftChild() == this.currentNode) {
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
		this.guessMade = false;
	}

	/**
	 * Gets the current value.
	 *
	 * @return the current value
	 */
	public String getCurrentValue() {
		return this.currentNode.getValue();
	}

	/**
	 * Using PostOrder Traversal returns a string representation of the tree
	 *
	 * @return The tree in string form
	 */
	private String makeSaveable() {
		String tree = "";

		Iterator<DecisionNode<String>> iterate = this.tree.postOrderIterator();
		while (iterate.hasNext()) {
			DecisionNode<String> node = iterate.next();
			if (node.isLeafNode()) {
				tree += "Answer: " + node.getValue();
			} else {
				tree += "Question: " + node.getValue();
			}

			if (iterate.hasNext()) {
				tree += System.lineSeparator();
			}
		}
		return tree;
	}

	/**
	 * Save text to file.
	 *
	 * @param file the file
	 */
	public void saveTree(File file) {
		try (PrintWriter writer = new PrintWriter(file)) {
			writer.println(this.makeSaveable());
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Builds the binary tree from a file made from postorder Traversal.
	 *
	 * @param file the file
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void buildBinaryTree(File file) throws IOException {
		Stack<DecisionNode<String>> stack = new Stack<DecisionNode<String>>();
		try {
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				if (line.contains(":")) {
					String[] test = line.split(":");
					DecisionNode<String> node = new DecisionNode<String>(test[1]);
					if (test[0].equals("Question")) {
						this.buildBinaryRelationship(stack, node);
					} else {
						stack.push(node);
					}
				}
			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		this.guessMade = false;
		this.tree.setRoot(stack.pop());
		this.currentNode = this.tree.getRoot();
	}

	private void buildBinaryRelationship(Stack<DecisionNode<String>> stack, DecisionNode<String> questionNode) {
		questionNode.setRightChild(stack.pop());
		questionNode.setLeftChild(stack.pop());
		stack.push(questionNode);
	}

}
