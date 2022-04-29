package edu.westga.CS3151.AnimalGuessing.model;

/**
 * BinaryNode - one node in a binary tree
 *
 * @param <T> type of node value
 * @author CS3151
 * @version Spring 2022
 */
public class DecisionNode<T> {
	private T value;
	private DecisionNode<T> leftChild;
	private DecisionNode<T> rightChild;
	private DecisionNode<T> parent;

	/**
	 * Instantiates a new binary node
	 * 
	 * @pre none
	 * @post getValue() == null AND !hasLeftChild() AND !hasRightChild() AND
	 *       !hasParent()
	 */
	public DecisionNode() {
		this(null);
	}

	/**
	 * Instantiates a new binary node
	 *
	 * @pre none
	 * @post getValue() == value AND !hasLeftChild() AND !hasRightChild() AND
	 *       !hasParent()
	 * @param value the value of the new node
	 */
	public DecisionNode(T value) {
		this.value = value;
		this.leftChild = null;
		this.rightChild = null;
		this.parent = null;
		
	}

	/**
	 * Returns the left child node
	 * 
	 * @pre none
	 * @post none
	 * @return returns the left child of this node
	 */
	public DecisionNode<T> getLeftChild() {
		return this.leftChild;
	}

	/**
	 * Returns the right child node
	 * 
	 * @pre none
	 * @post none
	 * @return returns the right child of this node
	 */
	public DecisionNode<T> getRightChild() {
		return this.rightChild;
	}

	/**
	 * Returns the parent
	 * 
	 * @pre none
	 * @post none
	 * @return returns the parent of this node
	 */
	public DecisionNode<T> getParent() {
		return this.parent;
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
	 * Sets the left child
	 * 
	 * @pre none
	 * @post getLeftChild() == child
	 * @param child the new left child of this node
	 */
	public void setLeftChild(DecisionNode<T> child) {
		this.leftChild = child;
		child.parent = this;
	}

	/**
	 * Sets the right child
	 *
	 * @pre none
	 * @post getRightChild() == child
	 * @param child the new right child of this node
	 */
	public void setRightChild(DecisionNode<T> child) {
		this.rightChild = child;
		child.parent = this;
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

	/**
	 * Checks if this node has a parent
	 *
	 * @pre none
	 * @post none
	 * @return true if this node has a parent
	 */
	public boolean hasParent() {
		return this.parent != null;
	}

	/**
	 * Checks if this node is a leaf node
	 * 
	 * @pre none
	 * @post none
	 * 
	 * @return true if this node has no children
	 */
	public boolean isLeafNode() {
		return !this.hasLeftChild() && !this.hasRightChild();
	}
}



