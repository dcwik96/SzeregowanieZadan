package ModJohnson;

public class Task {
    private int id;
    private int m1,m2,m3;
    private int t1, t2;

    public Task(int id, int m1, int m2, int m3, int t1, int t2) {
        this.id = id;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        this.t1 = t1;
        this.t2 = t2;
    }

    @Override
    public String toString() {
        return "Task " + id +" {" +
                "m1=" + m1 +
                ", m2=" + m2 +
                ", m3=" + m3 +
                ", t1=" + t1 +
                ", t2=" + t2 +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getM1() {
        return m1;
    }

    public void setM1(int m1) {
        this.m1 = m1;
    }

    public int getM2() {
        return m2;
    }

    public void setM2(int m2) {
        this.m2 = m2;
    }

    public int getM3() {
        return m3;
    }

    public void setM3(int m3) {
        this.m3 = m3;
    }

    public int getT1() {
        return t1;
    }

    public void setT1(int t1) {
        this.t1 = t1;
    }

    public int getT2() {
        return t2;
    }

    public void setT2(int t2) {
        this.t2 = t2;
    }
}
