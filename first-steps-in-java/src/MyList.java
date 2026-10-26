public class MyList {

    public   double[] data = new double[1];
    public   int size = 0;


    public void add(double v) {
        if (size == data.length) resize();
        data[size] = v;
        size++;
    }

    public  void add(int pos, double v) {
        if (pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException("Ungültiger Index: " + pos);
        }

        if (size == data.length) resize();

        for (int i = size; i > pos; i--) {
            data[i] = data[i - 1];
        }

        data[pos] = v;
        size++;
    }

    public  double get(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException("Ungültiger Index: " + idx);
        }
        return data[idx];
    }

    public  double remove(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException("Ungültiger Index: " + idx);
        }

        double removed = data[idx];

        for (int i = idx; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        size--;
        return removed;
    }

    public int size() {
        return size;
    }

    public void clear() {
        size = 0;
    }

    public String print() {
        String s = "";
        for (int i = 0; i < size; i++) {
            s += data[i] + " ";
        }
        return s;
    }

    private void resize() {
        double[] temp = new double[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }
}
