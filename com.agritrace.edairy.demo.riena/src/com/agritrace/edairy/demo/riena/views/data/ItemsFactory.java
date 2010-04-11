package com.agritrace.edairy.demo.riena.views.data;

import java.util.ArrayList;
import java.util.List;

public class ItemsFactory {

	private ItemsFactory() {

	}

	public static List<Item> createItemList() {
		List<Item> items = new ArrayList<Item>();
		Item item = new Item();
		item.setId("#34-567");
		item.setNumber(20);
		item.setDescription("20 Can of milks");
		items.add(item);

		item = new Item();
		item.setId("#214-57");
		item.setNumber(100);
		item.setDescription("100 bin of milks");
		items.add(item);

		item = new Item();
		item.setId("#89-9");
		item.setNumber(20);
		item.setDescription("");
		items.add(item);

		return items;
	}

}
