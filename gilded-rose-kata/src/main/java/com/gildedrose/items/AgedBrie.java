package com.gildedrose.items;

public class AgedBrie extends Standard implements Item{
	private static final int MAX_VALUE = 50;

	public AgedBrie(String name, int sellIn, int quality) {
		super(name, sellIn, quality, MAX_VALUE);
	}

	@Override
	public void updateQuality() {
		super.sellIn-=1;
		if(super.quality < super.maxQuality)
			super.quality+=1;
		
	}

}
