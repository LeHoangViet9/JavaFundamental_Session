package QuanLyTaiSanThietBi.ra.entity;

import java.util.Scanner;

public class Computer  extends Asset{
    private int ram;
    private String cpu;

    public Computer() {
    }

    public Computer(String assetCode, String name, double purchasePrice, int ram, String cpu) {
        super(assetCode, name, purchasePrice);
        this.ram = ram;
        this.cpu = cpu;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    @Override
    public double getMarketValue() {
        return getPurchasePrice()*0.8;
    }


    public static Computer input(Scanner sc) {
        System.out.print("Asset Code: ");
        String code = sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Purchase Price: ");
        double price = Double.parseDouble(sc.nextLine());

        System.out.print("RAM: ");
        int ram = Integer.parseInt(sc.nextLine());

        System.out.print("CPU: ");
        String cpu = sc.nextLine();

        return new Computer(code, name, price, ram, cpu);
    }


    @Override
    public String toString() {
        return "Computer{" +super.toString()+
                "ram=" + ram +
                ", cpu='" + cpu + '\'' +
                '}';
    }

}
