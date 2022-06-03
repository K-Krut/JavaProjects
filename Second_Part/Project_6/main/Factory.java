public class Factory {

    Point_Class point;
    Rectangular rectangular;


    public Factory(Point_Class point, Rectangular rectangular) {
        this.point = point;
        this.rectangular = rectangular;
    }


    public Virtual create(String name, Double x, Double y, Double height, Double width) {
        switch (name) {
            case "Point": {
                point.x = x;
                point.y = y;

                return point;
            }

            case "Rectangular": {
                rectangular.x = x;
                rectangular.y = y;
                rectangular.height = height;
                rectangular.width = width;

                return rectangular;
            }

            default: return null;
        }
    }
}
