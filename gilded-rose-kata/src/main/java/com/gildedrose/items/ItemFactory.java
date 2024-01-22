package com.gildedrose.items;

public class ItemFactory {
	public Item createItem(ItemType type, String name, int sellIn, int quality){
		switch(type) {
		case STANDARD:
			return new Standard(name, sellIn, quality, 50);
			
		case AGED_BRIE:
			return new AgedBrie(name, sellIn, quality);
			
		case BACKSTAGE_PASSES:
			return new BackstagePasses(name, sellIn, quality);
			
		case CONJURED:
			return new Conjured(name, sellIn, quality);
		
		case SULFURAS:
			return (Item) new Sulfuras(name, sellIn, quality);
			
		default:
			return new Standard(name, sellIn, quality, 50);

		}
	}
}
