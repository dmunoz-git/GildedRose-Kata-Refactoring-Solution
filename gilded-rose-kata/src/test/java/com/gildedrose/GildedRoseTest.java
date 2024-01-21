package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class GildedRoseTest {

    @Test
    public void testDecrementQuality() {
        Item[] items = new Item[] { new Item("item", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, items[0].quality, "Normal items quality must decrement by two" );
    }
    
    @Test
    public void testNegativeQuality() {
    	Item[] items = new Item[] { new Item("item", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertFalse(items[0].quality < 0, "Any item quality cannot be negative");
    }
    
    @Test
    public void testBrieCheeseOnDateQuality() {
    	Item[] items = new Item[] { new Item("Aged brie", 2, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, items[0].quality, "Brie cheese must increment by one when the time increases");
    }
    
    @Test
    public void testBrieCheeseOutdateQuality() {
    	Item[] items = new Item[] { new Item("Aged brie", 0, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, items[0].quality, "Brie cheese must increment by two once is outdated");
    }
    
    @Test
    public void testMaxItemQuality() {
    	Item[] items = new Item[] { new Item("Item", 2, 100) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, items[0].quality, "Max quality value must be 50");
    }
    
    @Test
    public void testSulfurasMaxQuality() {
    	Item[] items = new Item[] { new Item("Sulfuras", 1, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, items[0].quality, "Sulfuras quality mustn't be higher than 80");
    }
    
    @Test
    public void testSulfurasStaticQuality() {
    	Item[] items = new Item[] { new Item("Sulfuras", 1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, items[0].quality, "Sulfuras quality mustn't decrement");
    }
    
    @Test
    public void testSulfurasStaticDate() {
    	Item[] items = new Item[] { new Item("Sulfuras", 1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, items[0].sellIn, "Sulfuras date mustn't decrement");
    }
    
    @Test
    public void testBackstateOutdateQuality() {
    	Item[] items = new Item[] { new Item("Backstate", 15, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, items[0].quality, "Backstate ticket quality must increment");
    }
    
    @Test
    public void testBackstateIncrementQualityByTwo() {
    	Item[] items = new Item[] { new Item("Backstate", 9, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, items[0].quality, "Backstate ticket quality must increment by two");
    }
    
    @Test
    public void testBackstateIncrementQualityByThree() {
    	Item[] items = new Item[] { new Item("Backstate", 4, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, items[0].quality, "Backstate ticket quality must increment by two");
    }
    
    @Test
    public void testBackstateOutdatedQuality() {
    	Item[] items = new Item[] { new Item("Backstate", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, items[0].quality, "Backstate ticket drop to 0 after the concert");
    }


}
