package com.example.mwajeeh.animations;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Categories {
    private static List<Category> categories = generateItems();

    public static List<Category> getCategories() {
        return categories;
    }

    private static List<Category> generateItems() {
        Random rand = new Random();
        List<Category> items = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            items.add(new Category("title:" + i, getImage(rand.nextInt(5))));
        }
        return items;
    }

    public static class Category {
        public final String title;
        public final int image;

        private Category(String title, int image) {
            this.title = title;
            this.image = image;
        }
    }

    private static int getImage(int position) {
        switch (position) {
            case 0:
                return R.drawable.car;
            case 1:
                return R.drawable.sedan;
            case 2:
                return R.drawable.bicycle;
            case 3:
                return R.drawable.bike;
            default:
                return R.drawable.jeep;
        }
    }
}
