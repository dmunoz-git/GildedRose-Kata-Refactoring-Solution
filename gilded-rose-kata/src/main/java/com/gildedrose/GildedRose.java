package com.gildedrose;
import com.gildedrose.items.Item;
import java.util.List;


class GildedRose {
	private List<Item> items;

	public GildedRose(List<Item> items) {
		this.items = items;
	}

	public void updateQuality() {
		for(Item item: items)
			item.updateQuality();
	}
}
