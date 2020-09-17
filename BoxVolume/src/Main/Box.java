package Main;

public class Box {
    private double height;
    private double width;
    private double depth;
    private double volume;

    public Box(double height, double width, double depth) {
        this.height = height;
        this.width = width;
        this.depth = depth;
        volume=calcVolume();
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
        volume=calcVolume();
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
        volume=calcVolume();
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
        volume=calcVolume();
    }

    public double getVolume() {
        return volume;
    }

    private double calcVolume() {
        return height*depth*width;
    }

    @Override
    public String toString() {
        return "Box with dimensions: " +
                "height=" + height +
                ", width=" + width +
                ", depth=" + depth +
                " with volume of "+volume;
    }
}
