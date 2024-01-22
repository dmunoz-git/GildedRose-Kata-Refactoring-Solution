package com.gildedrose.items;

public class Conjured extends Standard implements Item {
	private static final int MAX_VALUE = 50;

	public Conjured(String name, int sellIn, int quality) {
		super(name, sellIn, quality, MAX_VALUE);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updateQuality() {
		super.sellIn -= 1;
		if (super.quality > 0)
			super.quality -= 1;
		if (super.quality > 0)
			super.quality -= 1;
	}

}
