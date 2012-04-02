package org.mad.app.hokiehelper;

import java.util.ArrayList;

/**
 * Contains a group of grades holding a particular weight.
 * @author Mike
 *
 */
public class Category {

	private ArrayList<Grade> grades;
	private String name;
	private double weight;	// Value between 1-100 inclusive
	private double grade;

	public Category(String name, double weight) {
		grades = new ArrayList<Grade>();
		this.name = name;
		this.weight = weight;
	}

	public void addGrade(String name, int value) {

		grades.add(new Grade(name, value));

		recalculate();

	}

	/**
	 * A private helper method to recalculate the grade. Used after a new 
	 * grade has been added to the grade list.
	 */
	private void recalculate() {

		double newGrade = 0;

		for (Grade g : grades) {
			newGrade += g.getValue();
		}

		newGrade = newGrade / grades.size();

		grade = newGrade;

	}

	/**
	 * Returns the name of the category
	 * @return The name of the category
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the weighted grade
	 * @return weight * grade
	 */
	public double getWeighedGrade() {
		return weight * grade;
	}

	/**
	 * Returns the list of grades currently held within the category.
	 * @return List of grades
	 */
	public ArrayList<Grade> getGrades() {
		return grades;
	}

	/**
	 * Returns the weight of the category
	 * @return
	 */
	public double getWeight() {
		return weight;
	}
	
	public boolean isEmpty() {
		return grades.size() > 0;
	}
	
}
