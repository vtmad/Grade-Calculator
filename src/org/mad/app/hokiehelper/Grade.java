package org.mad.app.hokiehelper;

import java.util.ArrayList;

public class Grade {

	private String name;
	private double value;
	private ArrayList<Category> categories;

	public Grade(String name, double value) {
		this.name = name;
		this.value = value;
		categories = new ArrayList<Category>();
	}

	public double getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	public void addCategory(String name, double weight) {
		categories.add(new Category(name, weight));
	}

}
