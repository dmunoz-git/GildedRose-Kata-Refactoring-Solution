package com.gildedrose.items;

public class BackstagePasses extends Standard implements Item {

	public BackstagePasses(String name, int sellIn, int quality, int maxQuality) {
		super(name, sellIn, quality, maxQuality);
	}

	@Override
	public void updateQuality() {
		super.sellIn -= 1;
		if (sellIn <= 0)
			super.quality = 0;
		else if (quality < super.maxQuality) {
			super.quality += 1;
			if (quality < super.maxQuality) {
				if (sellIn < 6)
					super.quality += 2;
				else if (sellIn < 11)
					super.quality += 1;
			}
		}
	}

}
