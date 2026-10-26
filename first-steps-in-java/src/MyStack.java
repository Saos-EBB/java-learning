import java.util.Scanner;

class MyStack {
    private double[] data = new double[1];// tablet größe ist != teller auf dem stapel
    private int size = 0; // trackt wie viele teller am stapel sind

    public void push(double x) {
        if (size == data.length) resize();
        data[size++] = x;
    }

    public double pop() {
        if (size == 0) throw new IllegalStateException("Stack empty!");
        return remove(size - 1);
    }

    public double peek() {
        if (size == 0) throw new IllegalStateException("Stack empty!");
        return data[size - 1];
    }

    public double peek(int indexFromTop) {
        if (indexFromTop < 0 || indexFromTop >= size) {
            throw new IndexOutOfBoundsException("Invalid index for peek");
        }
        return data[size - 1 - indexFromTop];
    }

    public double remove(int idx) {
        if (idx < 0 || idx >= size) throw new IndexOutOfBoundsException("Invalid index: " + idx);
        double removed = data[idx];
        for (int i = idx; i < size - 1; i++) data[i] = data[i + 1];
        size--;
        return removed;
    }

    public int size() {
        return size; // wie viele teller
    }

    public void clear() {
        size = 0;
    }

    public String print() {
        String s = "";
        for (int i = 0; i < size; i++) s += data[i] + " ";
        return s;
    }

    @Override
    public String toString() {
        if (size == 0) return "[ ]";
        String s = "[ ";
        for (int i = 0; i < size; i++) s += data[i] + ", ";
        s = s.substring(0, s.length() - 2) + " ]";
        return s;
    }

    private void resize() {
        double[] temp = new double[data.length * 2]; // tablett vergrößern
        for (int i = 0; i < data.length; i++) temp[i] = data[i];
        data = temp;
    }
}
