package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;

@TestInstance(Lifecycle.PER_CLASS)
class GildedRoseTest {	
	private final int MAX_ITEM_QUATITY = 50;
	private final int MAX_SULFURAS_QUANTITY = 80;
	
	private Item[] items;
	private GildedRose app;
	
	@BeforeEach
	private void initItems() {
		this.items = new Item[] { 
				new Item("+5 Dexterity Vest", 10, 20), 
				new Item("+5 Dexterity Vest", -1, 20),
				new Item("+5 Dexterity Vest", 10, 0),
                new Item("Aged Brie", 2, 0), 
                new Item("Aged Brie", 0, 0), 
                new Item("Aged Brie", 0, 50),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 40),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 40),
                new Item("Backstage passes to a TAFKAL80ETC concert", -1, 40),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                new Item("Conjured", 5, 40)
		};
		
		this.app = new GildedRose(this.items);
	}

	@Test
	public void testDecrementQuality() {
		int quality = items[0].quality;
		app.updateQuality();
		assertEquals(quality - 1, items[0].quality, "Normal items quality must decrement by two");
	}
	
	@Test
	public void testDecrementQualityOnceIsLapsed() {
		int quality = items[1].quality;
		app.updateQuality();
		assertEquals(quality - 2, items[1].quality, "Normal items quality must decrement by two");
	}

	@Test
	public void testNegativeQuality() {
		app.updateQuality();
		assertFalse(items[2].quality < 0, "Any item quality cannot be negative");
	}

	@Test
	public void testAgedBrieOnDateQuality() {
		int quality = items[3].quality;
		app.updateQuality();
		assertEquals(quality + 1, items[3].quality, "Aged Brie cheese must increment by one when is updated");
	}

	@Test
	public void testAgedBrieOutdatedQuality() {
		int quality = items[4].quality;
		app.updateQuality();
		assertEquals(quality + 2,items[4].quality, "Aged Brie cheese must increment by two once is outdated");
	}

	@Test
	public void testMaxItemQuality() {
		app.updateQuality();
		assertEquals(MAX_ITEM_QUATITY, items[5].quality, "Max quality value must be 50");
	}

	@Test
	public void testSulfurasMaxQuality() {
		app.updateQuality();
		assertEquals(MAX_SULFURAS_QUANTITY, items[6].quality, "Sulfuras quality mustn't be higher than 80");
	}

	@Test
	public void testSulfurasStaticQuality() {
		app.updateQuality();
		assertEquals(MAX_SULFURAS_QUANTITY, items[6].quality, "Sulfuras quality mustn't decrement");
	}

	@Test
	public void testSulfurasStaticDate() {
		app.updateQuality();
		assertEquals(-1, items[7].sellIn, "Sulfuras date mustn't decrement");
	}

	@Test
	public void testBackstateOutdateQuality() {
		int quality = items[8].quality;
		app.updateQuality();
		assertEquals(quality + 1, items[8].quality, "Backstage ticket quality must increment");
	}

	@Test
	public void testBackstateIncrementQualityByTwo() {
		int quality = items[9].quality;
		app.updateQuality();
		assertEquals(quality + 2, items[9].quality, "Backstage ticket quality must increment by two when there are 5 days or less");
	}

	@Test
	public void testBackstateIncrementQualityByThree() {
		int quality = items[10].quality;
		app.updateQuality();
		assertEquals(quality + 3, items[10].quality, "Backstage ticket quality must increment by two when there are 5 days or less");
	}

	@Test
	public void testBackstateOutdatedQuality() {
		app.updateQuality();
		assertEquals(0, items[11].quality, "Backstage ticket drop to 0 after the concert");
	}
	
	@Test
	public void testMaxBackstageIncrementQuality() {
		app.updateQuality();
		assertEquals(MAX_ITEM_QUATITY, items[12].quality, "Backstage max ticket quality must be 50 even if we increment by two or three");
	}
	
	@Disabled
	@Test 
	void testConjuredDecrementQuality() {
		int quality = items[13].quality;
		app.updateQuality();
		assertEquals(quality - 2, items[13].quality, "Backstage max ticket quality must be 50 even if we increment by two or three");

	}

}
