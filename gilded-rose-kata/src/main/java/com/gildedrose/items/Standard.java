package com.gildedrose.items;

public class Standard extends Item {
	public Standard(String name, int sellIn, int quality, int maxQuality) {
		super(name, sellIn, quality, maxQuality);
	}
	
	@Override
	public void updateQuality() {
		this.sellIn-=1;
		if(quality > 0)
			this.quality-=1;
		if(sellIn <= 0 && quality > 0)
			this.quality-=1;
	}

}
