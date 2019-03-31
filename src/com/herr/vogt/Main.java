package com.herr.vogt;



public class Main {



    public static void main(String[] args) {

        CounterChangeListener counterChange = (Event e) -> {
            Counter c = (Counter) e.getSource();
            System.out.println("counterChange " + c.getCount());
        };

        Counter counter = new Counter();

        counter.setOnCounterStartListener(new CounterStartListener() {
            @Override
            public void counterStart(Event e) {
                Counter c = (Counter)e.getSource();
                System.out.println("counterStart " + c.getCount());
            }
        });

        counter.setOnCounterChangeListener(counterChange);

        counter.setOnCounterFinishListener((Event e) -> {
            Counter c = (Counter) e.getSource();
            System.out.println("counterFinish " + c.getCount());
        });



        counter.run();



    }
}
