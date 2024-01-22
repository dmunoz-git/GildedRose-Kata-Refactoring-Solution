package com.gildedrose.items;

public class Sulfuras extends Standard implements Item {
	private static final int MAX_VALUE = 80;
	
	public Sulfuras(String name, int sellIn, int quality) {
		super(name,sellIn,quality, MAX_VALUE);
	}

	@Override
	public void updateQuality() {

	}

}
