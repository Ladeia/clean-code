package com.a.introduction.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GildedRoseADefaultItemTest {

	private final int UNEXPIRED_SELLING = 15;
	private final int EXPIRED_SELLING = -1;
	private final int DEFAULT_QUALITY = 3;
	private final String DEFAULT_ITEM = "DEFAULT_ITEM";

	@Test
	public void unexpiredItemQualityDecreaseBy1() {
		GildedRose app = createGiledRoseWithOneItem(DEFAULT_ITEM, UNEXPIRED_SELLING, DEFAULT_QUALITY);

		app.updateQuality();

		Item expected = new Item(DEFAULT_ITEM, UNEXPIRED_SELLING -1, DEFAULT_QUALITY-1);

		assertItem(expected, app.items[0]);
	}

	@Test
	public void expiredItemQualityDecreaseBy2() {
		GildedRose app = createGiledRoseWithOneItem(DEFAULT_ITEM, EXPIRED_SELLING, DEFAULT_QUALITY);

		app.updateQuality();

		Item expected = new Item(DEFAULT_ITEM, EXPIRED_SELLING -1, DEFAULT_QUALITY - 2);

		assertItem(expected, app.items[0]);
	}

	private void assertItem(Item expected, Item actual) {
		assertEquals(expected.name, actual.name);
		assertEquals(expected.sellIn, actual.sellIn);
		assertEquals(expected.quality, actual.quality);
	}

	private GildedRose createGiledRoseWithOneItem(String itemType, int expiredselling, int defaultQuality) {
		Item item = new Item(itemType, expiredselling, defaultQuality);
		Item[] items = new Item[]{item};
		return new GildedRose(items);
	}
}