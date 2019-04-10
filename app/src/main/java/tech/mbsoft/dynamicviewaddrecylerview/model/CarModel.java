package tech.mbsoft.dynamicviewaddrecylerview.model;

public class CarModel {

    String imageUrl;
    String carName;

    public CarModel(String imageUrl, String carName) {
        this.imageUrl = imageUrl;
        this.carName = carName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }


}
