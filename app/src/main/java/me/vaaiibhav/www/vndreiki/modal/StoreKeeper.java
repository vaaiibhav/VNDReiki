package me.vaaiibhav.www.vndreiki.modal;

/**
 * Created by Vaaiibhav on 17-Sep-17.
 */

public class StoreKeeper {
    private static final StoreKeeper ourInstance = new StoreKeeper();

    String userName;
    String userPersonName;
    String userLocation;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPersonName() {
        return userPersonName;
    }

    public void setUserPersonName(String userPersonName) {
        this.userPersonName = userPersonName;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    public static synchronized StoreKeeper getInstance() {
        return ourInstance;
    }

    private StoreKeeper() {
    }
}
