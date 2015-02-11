/**
 * 
 */
package program1;

import java.util.Scanner;

/**
 * Demo class designed to run the program as it contains the main method
 * 
 * @author Jeroen
 *
 */
public class Demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Welcome to Program 1");
		Grid grid = new Grid(6, 10);
		boolean quit = false;
		while (!quit) {
			// display menu
			System.out.println("Operations");
			System.out
					.println("  display           dis           assign cell       as");
			System.out
					.println("  fill              f             number            n");
			System.out
					.println("  add cells         a             subtract cells    s");
			System.out
					.println("  multiply cells    m             divide cells      d");
			System.out
					.println("  add rows          ar            subtract rows     sr");
			System.out
					.println("  multiply rows     mr            divide rows       dr");
			System.out
					.println("  add columns       ac            subtract columns  sc");
			System.out
					.println("  multiply columns  mc            divide columns    dc");
			System.out
					.println("  insert row        ir            insert column     ic");
			System.out
					.println("  delete row        delr          delete column     delc");
			System.out.println("  quit              q");

			System.out.println("->");
			// read input
			String input = reader.nextLine();
			if (input.equals("q")) {
				quit = true;
			} else

			if (input.equals("dis")) {
				grid.print();
			} else if (input.equals("f")) {
				grid.fill();
			} else if (input.equals("a")) {
				grid.addCells();
			} else if (input.equals("m")) {
				grid.multiplyCells();
			} else if (input.equals("ar")) {
				grid.addRows();
			} else if (input.equals("mr")) {
				grid.multiplyRows();
			} else if (input.equals("ac")) {
				grid.addColumns();
			} else if (input.equals("mc")) {
				grid.multiplyColumns();
			} else if (input.equals("ir")) {
				grid.insertRow();
			} else if (input.equals("delr")) {
				grid.deleteRow();
			} else if (input.equals("as")) {
				grid.assignCell();
			} else if (input.equals("n")) {
				grid.number();
			} else if (input.equals("s")) {
				grid.subtractCells();
			} else if (input.equals("d")) {
				grid.divideCells();
			} else if (input.equals("sr")) {
				grid.subtractRows();
			} else if (input.equals("dr")) {
				grid.divideRows();
			} else if (input.equals("sc")) {
				grid.subtractColumns();
			} else if (input.equals("dc")) {
				grid.divideColumns();
			} else if (input.equals("ic")) {
				grid.insertColumn();
			} else if (input.equals("delc")) {
				grid.deleteColumn();
			} else {
				System.out
						.println("Sorry, that's not a valid command. Please try again out of this menu:");
			}

		}
		reader.close();
		System.out.println("Thank you!");

	}
}
