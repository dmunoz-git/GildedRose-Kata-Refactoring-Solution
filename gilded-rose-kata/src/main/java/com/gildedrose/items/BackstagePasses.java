package com.gildedrose.items;

public class BackstagePasses extends Item {
	private static final int MAX_VALUE = 50;
	
	public BackstagePasses(String name, int sellIn, int quality) {
		super(name, sellIn, quality, MAX_VALUE);
	}

	@Override
	public void updateQuality() {
		super.sellIn -= 1;
		if (sellIn <= 0)
			super.quality = 0;
		else if (quality < MAX_VALUE) {
			super.quality += 1;
			if (quality < MAX_VALUE) {
				if (sellIn < 6)
					super.quality += 2;
				else if (sellIn < 11)
					super.quality += 1;
			}
		}
	}

}
