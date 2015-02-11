package program1;

/**
 * @author Jeroen
 *
 */
public class Node {
	// single-linked circular linked-list, acting as a square tree

	// class variables
	private Node down = null;
	private Node right = null;
	private Value val;
	private int xIndex;
	private int yIndex;
	private boolean invalid;

	/**
	 * default constructor, only to be used if no other nodes have been
	 * initialized
	 * 
	 * @param v
	 */
	public Node(Value v) {
		invalid = false;
		setVal(v);
		setDown(this);
		setRight(this);

	}

	// ----------- Getters and Setters ---------------------------

	/**
	 * gets the x index
	 * 
	 * @return the xIndex
	 */
	public int getxIndex() {
		return xIndex;
	}

	/**
	 * sets the x index
	 * 
	 * @param xIndex
	 *            the xIndex to set
	 */
	public void setxIndex(int xIndex) {
		this.xIndex = xIndex;
	}

	/**
	 * gets the y index
	 * 
	 * @return the yIndex
	 */
	public int getyIndex() {
		return yIndex;
	}

	/**
	 * sets the y index
	 * 
	 * @param yIndex
	 *            the yIndex to set
	 */
	public void setyIndex(int yIndex) {
		this.yIndex = yIndex;
	}

	/**
	 * gets the down node
	 * 
	 * @return the down
	 */
	public Node getDown() {
		return down;
	}

	/**
	 * sets the down node
	 * 
	 * @param down
	 *            the down to set
	 */
	public void setDown(Node down) {
		this.down = down;
	}

	/**
	 * gets the right node
	 * 
	 * @return the right
	 */
	public Node getRight() {
		return right;
	}

	/**
	 * sets the right node
	 * 
	 * @param right
	 *            the right to set
	 */
	public void setRight(Node right) {
		this.right = right;
	}

	/**
	 * gets the value
	 * 
	 * @return the val
	 */
	public Value getVal() {
		return val;
	}

	/**
	 * sets the value
	 * 
	 * @param val
	 *            the val to set
	 */
	public void setVal(Value val) {

		if (val == null) {
			this.val = null;
			invalid = true;
		} else {
			this.val = val;
		}
	}
	/**
	 * @return the invalid
	 */
	public boolean isInvalid() {
		return invalid;
	}

	/**
	 * @param invalid
	 *            the invalid to set
	 */
	public void setInvalid(boolean invalid) {
		this.invalid = invalid;
	}

	/**
	 * simple equals method checking if nodes are equal
	 * 
	 * @param other
	 *            node to be compared to
	 * @return boolean value indicating equality
	 */
	public boolean equals(Node other) {
		if (this.invalid || other.invalid) {
			System.out.println("One of the nodes is invalid. Cannot compare.");
			return false;
		}
		return (this.val.getDval() == other.getVal().getDval()
				&& this.val.getSval().equals(other.getVal().getSval())
				&& this.xIndex == other.xIndex && this.yIndex == other.yIndex);
	}
}
