package com.amirahmed.hatly.Models;

public class RestaurantItem {

    String restaurantName;
    String restaurantSlogan;
    int restaurantPicture;

    public RestaurantItem(String restaurantName, String restaurantSlogan, int restaurantPicture) {
        this.restaurantName = restaurantName;
        this.restaurantSlogan = restaurantSlogan;
        this.restaurantPicture = restaurantPicture;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantSlogan() {
        return restaurantSlogan;
    }

    public void setRestaurantSlogan(String restaurantSlogan) {
        this.restaurantSlogan = restaurantSlogan;
    }

    public int getRestaurantPicture() {
        return restaurantPicture;
    }

    public void setRestaurantPicture(int restaurantPicture) {
        this.restaurantPicture = restaurantPicture;
    }
}
