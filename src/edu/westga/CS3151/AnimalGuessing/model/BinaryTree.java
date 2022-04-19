package edu.westga.CS3151.AnimalGuessing.model;

import java.util.Iterator;
import java.util.Queue;
import java.util.ArrayDeque;

/**
 * BinaryTree
 *
 * @param <E> type of the node values
 * @author CS3151
 * @version Spring 2022
 */

public class BinaryTree<E> implements Iterable<E> {
	private BinaryNode<E> root;

	/**
	 * Instantiates an empty binary tree
	 *
	 * @pre none
	 * @post getRoot() == null
	 */
	public BinaryTree() {
		this.root = null;
	}

	/**
	 * Instantiates an new binary tree
	 *
	 * @pre root is the root node of a binary tree
	 * @post getRoot() == root
	 * @param root the new root of this tree
	 */
	public BinaryTree(BinaryNode<E> root) {
		this.root = root;
	}

	/**
	 * Returns the root node
	 * 
	 * @pre none
	 * @post none
	 * @return the root node of this tree
	 */
	public BinaryNode<E> getRoot() {
		return this.root;
	}

	/**
	 * Resets the root of this tree
	 * 
	 * @pre root is the root node of a binary tree
	 * @post getRoot() == root
	 * @param root the new root of this tree
	 */
	public void setRoot(BinaryNode<E> root) {
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
			new BinaryTree<E>(this.root.getLeftChild()).printInorder();
			System.out.print(this.root.getValue());
			new BinaryTree<E>(this.root.getRightChild()).printInorder();
		}	
	}
	
	/**
	 * Prints the node values of this tree in pre-order
	 * 
	 * @pre none
	 * @post none
	 */
	public void printPreorder() {
	}
	
	/**
	 * Prints the node values of this tree in post-order
	 * 
	 * @pre none
	 * @post none
	 */
	public void printPostorder() {
	}

	/**
	 * Returns an iterator that traverses this binary tree in level-order
	 * 
	 * @pre none
	 * @post none
	 * @return a level-order iterator
	 */
	@Override
	public Iterator<E> iterator() {
		return new LevelOrderIterator();
	}

	/**
	 * Returns an iterator that traverses this binary tree in in-order
	 * 
	 * @pre none
	 * @post none
	 * @return an in-order iterator
	 */
	public Iterator<E> inOrderIterator() {
		return new InOrderIterator();
	}

	/**
	 * Returns an iterator that traverses this binary tree in post-order
	 * 
	 * @pre none
	 * @post none
	 * @return a post-order iterator
	 */
	public Iterator<E> postOrderIterator() {
		return new PostOrderIterator();
	}

	/**
	 * Returns an iterator that traverses this binary tree in pre-order
	 * 
	 * @pre none
	 * @post none
	 * @return a pre-order iterator
	 */
	public Iterator<E> preOrderIterator() {
		return new PreOrderIterator();
	}

	/**
	 * Class LevelOrderIterator
	 * 
	 * An iterator that traverses this binary tree in level-order
	 */
	protected class LevelOrderIterator implements Iterator<E> {
		private Queue<BinaryNode<E>> nodeQueue;

		public LevelOrderIterator() {
			this.nodeQueue = new ArrayDeque<BinaryNode<E>>();
			this.nodeQueue.add(BinaryTree.this.root);
		}

		@Override
		public boolean hasNext() {
			return !this.nodeQueue.isEmpty();
		}

		@Override
		public E next() {
			BinaryNode<E> node = this.nodeQueue.remove();
			if (node.hasLeftChild()) {
				this.nodeQueue.add(node.getLeftChild());
			}
			if (node.hasRightChild()) {
				this.nodeQueue.add(node.getRightChild());
			}
			return node.getValue();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	/**
	 * Class InOrderIterator
	 * 
	 * An iterator that traverses this binary tree in in-order
	 */
	protected class InOrderIterator implements Iterator<E> {

		public InOrderIterator() {
		}
		
		@Override
		public boolean hasNext() {
			return false;
		}

		@Override
		public E next() {
			return null;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	/**
	 * Class PreOrderIterator
	 * 
	 * An iterator that traverses this binary tree in pre-order
	 */
	protected class PreOrderIterator implements Iterator<E> {

		public PreOrderIterator() {
		}
		
		@Override
		public boolean hasNext() {
			return false;
		}

		@Override
		public E next() {
			return null;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	/**
	 * Class PostOrderIterator
	 * 
	 * An iterator that traverses this binary tree in post-order
	 */
	protected class PostOrderIterator implements Iterator<E> {

		public PostOrderIterator() {
		}
		
		@Override
		public boolean hasNext() {
			return false;
		}

		@Override
		public E next() {
			return null;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
