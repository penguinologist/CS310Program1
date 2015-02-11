/**
 * 
 */
package program1;

/**
 * @author Jeroen
 *
 */
public class Value {
	// class variables
	private double dval;
	private String sval;
	private String tag;

	/**
	 * constructor
	 * 
	 * @param input
	 *            the input provided by the user
	 */
	public Value(String input) {
		tag = "STR";
		if (input.startsWith("\"")) {
			sval = input.substring(1);

		} else {
			System.out
					.println("Cannot instantiate a Value object with this input.");
			tag = "INVALID";
		}

	}

	/**
	 * constructor
	 * 
	 * @param input
	 *            the input provided by the user
	 */
	public Value(double input) {

		tag = "DBL";
		dval = input;
	}

	/**
	 * adds the value of v1 to the current value and returns a new instance of a
	 * value to be placed used elsewhere in the program
	 * 
	 * @param v1
	 * @return Value
	 */
	public Value add(Value v1) {
		Value val = null;
		if (this.getTag().equals("DBL") && v1.getTag().equals("DBL")) {
			val = new Value(this.getDval() + v1.getDval() + "");
		} else {
			tag = "INVALID";

		}
		return val;
	}

	/**
	 * simple toString returns a string depending on the tag
	 * 
	 * @return String to be returned
	 */
	public String toString() {
		String t = "";
		if (tag.equals("DBL")) {
			t = String.format("%10.4f", dval);
		} else if (tag.equals("STR")) {
			t = String.format("%10s", sval);
		} 
			
		return String.format("%15s", t);
	}

	// ----------------------------------------- Getters and setters
	// --------------------------------------
	/**
	 * gets the tag
	 * 
	 * @return String tag
	 */
	public String getTag() {

		return tag;
	}

	/**
	 * sets the tag
	 * 
	 * @param f
	 *            tag
	 */
	public void setTag(String f) {
		tag = f;
	}

	/**
	 * gets the string value
	 * 
	 * @return the svalue
	 */
	public String getSval() {
		return sval;
	}

	/**
	 * sets the sval
	 * 
	 * @param sval
	 *            the sval to set
	 */
	public void setSval(String sval) {
		this.sval = sval;
	}

	/**
	 * gets the dval
	 * 
	 * @return the dval
	 */
	public double getDval() {
		return dval;
	}

	/**
	 * sets the dval
	 * 
	 * @param dval
	 *            the dval to set
	 */
	public void setDval(double dval) {
		this.dval = dval;
	}

}
