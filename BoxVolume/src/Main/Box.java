package Main;

public class Box {
    private double height;
    private double width;
    private double depth;

    public Box(double height, double width, double depth) {
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public double calcVolume() {
        double volume = this.height * this.depth * this.width;
        return volume;
    }

    @Override
    public String toString() {
        return "Box with dimensions: " +
                "height=" + height +
                ", width=" + width +
                ", depth=" + depth +
                " and voume " + calcVolume();
    }
}
