package gofood;

public enum Constants {

    PIZZA(150f), BURGER(100f), COKE(50f), SPECIAL_DAY(50f), PEAK_HOUR(30f),
    NIGHT_CHARGES(20f), NORMAL_CHARGES(20f), GST(5f);

    public final static Float minimumOrder = 300f;
    Float val;

    Constants(float v) {
        val = v;
    }

    public Float getVal() {
        return val;
    }

    public void setVal(Float val) {
        this.val = val;
    }
}
