package com.corejava.java8.funcinterface.items;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ItemsClient {

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item("chicken", 650));
        items.add(new Item("pizza",250));
        items.add(new Item("burger",770));
        items.add(new Item("chips", 530));
        items.add(new Item("French Fries",570));
        items.add(new Item("Shawarma", 140));
        items.forEach(System.out::println);

        Consumer<Item> consumer = (c) -> System.out.println(c.getItemName().toUpperCase());
        System.out.println("Without lambda expression: ");
        items.forEach(consumer);

        System.out.println("\nWith lambda expression: ");
        items.forEach(item -> System.out.println(item.getItemName().toUpperCase()));

        //Returns true if item price is > 500
        Predicate<Item> predicate = (item) -> item.getPrice() > 600;
        System.out.println("\nItems with price > 600:");
        items.stream()
                .filter(predicate)
                .forEach(System.out::println);

        //Returning an Item with no valid data
        Supplier<Item> supplier = () -> new Item("Dummy", 0);
        Item retrievedItem = items.stream()
                .filter(item -> item.getPrice() > 1000)
                .findAny()
                .orElseGet(supplier);
        System.out.println("\nRetrieved Item (with Supplier if none found): " + retrievedItem);

        // Function example (Convert Item to String with formatted output)
        Function<Item, String> descriptionFunction = (item) -> item.getItemName() + " costs $" + item.getPrice();
        System.out.println("\nFormatted output using Function:");
        items.stream()
                .map(descriptionFunction)
                .forEach(System.out::println);
    }
}
