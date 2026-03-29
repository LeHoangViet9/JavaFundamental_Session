package QuanLyTaiSanThietBi.ra.entity;

import java.util.Scanner;

public class NetworkDevice extends Asset {
    private int numberOfPorts;

    public NetworkDevice() {
    }

    public NetworkDevice(String assetCode, String name, double purchasePrice, int numberOfPorts) {
        super(assetCode, name, purchasePrice);
        this.numberOfPorts = numberOfPorts;
    }

    public int getNumberOfPorts() {
        return numberOfPorts;
    }

    public void setNumberOfPorts(int numberOfPorts) {
        this.numberOfPorts = numberOfPorts;
    }

    @Override
    public double getMarketValue() {
        return getPurchasePrice()*0.9;
    }
    public static NetworkDevice input(Scanner sc) {
        System.out.print("Asset Code: ");
        String code = sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Purchase Price: ");
        double price = Double.parseDouble(sc.nextLine());

        System.out.print("Number of ports: ");
        int ports = Integer.parseInt(sc.nextLine());

        return new NetworkDevice(code, name, price, ports);
    }

    @Override
    public String toString() {
        return "NetworkDevice{" +super.toString()+
                "numberOfPorts=" + numberOfPorts +
                '}';
    }
}
