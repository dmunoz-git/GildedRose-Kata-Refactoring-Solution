package com.gildedrose.items;

public class Conjured extends Standard implements Item {

	public Conjured(String name, int sellIn, int quality, int maxQuality) {
		super(name, sellIn, quality, maxQuality);
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
