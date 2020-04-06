package by.gsu.pms;

public class UniformMaterial {
    private String name;
    private int density;

    UniformMaterial() {}

    public UniformMaterial(String name, int density) {
        this.name = name;
        this.density = density;
    }

    public String getName() {
        return name;
    }

    public int getDensity() {
        return density;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDensity(int density) {
        this.density = density;
    }

    @Override
    public String toString() {
        return name + ";" + density;
    }
}
