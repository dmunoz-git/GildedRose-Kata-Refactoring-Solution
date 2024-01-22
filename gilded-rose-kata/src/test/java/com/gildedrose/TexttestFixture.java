package com.gildedrose;

import java.util.ArrayList;
import java.util.List;
import com.gildedrose.items.Item;
import com.gildedrose.items.ItemFactory;
import com.gildedrose.items.ItemType;

public class TexttestFixture {
	public static void main(String[] args) {
		System.out.println("OMGHAI!");
		ItemFactory factory = new ItemFactory();

		List<Item> items = new ArrayList<Item>(List.of(
				factory.createItem(ItemType.STANDARD, "+5 Dexterity Vest", 10, 20),
				factory.createItem(ItemType.AGED_BRIE, "Aged Brie", 2, 0),
				factory.createItem(ItemType.STANDARD, "Elixir of the Mongoose", 5, 7),
				factory.createItem(ItemType.SULFURAS, "Sulfuras, Hand of Ragnaros", 0, 80),
				factory.createItem(ItemType.SULFURAS, "Sulfuras, Hand of Ragnaros", -1, 80),
				factory.createItem(ItemType.BACKSTAGE_PASSES, "Backstage passes to a TAFKAL80ETC concert", 15, 20),
				factory.createItem(ItemType.BACKSTAGE_PASSES, "Backstage passes to a TAFKAL80ETC concert", 10, 49),
				factory.createItem(ItemType.BACKSTAGE_PASSES, "Backstage passes to a TAFKAL80ETC concert", 5, 49),
				factory.createItem(ItemType.CONJURED, "Conjured Mana Cake", 3, 6)));

		GildedRose app = new GildedRose(items);

		int days = 2;
		if (args.length > 0) {
			days = Integer.parseInt(args[0]) + 1;
		}

		for (int i = 0; i < days; i++) {
			System.out.println("-------- day " + i + " --------");
			System.out.println("name, sellIn, quality");
			for (Item item : items) {
				System.out.println(item);
			}
			System.out.println();
			app.updateQuality();
		}
	}

}
