package program1;

import java.util.Scanner;

/**
 * This class is the core of the first program
 * 
 * @author Jeroen
 * 
 *         *******------____ Minimum size = 1,1____------*********
 */

public class Grid {
	// class variable
	private int width;
	private int length;
	private Node head;

	/**
	 * constructor
	 * 
	 * @param x
	 *            width
	 * @param y
	 *            depth
	 */
	public Grid(int x, int y) {
		setWidth(x);
		setLength(y);
		if (x > 0 && y > 0) {
			head = new Node(new Value("\""));
			for (int i = 0; i < x; i++) {
				insertColumn(1);
			}
			for (int i = 0; i < y; i++) {
				insertRow(1);
			}
		} else {
			System.out
					.println("can't instantiate a grid with these parameters!!! Quitting.");
			System.exit(1);
		}
	}

	/**
	 * prints the grid
	 */
	public void print() {
		System.out.println();
		// print row of col#'s
		String top = "    \t";
		for (int i = 0; i < width; i++) {
			top += String.format("%15s", "col" + i);
		}
		System.out.println(top);
		// print the rest
		for (int j = 0; j < length; j++) {
			String t = "\t";
			for (int i = 0; i < width; i++) {
				if (getNodeAt(i, j).getVal() != null) {
					t += getNodeAt(i, j).getVal().toString();
				} else {
					t += String.format("%15s", "");
				}
			}
			System.out.println("Row" + j + t);
		}
		System.out.println();
	}

	/**
	 * gets the node at a certain x-y coordinate
	 * 
	 * @precondition x and y must be within range
	 * @param x
	 *            index
	 * @param y
	 *            index
	 * @return Node at x,y
	 */
	private Node getNodeAt(int x, int y) {
		Node ret = null;
		if (x >= width || x < 0 || y >= length || y < 0) {
			return ret;
		} else {
			ret = head; // set ret to head of grid
			// move over x to the right
			for (int i = 0; i < x; i++) {
				ret = ret.getRight();
			}
			// move over y to the bottom
			for (int i = 0; i < y; i++) {
				ret = ret.getDown();
			}
			return ret;
		}
	}

	// -----------------------------------
	/**
	 * gets the width
	 * 
	 * @return the width
	 */

	public int getWidth() {
		return width;
	}

	/**
	 * sets the width
	 * 
	 * @param width
	 * 
	 *            the width to set
	 */

	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * gets the length
	 * 
	 * @return the length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * sets the length
	 * 
	 * @param length
	 * 
	 *            the length to set
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * Fills the grid according to provided dimensions
	 */
	public void fill() {
		Scanner scan = new Scanner(System.in);
		System.out.println("From row:");
		int y1 = Integer.valueOf(scan.nextLine());
		while (y1 < 0 || y1 > length - 1) {
			System.out
					.println("Invalid x coordinate. Choose a number between 0 and "
							+ (length - 1));
			y1 = Integer.valueOf(scan.nextLine());
		}
		System.out.println("From column:");
		int x1 = Integer.valueOf(scan.nextLine());
		while (x1 < 0 || x1 > width - 1) {
			System.out
					.println("Invalid y coordinate. Choose a number between 0 and "
							+ (width - 1));
			x1 = Integer.valueOf(scan.nextLine());
		}
		System.out.println("To row:");
		int y2 = Integer.valueOf(scan.nextLine());
		while (y2 < 0 || y2 > length - 1) {
			System.out
					.println("Invalid x coordinate. Choose a number between 0 and "
							+ (length - 1));
			y2 = Integer.valueOf(scan.nextLine());
		}
		System.out.println("To column:");
		int x2 = Integer.valueOf(scan.nextLine());
		while (x2 < 0 || x2 > width - 1) {
			System.out
					.println("Invalid x coordinate. Choose a number between 0 and "
							+ (width - 1));
			x2 = Integer.valueOf(scan.nextLine());
		}
		System.out.println("With value:");
		String val = scan.nextLine();
		double d = 0;
		boolean dbl = true;
		boolean decent = false;
		while (!decent) {
			try {
				d = Double.valueOf(val);
				decent = true;
			} catch (Exception e) {
				if (!val.startsWith("\"")) {
					System.out
							.println("Invalid value. Please enter something ");
					val = scan.nextLine();
				} else {
					dbl = false;
					decent = true;
				}
			}
		}
		for (int i = x1; i <= x2; i++) {
			for (int j = y1; j <= y2; j++) {
				if (dbl) {
					assignCell(i, j, new Value(d));
				} else {
					assignCell(i, j, new Value(val));
				}
			}
		}
	}

	private void assignCell(int i, int j, Value value) {
		// get to the right node
		getNodeAt(i, j).setVal(value);
	}

	/**
	 * adds cells as per user input
	 */
	public void addCells() {
		Scanner scan = new Scanner(System.in);
		System.out.println("First row:");
		int x1 = Integer.valueOf(scan.nextLine());
		while (x1 < 0 || x1 > length - 1) {
			System.out
					.println("Invalid x coordinate. Choose a number between 0 and "
							+ (length - 1));
			x1 = Integer.valueOf(scan.nextLine());
		}
		System.out.println("First column:");
		int y1 = Integer.valueOf(scan.nextLine());
		while (y1 < 0 || y1 > width - 1) {
			System.out
					.println("Invalid x coordinate. Choose a number between 0 and "
							+ (width - 1));
			y1 = Integer.valueOf(scan.nextLine());
		}
		System.out.println("Second row:");
		int x2 = Integer.valueOf(scan.nextLine());
		while (x2 < 0 || x2 > length - 1) {
			System.out
					.println("Invalid x coordinate. Choose a number between 0 and "
							+ (length - 1));
			x2 = Integer.valueOf(scan.nextLine());
		}
		System.out.println("Second column:");
		int y2 = Integer.valueOf(scan.nextLine());
		while (y2 < 0 || y2 > width - 1) {
			System.out
					.println("Invalid x coordinate. Choose a number between 0 and "
							+ (width - 1));
			y2 = Integer.valueOf(scan.nextLine());
		}
		System.out.println("Target row:");
		int z1 = Integer.valueOf(scan.nextLine());
		while (z1 < 0 || z1 > length - 1) {
			System.out
					.println("Invalid x coordinate. Choose a number between 0 and "
							+ (length - 1));
			z1 = Integer.valueOf(scan.nextLine());
		}
		System.out.println("Target column:");
		int z2 = Integer.valueOf(scan.nextLine());
		while (z2 < 0 || z2 > width - 1) {
			System.out
					.println("Invalid x coordinate. Choose a number between 0 and "
							+ (width - 1));
			z2 = Integer.valueOf(scan.nextLine());
		}
		addCells(y1, x1, y2, x2, z2, z1);
	}

	private void addCells(int f1, int f2, int s1, int s2, int t1, int t2) {
		Node n1 = getNodeAt(f1, f2);
		Node n2 = getNodeAt(s1, s2);
		Node n3 = getNodeAt(t1, t2);
		// node reference set to point to right nodes

		if (!(n1.isInvalid() || n2.isInvalid()
				|| n1.getVal().getTag().equals("STR") || n2.getVal().getTag()
				.equals("STR"))) {
			// error case
			// n3.setVal(null); //nothing gets done if it's an illegal case..
			// } else {
			double v = n1.getVal().getDval() + n2.getVal().getDval();
			n3.setVal(new Value(v));
		}
	}

	/**
	 * multiplies cells as per user input
	 */
	public void multiplyCells() {
		Scanner scan = new Scanner(System.in);
		System.out.println("First row:");
		int x1 = Integer.valueOf(scan.nextLine());
		while (x1 < 0 || x1 > width - 1) {
			System.out
					.println("Invalid x coordinate. Choose a number between 0 and "
							+ (width - 1));
			x1 = Integer.valueOf(scan.nextLine());
		}
		System.out.println("First column:");
		int y1 = Integer.valueOf(scan.nextLine());
		while (y1 < 0 || y1 > length - 1) {
			System.out
					.println("Invalid x coordinate. Choose a number between 0 and "
							+ (length - 1));
			y1 = Integer.valueOf(scan.nextLine());
		}
		System.out.println("Second row:");
		int x2 = Integer.valueOf(scan.nextLine());
		while (x2 < 0 || x2 > width - 1) {
			System.out
					.println("Invalid x coordinate. Choose a number between 0 and "
							+ (width - 1));
			x2 = Integer.valueOf(scan.nextLine());
		}
		System.out.println("Second column:");
		int y2 = Integer.valueOf(scan.nextLine());
		while (y2 < 0 || y2 > length - 1) {
			System.out
					.println("Invalid x coordinate. Choose a number between 0 and "
							+ (length - 1));
			y2 = Integer.valueOf(scan.nextLine());
		}
		System.out.println("Target row:");
		int z1 = Integer.valueOf(scan.nextLine());
		while (z1 < 0 || z1 > width - 1) {
			System.out
					.println("Invalid x coordinate. Choose a number between 0 and "
							+ (width - 1));
			z1 = Integer.valueOf(scan.nextLine());
		}
		System.out.println("Target column:");
		int z2 = Integer.valueOf(scan.nextLine());
		while (z2 < 0 || z2 > length - 1) {
			System.out
					.println("Invalid x coordinate. Choose a number between 0 and "
							+ (length - 1));
			z2 = Integer.valueOf(scan.nextLine());
		}
		multiplyCells(x1, y1, x2, y2, z1, z2);
	}

	private void multiplyCells(int y1, int x1, int y2, int x2, int z2, int z1) {
		Node n1 = getNodeAt(y1, x1);
		Node n2 = getNodeAt(y2, x2);
		Node n3 = getNodeAt(z2, z1);
		// node reference set to point to right nodes
		if (!(n1.isInvalid() || n2.isInvalid()
				|| n1.getVal().getTag().equals("STR") || n2.getVal().getTag()
				.equals("STR"))) {
			// error case
			// n3.setVal(null);
			// } else {
			double v = n1.getVal().getDval() * n2.getVal().getDval();
			n3.setVal(new Value(v));
		}
	}

	/**
	 * adds rows as per user input
	 */
	public void addRows() {
		Scanner scan = new Scanner(System.in);
		System.out.println("First row:");
		int r1 = Integer.valueOf(scan.nextLine());
		while (r1 < 0 || r1 > length - 1) {
			System.out
					.println("Invalid y coordinate. Choose a number between 0 and "
							+ (length - 1));
			r1 = Integer.valueOf(scan.nextLine());
		}
		System.out.println("Second row:");
		int r2 = Integer.valueOf(scan.nextLine());
		while (r2 < 0 || r2 > length - 1) {
			System.out
					.println("Invalid y coordinate. Choose a number between 0 and "
							+ (length - 1));
			r2 = Integer.valueOf(scan.nextLine());
		}
		System.out.println("Target row:");
		int r3 = Integer.valueOf(scan.nextLine());
		while (r3 < 0 || r3 > length - 1) {
			System.out
					.println("Invalid y coordinate. Choose a number between 0 and "
							+ (length - 1));
			r3 = Integer.valueOf(scan.nextLine());
		}
		// values set
		for (int i = 0; i < width; i++) {
			addCells(i, r1, i, r2, i, r3);// subtract each cell and put
			// corresponding results in
			// right cell
		}
	}

	/**
	 * multiplies rows as per user input
	 */
	public void multiplyRows() {
		Scanner scan = new Scanner(System.in);
		System.out.println("First row:");
		int x1 = Integer.valueOf(scan.nextLine());
		while (x1 < 0 || x1 > length - 1) {
			System.out
					.println("Invalid y coordinate. Choose a number between 0 and "
							+ (length - 1));
			x1 = Integer.valueOf(scan.nextLine());
		}
		System.out.println("Second row:");
		int y1 = Integer.valueOf(scan.nextLine());
		while (y1 < 0 || y1 > length - 1) {
			System.out
					.println("Invalid y coordinate. Choose a number between 0 and "
							+ (length - 1));
			y1 = Integer.valueOf(scan.nextLine());
		}
		System.out.println("Target row:");
		int x2 = Integer.valueOf(scan.nextLine());
		while (x2 < 0 || x2 > length - 1) {
			System.out
					.println("Invalid y coordinate. Choose a number between 0 and "
							+ (length - 1));
			x2 = Integer.valueOf(scan.nextLine());
		}
		// values set
		for (int i = 0; i < width; i++) {
			multiplyCells(i, x1, i, y1, i, x2);// subtract each cell and put
			// corresponding results in
			// right cell
		}
	}

	/**
	 * adds columns as per user input
	 */
	public void addColumns() {
		Scanner scan = new Scanner(System.in);
		System.out.println("First column:");
		int x1 = Integer.valueOf(scan.nextLine());
		while (x1 < 0 || x1 > width - 1) {
			System.out
					.println("Invalid y coordinate. Choose a number between 0 and "
							+ (width - 1));
			x1 = Integer.valueOf(scan.nextLine());
		}
		System.out.println("Second column:");
		int y1 = Integer.valueOf(scan.nextLine());
		while (y1 < 0 || y1 > width - 1) {
			System.out
					.println("Invalid y coordinate. Choose a number between 0 and "
							+ (width - 1));
			y1 = Integer.valueOf(scan.nextLine());
		}
		System.out.println("Target column:");
		int x2 = Integer.valueOf(scan.nextLine());
		while (x2 < 0 || x2 > width - 1) {
			System.out
					.println("Invalid y coordinate. Choose a number between 0 and "
							+ (width - 1));
			x2 = Integer.valueOf(scan.nextLine());
		}
		// values set
		for (int i = 0; i < length; i++) {
			addCells(x1, i, y1, i, x2, i);// subtract each cell and put
			// corresponding results in the right cell
		}
	}

	/**
	 * multiplies columns as per user input
	 */
	public void multiplyColumns() {
		Scanner scan = new Scanner(System.in);
		System.out.println("First column:");
		int x1 = Integer.valueOf(scan.nextLine());
		while (x1 < 0 || x1 > width - 1) {
			System.out
					.println("Invalid y coordinate. Choose a number between 0 and "
							+ (width - 1));
			x1 = Integer.valueOf(scan.nextLine());
		}
		System.out.println("Second column:");
		int y1 = Integer.valueOf(scan.nextLine());
		while (y1 < 0 || y1 > width - 1) {
			System.out
					.println("Invalid y coordinate. Choose a number between 0 and "
							+ (width - 1));
			y1 = Integer.valueOf(scan.nextLine());
		}
		System.out.println("Target column:");
		int x2 = Integer.valueOf(scan.nextLine());
		while (x2 < 0 || x2 > width - 1) {
			System.out
					.println("Invalid y coordinate. Choose a number between 0 and "
							+ (width - 1));
			x2 = Integer.valueOf(scan.nextLine());
		}
		// values set
		for (int i = 0; i < length; i++) {
			multiplyCells(x1, i, y1, i, x2, i);// subtract each cell and put
			// corresponding results in right cell
		}
	}

	/**
	 * assigns a cell a certain value
	 */
	public void assignCell() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Column:");
		int x = Integer.valueOf(scan.nextLine());
		while (x < 0 || x > width - 1) {
			System.out
					.println("Invalid x coordinate. Choose a number between 0 and "
							+ (width - 1));
			x = Integer.valueOf(scan.nextLine());
		}
		System.out.println("Row:");
		int y = Integer.valueOf(scan.nextLine());
		while (y < 0 || x > length - 1) {
			System.out
					.println("Invalid x coordinate. Choose a number between 0 and "
							+ (length - 1));
			y = Integer.valueOf(scan.nextLine());
		}
		System.out.println("Value:");
		String newVal = "";
		double dval = -144;
		boolean dbl = false;
		boolean cont = false;
		while (!cont) {
			newVal = scan.nextLine();
			try {
				dval = Double.valueOf(newVal);
				dbl = true;
				cont = true;
			} catch (Exception e) {

				if (!newVal.startsWith("\"")) {
					System.out
							.println("sorry, you have to insert an actual valid input. Either enter a number value or a string starting with \"");
				} else {
					cont = true;
				}
			}
		}
		// get to the right node
		Node curr = head;
		for (int i = 0; i < x; i++) {
			// move across
			curr = curr.getRight();
		}
		for (int j = 0; j < y; j++) {
			// move down
			curr = curr.getDown();
		}
		if (dbl) {
			curr.setVal(new Value(dval));
		} else {
			curr.setVal(new Value(newVal));
		}
	}

	/**
	 * numbers the cells horizontally first, then moves down row by row,
	 * starting at the value 0.0000
	 */
	public void number() {
		Scanner scan = new Scanner(System.in);
		System.out.println("From row:");
		int x1 = Integer.valueOf(scan.nextLine());
		while (x1 < 0 || x1 > length - 1) {
			System.out
					.println("Invalid x coordinate. Choose a number between 0 and "
							+ (length - 1));
			x1 = Integer.valueOf(scan.nextLine());
		}
		System.out.println("From column:");
		int y1 = Integer.valueOf(scan.nextLine());
		while (y1 < 0 || y1 > width - 1) {
			System.out
					.println("Invalid x coordinate. Choose a number between 0 and "
							+ (width - 1));
			y1 = Integer.valueOf(scan.nextLine());
		}
		System.out.println("To row:");
		int x2 = Integer.valueOf(scan.nextLine());
		while (x2 < 0 || x2 > length - 1) {
			System.out
					.println("Invalid x coordinate. Choose a number between 0 and "
							+ (length - 1));
			x2 = Integer.valueOf(scan.nextLine());
		}
		System.out.println("To column:");
		int y2 = Integer.valueOf(scan.nextLine());
		while (y2 < 0 || y2 > width - 1) {
			System.out
					.println("Invalid x coordinate. Choose a number between 0 and "
							+ (width - 1));
			y2 = Integer.valueOf(scan.nextLine());
		}
		int count = 0;
		for (int j = x1; j <= x2; j++) {// rows
			for (int i = y1; i <= y2; i++) {// columns
				assignCell(i, j, new Value(count));
				count++;
			}
		}
	}

	/**
	 * subtracts cells as per user input
	 */
	public void subtractCells() {
		Scanner scan = new Scanner(System.in);
		System.out.println("First row:");
		int x1 = Integer.valueOf(scan.nextLine());
		while (x1 < 0 || x1 > length - 1) {
			System.out
					.println("Invalid x coordinate. Choose a number between 0 and "
							+ (length - 1));
			x1 = Integer.valueOf(scan.nextLine());
		}
		System.out.println("First column:");
		int y1 = Integer.valueOf(scan.nextLine());
		while (y1 < 0 || y1 > width - 1) {
			System.out
					.println("Invalid x coordinate. Choose a number between 0 and "
							+ (width - 1));
			y1 = Integer.valueOf(scan.nextLine());
		}
		System.out.println("Second row:");
		int x2 = Integer.valueOf(scan.nextLine());
		while (x2 < 0 || x2 > length - 1) {
			System.out
					.println("Invalid x coordinate. Choose a number between 0 and "
							+ (length - 1));
			x2 = Integer.valueOf(scan.nextLine());
		}
		System.out.println("Second column:");
		int y2 = Integer.valueOf(scan.nextLine());
		while (y2 < 0 || y2 > width - 1) {
			System.out
					.println("Invalid x coordinate. Choose a number between 0 and "
							+ (width - 1));
			y2 = Integer.valueOf(scan.nextLine());
		}
		System.out.println("Target row:");
		int z1 = Integer.valueOf(scan.nextLine());
		while (z1 < 0 || z1 > length - 1) {
			System.out
					.println("Invalid x coordinate. Choose a number between 0 and "
							+ (length - 1));
			z1 = Integer.valueOf(scan.nextLine());
		}
		System.out.println("Target column:");
		int z2 = Integer.valueOf(scan.nextLine());
		while (z2 < 0 || z2 > width - 1) {
			System.out
					.println("Invalid x coordinate. Choose a number between 0 and "
							+ (width - 1));
			z2 = Integer.valueOf(scan.nextLine());
		}
		subtractCells(x1, y1, x2, y2, z1, z2);
	}

	private void subtractCells(int y1, int x1, int y2, int x2, int z2, int z1) {
		Node n1 = getNodeAt(y1, x1);
		Node n2 = getNodeAt(y2, x2);
		Node n3 = getNodeAt(z2, z1);
		// node reference set to point to right nodes
		if (!(n1.isInvalid() || n2.isInvalid()
				|| n1.getVal().getTag().equals("STR") || n2.getVal().getTag()
				.equals("STR"))) {
			// error case
			// n3.setVal(null);
			// } else {
			double v = n1.getVal().getDval() - n2.getVal().getDval();
			n3.setVal(new Value(v));
		}
	}

	/**
	 * divides cells as per user input
	 */
	public void divideCells() {
		Scanner scan = new Scanner(System.in);
		System.out.println("First row:");
		int x1 = Integer.valueOf(scan.nextLine());
		while (x1 < 0 || x1 > length - 1) {
			System.out
					.println("Invalid x coordinate. Choose a number between 0 and "
							+ (length - 1));
			x1 = Integer.valueOf(scan.nextLine());
		}
		System.out.println("First column:");
		int y1 = Integer.valueOf(scan.nextLine());
		while (y1 < 0 || y1 > width - 1) {
			System.out
					.println("Invalid x coordinate. Choose a number between 0 and "
							+ (width - 1));
			y1 = Integer.valueOf(scan.nextLine());
		}
		System.out.println("Second row:");
		int x2 = Integer.valueOf(scan.nextLine());
		while (x2 < 0 || x2 > length - 1) {
			System.out
					.println("Invalid x coordinate. Choose a number between 0 and "
							+ (length - 1));
			x2 = Integer.valueOf(scan.nextLine());
		}
		System.out.println("Second column:");
		int y2 = Integer.valueOf(scan.nextLine());
		while (y2 < 0 || y2 > width - 1) {
			System.out
					.println("Invalid x coordinate. Choose a number between 0 and "
							+ (width - 1));
			y2 = Integer.valueOf(scan.nextLine());
		}
		System.out.println("Target row:");
		int z1 = Integer.valueOf(scan.nextLine());
		while (z1 < 0 || z1 > length - 1) {
			System.out
					.println("Invalid x coordinate. Choose a number between 0 and "
							+ (length - 1));
			z1 = Integer.valueOf(scan.nextLine());
		}
		System.out.println("Target column:");
		int z2 = Integer.valueOf(scan.nextLine());
		while (z2 < 0 || z2 > width - 1) {
			System.out
					.println("Invalid x coordinate. Choose a number between 0 and "
							+ (width - 1));
			z2 = Integer.valueOf(scan.nextLine());
		}
		divideCells(x1, y1, x2, y2, z1, z2);
	}

	private void divideCells(int y1, int x1, int y2, int x2, int z2, int z1) {
		Node n1 = getNodeAt(y1, x1);
		Node n2 = getNodeAt(y2, x2);
		Node n3 = getNodeAt(z2, z1);
		// node reference set to point to right nodes
		if (n1.isInvalid() || n2.isInvalid()
				|| n1.getVal().getTag().equals("STR")
				|| n2.getVal().getTag().equals("STR")) {
			// n3.setVal(null); //do nothing...
		} else if (n2.getVal().getDval() == 0) {
			// n3.setVal(null);//do nothing....
		} else {
			double v = n1.getVal().getDval() / n2.getVal().getDval();
			n3.setVal(new Value(v));
		}
	}

	/**
	 * subtracts rows as per user input
	 */
	public void subtractRows() {
		Scanner scan = new Scanner(System.in);
		System.out.println("First row:");
		int x1 = Integer.valueOf(scan.nextLine());
		while (x1 < 0 || x1 > length - 1) {
			System.out
					.println("Invalid y coordinate. Choose a number between 0 and "
							+ (length - 1));
			x1 = Integer.valueOf(scan.nextLine());
		}
		System.out.println("Second row:");
		int y1 = Integer.valueOf(scan.nextLine());
		while (y1 < 0 || y1 > length - 1) {
			System.out
					.println("Invalid y coordinate. Choose a number between 0 and "
							+ (length - 1));
			y1 = Integer.valueOf(scan.nextLine());
		}
		System.out.println("Target row:");
		int x2 = Integer.valueOf(scan.nextLine());
		while (x2 < 0 || x2 > length - 1) {
			System.out
					.println("Invalid y coordinate. Choose a number between 0 and "
							+ (length - 1));
			x2 = Integer.valueOf(scan.nextLine());
		}
		// values set
		for (int i = 0; i < width; i++) {
			subtractCells(i, x1, i, y1, i, x2);// subtract each cell and put
			// corresponding results in
			// right cell
		}
	}

	/**
	 * divides rows as per user input
	 */
	public void divideRows() {
		Scanner scan = new Scanner(System.in);
		System.out.println("First row:");
		int x1 = Integer.valueOf(scan.nextLine());
		while (x1 < 0 || x1 > length - 1) {
			System.out
					.println("Invalid y coordinate. Choose a number between 0 and "
							+ (length - 1));
			x1 = Integer.valueOf(scan.nextLine());
		}
		System.out.println("Second row:");

		int y1 = Integer.valueOf(scan.nextLine());
		while (y1 < 0 || y1 > length - 1) {
			System.out
					.println("Invalid y coordinate. Choose a number between 0 and "
							+ (length - 1));
			y1 = Integer.valueOf(scan.nextLine());
		}
		System.out.println("Target row:");
		int x2 = Integer.valueOf(scan.nextLine());
		while (x2 < 0 || x2 > length - 1) {
			System.out
					.println("Invalid y coordinate. Choose a number between 0 and "
							+ (length - 1));
			x2 = Integer.valueOf(scan.nextLine());
		}
		// values set
		for (int i = 0; i < width; i++) {
			divideCells(i, x1, i, y1, i, x2);// subtract each cell and put
			// corresponding results in
			// right cell
		}
	}

	/**
	 * subtracts columns as per user input
	 */
	public void subtractColumns() {
		Scanner scan = new Scanner(System.in);
		System.out.println("First column:");
		int x1 = Integer.valueOf(scan.nextLine());
		while (x1 < 0 || x1 > width - 1) {
			System.out
					.println("Invalid y coordinate. Choose a number between 0 and "
							+ (width - 1));
			x1 = Integer.valueOf(scan.nextLine());
		}
		System.out.println("Second column:");
		int y1 = Integer.valueOf(scan.nextLine());
		while (y1 < 0 || y1 > width - 1) {
			System.out
					.println("Invalid y coordinate. Choose a number between 0 and "
							+ (width - 1));
			y1 = Integer.valueOf(scan.nextLine());
		}
		System.out.println("Target column:");
		int x2 = Integer.valueOf(scan.nextLine());
		while (x2 < 0 || x2 > width - 1) {
			System.out
					.println("Invalid y coordinate. Choose a number between 0 and "
							+ (width - 1));
			x2 = Integer.valueOf(scan.nextLine());
		}
		// values set
		for (int i = 0; i < length; i++) {
			subtractCells(x1, i, y1, i, x2, i);// subtract each cell and put
			// corresponding results in
			// right cell
		}
	}

	/**
	 * divides columns as per user input
	 */
	public void divideColumns() {
		Scanner scan = new Scanner(System.in);
		System.out.println("First column:");
		int x1 = Integer.valueOf(scan.nextLine());
		while (x1 < 0 || x1 > width - 1) {
			System.out
					.println("Invalid y coordinate. Choose a number between 0 and "
							+ (width - 1));
			x1 = Integer.valueOf(scan.nextLine());
		}
		System.out.println("Second column:");
		int y1 = Integer.valueOf(scan.nextLine());
		while (y1 < 0 || y1 > width - 1) {
			System.out
					.println("Invalid y coordinate. Choose a number between 0 and "
							+ (width - 1));
			y1 = Integer.valueOf(scan.nextLine());
		}
		System.out.println("Target column:");
		int x2 = Integer.valueOf(scan.nextLine());
		while (x2 < 0 || x2 > width - 1) {
			System.out
					.println("Invalid y coordinate. Choose a number between 0 and "
							+ (width - 1));
			x2 = Integer.valueOf(scan.nextLine());
		}
		// values set
		for (int i = 0; i < length; i++) {
			divideCells(x1, i, y1, i, x2, i);// subtract each cell and put
			// corresponding results in
			// right cell
		}
	}

	private void insertRow(int i) {
		// insert nodes basically from top down connecting previous to current
		// to next
		if (i < 0 || i >= length) { // check validity
			System.out.println("invalid index.");
		} else if (i == 0) {
			// create new row
			Node curr = new Node(new Value("\""));
			Node startOfCol = curr;
			for (int j = 0; j < width; j++) {
				curr.setRight(new Node(new Value("\"")));
				curr = curr.getRight();
			}
			curr.setRight(startOfCol);// loop back to beginning of list
			// link to original first row
			Node last = head;// last node
			for (int j = 0; j < length; j++) {
				last = last.getDown();
			}
			Node second = head;
			// link curr to old head row
			for (int j = 0; j < width; j++) {
				// set
				last.setDown(curr);
				curr.setDown(second);
				// move alone
				last = last.getRight();
				curr = curr.getRight();
				second = second.getRight();
			}
			head = curr.getRight();
			// ------------------------------------------------------------------------------------------------------------
		} else {
			// create column
			Node next = head;
			// link column to next column
			// link previous column to newly created one.
			// get right column first
			Node prev = next;
			for (int j = 0; j < i; j++) {
				prev = next;
				next = next.getDown();
			}
			// get reference to the one previous to it.
			// create new row
			Node curr = new Node(new Value("\""));
			Node startOfCol = curr;
			for (int j = 0; j < width; j++) {
				curr.setRight(new Node(new Value("\"")));
				curr = curr.getRight();
			}
			curr.setRight(startOfCol);// loop back to beginning of list

			// link curr to next list
			Node temp = prev;
			for (int j = 0; j < width; j++) {
				curr.setDown(temp.getDown());// set new column's right to next
												// column
				temp.setDown(curr);// set previous column down to new column
				temp = temp.getRight(); // index++
				curr = curr.getRight(); // index++
			}
		}
	}

	private void insertColumn(int i) {
		// insert nodes basically from top down connecting previous to current
		// to next
		if (i < 0 || i >= length) { // check validity
			System.out.println("invalid index.");
		} else if (i == 0) {
			// create new row
			Node curr = new Node(new Value("\""));
			Node startOfRow = curr;
			for (int j = 0; j < length; j++) {
				curr.setDown(new Node(new Value("\"")));
				curr = curr.getDown();
			}
			curr.setDown(startOfRow);// loop back to beginning of list
			// link to original first row
			Node last = head;// last node
			for (int j = 0; j < width; j++) {
				last = last.getRight();
			}
			Node second = head;
			// link curr to old head row
			for (int j = 0; j < length; j++) {
				// set
				last.setRight(curr);
				curr.setRight(second);
				// move alone
				last = last.getDown();
				curr = curr.getDown();
				second = second.getDown();
			}
			head = curr.getDown();
		} else {
			// create column
			Node next = head;
			// link column to next column
			// link previous column to newly created one.
			// get right column first
			Node prev = next;
			for (int j = 0; j < i; j++) {
				prev = next;
				next = next.getRight();
			}
			// get reference to the one previous to it.
			// create new column
			Node curr = new Node(new Value("\""));
			Node startOfCol = curr;
			for (int j = 0; j < length; j++) {
				curr.setDown(new Node(new Value("\"")));
				curr = curr.getDown();
			}
			curr.setDown(startOfCol);// loop back to beginning of list
			// link curr to next list
			Node temp = prev;
			for (int j = 0; j < length; j++) {
				curr.setRight(temp.getRight());// set new column's right to next
												// column
				temp.setRight(curr);// set previous column down to new column
				temp = temp.getDown(); // index++
				curr = curr.getDown(); // index++
			}
		}
	}

	/**
	 * inserts a column as per user input
	 */
	public void insertColumn() {
		// this method is called from the demo class, and therefore has no
		// parameters
		System.out.println("column:");
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		while (x < 0 || x >= width) {
			System.out
					.println("sorry, that index is out of bounds. Please enter a number between 0 and "
							+ (width - 1));
			x = scan.nextInt();
		}
		insertColumn(x);
		width++;
	}

	/**
	 * inserts a row as per user input
	 */
	public void insertRow() {
		Scanner scan = new Scanner(System.in);
		System.out.println("row:");
		int x = scan.nextInt();
		while (x < 0 || x >= length) {
			System.out
					.println("sorry, that's an invalid index. Please select a number between 0 and "
							+ (length - 1));
			x = scan.nextInt();
		}
		insertRow(x);
		length++;
	}

	/**
	 * deletes a row as per user input
	 */
	public void deleteRow() {
		if (length <= 1) {
			System.out
					.println("Sorry, it's already just a single column. Cannot delete that one!!! Quitting....");
			return;
		} else {
			// need to go down the row to the left and connect each node to the
			// node
			// two to the right, EXCEPT if it's the last row.
			Scanner scan = new Scanner(System.in);
			System.out.println("row:");
			int x = scan.nextInt();
			while (x < 0 || x >= length) {
				System.out
						.println("sorry, that's an invalid index. Please select a number between 0 and "
								+ (length - 1));
				x = scan.nextInt();
			}
			deleteRow(x);
			length--;
		}
	}

	private void deleteRow(int x) {
		//TODO fix me 
		if (x == 0) {
			Node last = head;
			for (int i = 0; i < length; i++) {
				last = last.getDown();
			}
			Node next = last.getDown().getDown();
			Node tprev = last;
			Node tnext = next;
			for (int i = 0; i < width; i++) {
				tprev.setDown(tnext);
				tprev = tprev.getRight();
				tnext = tnext.getRight();
			}
			head = next;
		} else {
			Node previous = head;
			for (int i = 0; i < x - 1; i++) {
				previous = previous.getDown();
			}
			Node next = previous.getDown().getDown();
			Node tprev = previous;
			Node tnext = next;
			for (int i = 0; i < width; i++) {
				tprev.setDown(tnext);
				tprev = tprev.getRight();
				tnext = tnext.getRight();
			}
		}
	}

	/**
	 * deletes a column as per user input
	 */
	public void deleteColumn() {
		if (width <= 1) {
			System.out
					.println("Sorry, it's already just a single column. Cannot delete that one!!! Quitting....");
			return;
		} else {
			System.out.println("column:");
			Scanner scan = new Scanner(System.in);
			int x = scan.nextInt();
			while (x < 0 || x >= width) {
				System.out
						.println("sorry, that index is out of bounds. Please enter a number between 0 and "
								+ (width - 1));
				x = scan.nextInt();
			}
			deleteColumn(x);
			width--;
		}
	}

	private void deleteColumn(int x) {
		if (x == 0) {
			//TODO fix me
			Node last = head;
			for (int i = 0; i < width; i++) {
				last = last.getRight();
			}
			Node next = last.getRight().getRight();
			Node tprev = last;
			Node tnext = next;
			for (int i = 0; i < length; i++) {
				tprev.setRight(tnext);
				tprev = tprev.getDown();
				tnext = tnext.getDown();
			}
			head = next;
		} else {
			Node previous = head;
			for (int i = 0; i < x - 1; i++) {
				previous = previous.getRight();
			}
			Node next = previous.getRight().getRight();
			Node tprev = previous;
			Node tnext = next;
			for (int i = 0; i < length; i++) {
				tprev.setRight(tnext);
				tprev = tprev.getDown();
				tnext = tnext.getDown();
			}
		}

	}
}