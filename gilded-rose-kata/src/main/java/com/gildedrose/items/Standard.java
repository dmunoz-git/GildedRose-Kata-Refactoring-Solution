package com.gildedrose.items;

public class Standard implements Item {
	protected String name;
	protected int sellIn;
	protected int quality;
	protected int maxQuality;
	
	public Standard(String name, int sellIn, int quality, int maxQuality) {
		if (quality < 0 || quality > maxQuality)
			throw new IllegalArgumentException("Quality cannot be negative or higher than " + maxQuality);

		this.name = name;
		this.sellIn = sellIn;
		this.quality = quality;
		this.maxQuality = maxQuality;
	}
	
	public int getSellIn() {
		return sellIn;
	}

	public void setSellIn(int sellIn) {
		this.sellIn = sellIn;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}


	@Override
	public void updateQuality() {
		this.sellIn-=1;
		if(quality > 0)
			this.quality-=1;
		if(sellIn <= 0 && quality > 0)
			this.quality-=1;
	}

	@Override
	public String toString() {
		return this.name + ", " + this.sellIn + ", " + this.quality;
	}

}
