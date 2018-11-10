package ru.job4j.calculate;

/**
 * Class for printing "Hello World!!!" into console.
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 11/10/2018
 */
public class Calculate {
	/**
	 * main.
	 * @param args - String[] args.
	 */
	public static void main(String[] args) {
		System.out.println("Hello World!!!");
	}
	
	/**
     * Method echo.
     * @param name - Your name.
     * @return Echo plus your name.
     */
    public String echo(String name) {
        return "Echo, echo, echo : " + name;
    }
}