package QuanLyTaiSanThietBi.ra.entity;

import java.util.Scanner;

public abstract class Asset {
    private String assetCode;
    private String name;
    private double purchasePrice;

    public Asset() {
    }

    public Asset(String assetCode, String name, double purchasePrice) {
        this.assetCode = assetCode;
        this.name = name;
        this.purchasePrice = purchasePrice;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public  abstract double getMarketValue();

    @Override
    public String toString() {
        return "Asset{" +
                "assetCode='" + assetCode + '\'' +
                ", name='" + name + '\'' +
                ", purchasePrice=" + purchasePrice +
                '}';
    }
}
