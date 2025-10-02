package org.example;

public class Main {
    public static void main(String[] args) {
        Broker broker = new Broker();

        Observer agency1 = new StockAgency("Degiro ");
        Observer agency2 = new StockAgency("ING ");
        Observer agency3 = new StockAgency("Renta 4 ");

        broker.addObserver(agency1);
        broker.addObserver(agency2);
        broker.addObserver(agency3);

        broker.setStatus("Up");
        broker.setStatus("Down");
    }
}


