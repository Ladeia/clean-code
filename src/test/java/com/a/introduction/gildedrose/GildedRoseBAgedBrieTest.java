package com.a.introduction.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GildedRoseBAgedBrieTest {

	private static final String AGED_BRIE = "Aged Brie";
	private static final int DEFAULT_QUALITY = 3;
	private static final int MAX_QUALITY = 50;
	private static final int UNEXPIRED_SELLING = 4;
	private static final int EXPIRED_SELLING =-1;

	@Test
	public void unexpiredAgedBrieQualityIncreasesBy1() {

		GildedRose app = createGiledRoseWithOneItem(AGED_BRIE, UNEXPIRED_SELLING, DEFAULT_QUALITY);


		app.updateQuality();

		Item expected = new Item(AGED_BRIE, UNEXPIRED_SELLING -1, DEFAULT_QUALITY+1);

		assertItem(expected, app.items[0]);
	}

	@Test
	public void unexpiredAgedBrieQualityIncreasesBy2() {
		GildedRose app = createGiledRoseWithOneItem(AGED_BRIE, EXPIRED_SELLING, DEFAULT_QUALITY);

		app.updateQuality();

		Item expected = new Item(AGED_BRIE, EXPIRED_SELLING -1, DEFAULT_QUALITY+2);

		assertItem(expected, app.items[0]);
	}

	@Test
	public void unexpiredAgedBrieQualityDoesNotGoBeyondMaximum() {
		GildedRose app = createGiledRoseWithOneItem(AGED_BRIE, UNEXPIRED_SELLING, MAX_QUALITY);

		app.updateQuality();

		Item expected = new Item(AGED_BRIE, UNEXPIRED_SELLING -1, MAX_QUALITY);

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
