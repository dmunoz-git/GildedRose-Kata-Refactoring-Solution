package com.gildedrose;

class GildedRose {
	private final int MAX_ITEM_QUATITY = 50;
	private final int MAX_SULFURAS_QUANTITY = 80;
	private final String AGED_BRIE_ITEM = "Aged Brie";
	private final String BACKSTAGE_PASSES_ITEM = "Backstage passes to a TAFKAL80ETC concert";
	private final String SULFURAS_ITEM = "Sulfuras, Hand of Ragnaros";

	private Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (int i = 0; i < items.length; i++) {
			switch (items[i].name) {
			case AGED_BRIE_ITEM:
				items[i].sellIn -= 1;
				if (items[i].quality < MAX_ITEM_QUATITY)
					if (items[i].sellIn > 0)
						items[i].quality += 1;
					else
						items[i].quality += 2;

				break;
			case BACKSTAGE_PASSES_ITEM:
				items[i].sellIn -= 1;
				if (items[i].quality < MAX_ITEM_QUATITY) {
					items[i].quality = items[i].quality + 1;
					if (items[i].quality < MAX_ITEM_QUATITY) {
						if (items[i].sellIn < 6) {
							items[i].quality += 2;
						} else if (items[i].sellIn < 11) {
							items[i].quality += 1;
						}
					}
				}
				if (items[i].sellIn < 0) {
					items[i].quality = 0;
				}
				break;
			case SULFURAS_ITEM:
				break;
			default: // Other items
				items[i].sellIn -= 1;
				if (items[i].quality > 0) {
					items[i].quality = items[i].quality - 1;
					if (items[i].sellIn < 0) {
						items[i].quality = items[i].quality - 1;
					}
				}

			}
		}
	}
}
