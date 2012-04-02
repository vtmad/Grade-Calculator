package org.mad.app.hokiehelper;

import java.util.ArrayList;

/**
 * A Class object to contain the grade information for a particular class.
 * 
 * Holds various categories with individual weights.
 * 
 * @author Mike
 * 
 */
public class Class {

	private String name;
	private ArrayList<Category> categories;
	private double currentGrade;

	/**
	 * Creates a new Class object given simply a name
	 * 
	 * @param name
	 */
	public Class(String name) {
		this.name = name;
		categories = new ArrayList<Category>();
		currentGrade = 0;
	}

	/**
	 * Adds a new category to the class. Does not allow duplicate names for categories
	 * 
	 * @param name
	 *            Name of the category (eg. Homework, Test, etc.)
	 * @param weight
	 *            The weight of the category (1-100 inclusive)
	 */
	public void addCategory(String name, double weight) {
		
		// Checks if the new category name is in use
		for (Category c : categories) {
			if (c.getName().equals(name)) {
				return;
			}
		}
		
		categories.add(new Category(name, weight));
	}

	/**
	 * Calculates the grade based upon the categories.
	 */
	private void calculateGrade() {
		double newGrade = 0;
		double totalWeight = 0;

		for (Category c : categories) {

			// Doesn't count empty categories against you. Possibly
			// make this a preference?
			if (!c.isEmpty()) {
				newGrade += c.getWeighedGrade();
				totalWeight += c.getWeight();
			}
		}

		newGrade = newGrade / totalWeight;

		currentGrade = newGrade;

	}

	/**
	 * Returns a category based upon name
	 * @param name The name of the category we're searching for
	 * @return The category object if found, NULL if not.
	 */
	public Category getCategory(String name) {
		for (Category c : categories) {
			if (c.getName().equals(name)) {
				return c;
			}
		}
		
		return null;
	}
	
	public double getGrade() {
		return currentGrade;
	}

}
