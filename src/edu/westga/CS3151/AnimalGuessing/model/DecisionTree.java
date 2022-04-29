package edu.westga.CS3151.AnimalGuessing.model;

import java.util.Iterator;

/**
 * BinaryTree
 *
 * @param <E> type of the node values
 * @author CS3151
 * @version Spring 2022
 */

public class DecisionTree<E> {
	private DecisionNode<E> root;

	/**
	 * Instantiates an empty binary tree
	 *
	 * @pre none
	 * @post getRoot() == null
	 */
	public DecisionTree() {
		this.root = null;
	}

	/**
	 * Instantiates an new binary tree
	 *
	 * @pre root is the root node of a binary tree
	 * @post getRoot() == root
	 * @param root the new root of this tree
	 */
	public DecisionTree(DecisionNode<E> root) {
		this.root = root;
	}

	/**
	 * Returns the root node
	 * 
	 * @pre none
	 * @post none
	 * @return the root node of this tree
	 */
	public DecisionNode<E> getRoot() {
		return this.root;
	}

	/**
	 * Resets the root of this tree
	 * 
	 * @pre root is the root node of a binary tree
	 * @post getRoot() == root
	 * @param root the new root of this tree
	 */
	public void setRoot(DecisionNode<E> root) {
		this.root = root;
	}

	/**
	 * Prints the node values of this tree in in-order
	 * 
	 * @pre none
	 * @post none
	 */
	public void printInorder() {
		if (this.root != null) {
			new DecisionTree<E>(this.root.getLeftChild()).printInorder();
			System.out.print(this.root.getValue());
			new DecisionTree<E>(this.root.getRightChild()).printInorder();
		}
	}

	/**
	 * Returns an iterator that traverses this binary tree in post-order
	 * 
	 * @pre none
	 * @post none
	 * @return a post-order iterator
	 */
	public Iterator<DecisionNode<E>> postOrderIterator() {
		return new PostOrderIterator();
	}

	/**
	 * Class PostOrderIterator
	 * 
	 * An iterator that traverses this binary tree in post-order
	 */
	protected class PostOrderIterator implements Iterator<DecisionNode<E>> {
		DecisionNode<E> next;

		public PostOrderIterator() {
			this.next = DecisionTree.this.getRoot();
			if (this.next != null) {
				while (this.next.hasLeftChild()) {
					this.next = this.next.getLeftChild();
				}
			}
		}

		@Override
		public boolean hasNext() {
			return this.next != null;
		}

		@Override
		public DecisionNode<E> next() {
			DecisionNode<E> returnValue = this.next;

			if (!this.next.hasParent()) {
				this.next = null;
			} else if (this.next.getParent().getRightChild() == this.next) {
				this.next = this.next.getParent();
			} else {
				if (this.next.getParent().hasRightChild()) {
					this.next = this.next.getParent().getRightChild();
					while (this.next.hasLeftChild()) {
						this.next = this.next.getLeftChild();
					}
				} else {
					this.next = this.next.getParent();
				}
			}
			return returnValue;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
