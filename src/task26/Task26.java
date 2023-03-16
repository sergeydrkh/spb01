package task26;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Task26 {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader("C:\\Users\\serezk4\\Desktop\\ege\\spb01\\spb01\\src\\task26\\files\\26_6641.txt"));

        long deposit = Integer.parseInt(fileReader.readLine().trim().split(" ")[1]);
        final long staticDeposit = deposit;
        List<Item> items = new ArrayList<>();
        while (fileReader.ready()) {
            String[] initData = fileReader.readLine().trim().split(" ");
            items.add(new Item(Integer.parseInt(initData[0]), initData[1].equals("S") ? 1 : 0));
        }

        items.sort(Comparator.comparingInt(i -> i.getCost() - i.getType()));

        List<Item> usedItems = new ArrayList<>();
        for (Item currentItem : items) {
            deposit -= currentItem.getCost();

            if (deposit < 0) {
                deposit += currentItem.getCost();
                break;
            }

            usedItems.add(currentItem);
        }


        List<Item> neededItems = items.stream().filter(item -> !usedItems.contains(item) && item.getType() == 1).toList();
        List<Item> notNeededItems = new ArrayList<>(usedItems.stream().filter(item -> item.getType() == 0).toList());
        Collections.reverse(notNeededItems);

        int diff = 0;
        while (deposit >= 0) {
//            System.out.println(neededItems.get(diff).getCost() + " " + notNeededItems.get(diff).getCost());

            deposit -= neededItems.get(diff).getCost();
            deposit += notNeededItems.get(diff).getCost();

            if (deposit < 0) {
                deposit += neededItems.get(diff).getCost();
                deposit -= notNeededItems.get(diff).getCost();
                break;
            }

            usedItems.remove(notNeededItems.get(diff));
            usedItems.add(neededItems.get(diff));

            diff++;
        }

        System.out.println(usedItems.stream().filter(item -> item.getType() == 1).count());
        System.out.println(staticDeposit - usedItems.stream().mapToInt(Item::getCost).sum());
    }

    public static class Item {
        private final int cost, type;

        public Item(int cost, int type) {
            this.cost = cost;
            this.type = type;
        }

        public int getCost() {return cost;}
        public int getType() {return type;}
        public void print() {System.out.println(toString());}

        @Override
        public String toString() {return "Item{cost=" + cost + ", type=" + type + '}';}
    }
}
