package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;

import com.gildedrose.items.Item;
import com.gildedrose.items.ItemFactory;
import com.gildedrose.items.ItemType;

@TestInstance(Lifecycle.PER_CLASS)
class GildedRoseTest {
	private final int MAX_ITEM_QUATITY = 50;
	private final int MAX_SULFURAS_QUANTITY = 80;

	private ItemFactory factory = new ItemFactory();

	private List<Item> items;
	private GildedRose app;

	@BeforeEach
	private void initItems() {
		this.items = new ArrayList<Item>(List.of(factory.createItem(ItemType.STANDARD, "+5 Dexterity Vest", 10, 20),
				factory.createItem(ItemType.STANDARD, "+5 Dexterity Vest", -1, 20),
				factory.createItem(ItemType.STANDARD, "+5 Dexterity Vest", 10, 0),
				factory.createItem(ItemType.AGED_BRIE, "Aged Brie", 2, 0),
				factory.createItem(ItemType.AGED_BRIE, "Aged Brie", 0, 0),
				factory.createItem(ItemType.AGED_BRIE, "Aged Brie", 0, 50),
				factory.createItem(ItemType.SULFURAS, "Sulfuras, Hand of Ragnaros", 0, 80),
				factory.createItem(ItemType.SULFURAS, "Sulfuras, Hand of Ragnaros", -1, 80),
				factory.createItem(ItemType.BACKSTAGE_PASSES, "Backstage passes to a TAFKAL80ETC concert", 15, 20),
				factory.createItem(ItemType.BACKSTAGE_PASSES, "Backstage passes to a TAFKAL80ETC concert", 10, 40),
				factory.createItem(ItemType.BACKSTAGE_PASSES, "Backstage passes to a TAFKAL80ETC concert", 5, 40),
				factory.createItem(ItemType.BACKSTAGE_PASSES, "Backstage passes to a TAFKAL80ETC concert", -1, 40),
				factory.createItem(ItemType.BACKSTAGE_PASSES, "Backstage passes to a TAFKAL80ETC concert", 5, 49),
				factory.createItem(ItemType.CONJURED, "Conjured Mana Cake", 5, 40)

		)

		);

		this.app = new GildedRose(this.items);
	}

	@Test
	public void testNonPassedItemUpdate() {
		int quality = this.items.get(0).getQuality();
		app.updateQuality();
		assertEquals(quality - 1, this.items.get(0).getQuality(), "Non special items must lower quality by one");
	}

	@Test
	public void testPassedItemUpdate() {
		int quality = this.items.get(1).getQuality();
		app.updateQuality();
		assertEquals(quality - 2, this.items.get(1).getQuality(),
				"Non special items must degrades twice as fast once the sell by date has passed");
	}

	@Test
	public void testNegativeQuality() {
		app.updateQuality();
		assertFalse(this.items.get(2).getQuality() < 0, "The Quality of an item must never be negative");
	}

	@Test
	public void testAgedBrieOnDateQuality() {
		int quality = this.items.get(3).getQuality();
		app.updateQuality();
		assertEquals(quality + 1, this.items.get(3).getQuality(),
				"Aged Brie must increases in Quality the older it gets");
	}

	@Test
	public void testMaxItemQuality() {
		app.updateQuality();
		assertEquals(MAX_ITEM_QUATITY, this.items.get(5).getQuality(),
				"The Quality of an item must never be more than 50");
	}

	@Test
	public void testSulfurasMaxQuality() {
		app.updateQuality();
		assertEquals(MAX_SULFURAS_QUANTITY, this.items.get(6).getQuality(), "Sulfuras quality must be always 80");
	}

	@Test
	public void testSulfurasStaticQuality() {
		app.updateQuality();
		assertEquals(MAX_SULFURAS_QUANTITY, this.items.get(6).getQuality(), "Sulfuras quality mustn't decrement");
	}

	@Test
	public void testSulfurasStaticDate() {
		app.updateQuality();
		assertEquals(-1, this.items.get(7).getSellIn(), "Sulfuras date mustn't decrement");
	}

	@Test
	public void testBackstateOutdateQuality() {
		int quality = this.items.get(8).getQuality();
		app.updateQuality();
		assertEquals(quality + 1, this.items.get(8).getQuality(), "Backstage ticket quality must increment");
	}

	@Test
	public void testBackstateIncrementQualityByTwo() {
		int quality = this.items.get(9).getQuality();
		app.updateQuality();
		assertEquals(quality + 2, this.items.get(9).getQuality(),
				"Backstage ticket quality must increment by two when there are 5 days or less");
	}

	@Test
	public void testBackstateIncrementQualityByThree() {
		int quality = this.items.get(10).getQuality();
		app.updateQuality();
		assertEquals(quality + 3, this.items.get(10).getQuality(),
				"Backstage ticket quality must increment by two when there are 5 days or less");
	}

	@Test
	public void testBackstateOutdatedQuality() {
		app.updateQuality();
		assertEquals(0, this.items.get(11).getQuality(), "Backstage ticket drop to 0 after the concert");
	}

	@Test
	public void testMaxBackstageIncrementQuality() {
		app.updateQuality();
		assertEquals(MAX_ITEM_QUATITY, this.items.get(12).getQuality(),
				"Backstage max ticket quality must be 50 even if we increment by two or three");
	}

	@Test
	void testConjuredDecrementQuality() {
		int quality = this.items.get(13).getQuality();
		app.updateQuality();
		assertEquals(quality - 2, this.items.get(13).getQuality(), "Conjured must decrement twince as fast");

	}

}
