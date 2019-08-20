package com.amirahmed.hatly.Models;

public class MealItem {

    int mealImage;
    String mealName;
    String mealPrice;

    public MealItem(int mealImage, String mealName, String mealPrice) {
        this.mealImage = mealImage;
        this.mealName = mealName;
        this.mealPrice = mealPrice;
    }

    public int getMealImage() {
        return mealImage;
    }

    public void setMealImage(int mealImage) {
        this.mealImage = mealImage;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getMealPrice() {
        return mealPrice;
    }

    public void setMealPrice(String mealPrice) {
        this.mealPrice = mealPrice;
    }
}
