package edu.westga.CS3151.AnimalGuessing.model;


/**
 * BinaryNode - one node in a binary tree
 *
 * @param <T> type of node value
 * @author CS3151
 * @version Spring 2022
 */
public class BinaryNode<T> {
	private T value;
	private BinaryNode<T> leftChild;
	private BinaryNode<T> rightChild;

	/**
	 * Instantiates a new binary node
	 * 
	 * @pre none
	 * @post getValue() == null AND !hasLeftChild() AND !hasRightChild()
	 */
	public BinaryNode() {
		this(null);
	}

	/**
	 * Instantiates a new binary node
	 *
	 * @pre none
	 * @post getValue() == value AND !hasLeftChild() AND !hasRightChild()
	 * @param value the value of the new node
	 */
	public BinaryNode(T value) {
		this.value = value;
		this.leftChild = null;
		this.rightChild = null;
	}

	/**
	 * Returns the left child node
	 * 
	 * @pre none
	 * @post none
	 * @return returns the left child of this node
	 */
	public BinaryNode<T> getLeftChild() {
		return this.leftChild;
	}

	/**
	 * Returns the right child node
	 * 
	 * @pre none
	 * @post none
	 * @return returns the right child of this node
	 */
	public BinaryNode<T> getRightChild() {
		return this.rightChild;
	}

	/**
	 * Returns the value
	 * 
	 * @pre none
	 * @post none
	 * @return returns the value of this node
	 */
	public T getValue() {
		return this.value;
	}

	/**
	 * Returns if this node is a leaf node
	 * 
	 * @return returns if this node is a leaf
	 */
	public boolean isLeaf() {
		return this.hasLeftChild() && this.hasRightChild();
	}

	/**
	 * Sets the left child
	 * 
	 * @pre none
	 * @post getLeftChild() == child
	 * @param child the new left child of this node
	 */
	public void setLeftChild(BinaryNode<T> child) {
		this.leftChild = child;
	}

	/**
	 * Sets the right child
	 *
	 * @pre none
	 * @post getRightChild() == child
	 * @param child the new right child of this node
	 */
	public void setRightChild(BinaryNode<T> child) {
		this.rightChild = child;
	}

	/**
	 * Sets the node value
	 *
	 * @pre none
	 * @post getValue() == value
	 * @param value the new value of this node
	 */
	public void setValue(T value) {
		this.value = value;
	}

	/**
	 * Checks if this node has a left child
	 *
	 * @pre none
	 * @post none
	 * @return true if this node has a left child
	 */
	public boolean hasLeftChild() {
		return this.leftChild != null;
	}

	/**
	 * Checks if this node has a right child
	 *
	 * @pre none
	 * @post none
	 * @return true if this node has a right child
	 */
	public boolean hasRightChild() {
		return this.rightChild != null;
	}
}

