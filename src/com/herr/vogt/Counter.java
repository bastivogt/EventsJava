package com.herr.vogt;

public class Counter {

    protected int start, end, step, count;

    protected CounterStartListener counterStartListener = null;
    protected CounterChangeListener counterChangeListener = null;
    protected CounterFinishListener counterFinishListener = null;




    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getStep() {
        return step;
    }

    public int getCount() {
        return count;
    }


    public void setOnCounterStartListener(CounterStartListener listener) {
        counterStartListener = listener;
    }

    public void removeOnCounterStartListener() {
        counterStartListener = null;
    }



    public void setOnCounterChangeListener(CounterChangeListener listener) {
        counterChangeListener = listener;
    }

    public void removeOnCounterChangeListener() {
        counterChangeListener = null;
    }


    public void setOnCounterFinishListener(CounterFinishListener listener) {
        counterFinishListener = listener;
    }

    public void removeOnCounterFinishListener() {
        counterStartListener = null;
    }




    protected void fireCounterStart(Event e) {
        if(counterStartListener != null) {
            counterStartListener.counterStart(e);
        }
    }

    protected void fireCounterChange(Event e) {
        if(counterChangeListener != null) {
            counterChangeListener.counterChange(e);
        }
    }

    protected void fireCounterFinish(Event e) {
        if(counterFinishListener != null) {
            counterFinishListener.counterFinish(e);
        }
    }


    public Counter(int start, int end, int step) {
        reset(start, end, step);

    }

    public Counter(int start, int end) {
        this(start, end, 1);
    }

    public Counter() {
        this(0, 10, 1);
    }



    public void run() {
        fireCounterStart(new Event(this));
        for(; count < end; count += step) {
            fireCounterChange(new Event(this));
        }
        fireCounterFinish(new Event(this));
    }


    public void reset(int start, int end, int step) {
        this.start = start;
        this.end = end;
        this.step = step;
        count = 0;
    }
}
