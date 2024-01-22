package com.gildedrose.items;

public class AgedBrie extends Standard implements Item{

	public AgedBrie(String name, int sellIn, int quality, int maxQuality) {
		super(name, sellIn, quality, maxQuality);
	}

	@Override
	public void updateQuality() {
		super.sellIn-=1;
		if(super.quality < super.maxQuality)
			super.quality+=1;
		
	}

}
