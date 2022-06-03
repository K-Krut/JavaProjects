class StrategyPoint implements Strategy {

    Controller controller;
    Model model;


    @Override
    public void Action(Double x, Double y, Double height, Double width) {

        Point_Class PointObject = model.Point_Class(x,y);

        controller.AnnotationMethodInvoke(PointObject, Point_Class.class);
        controller.ToString(PointObject);
        controller.gettingClassModifier(PointObject);
        controller.getConstructors(PointObject);
        controller.gettingClassFields(PointObject);
        controller.NameClass(Point_Class.class);
        controller.gettingInterfaces(Point_Class.class);
        controller.ProxyObject(PointObject);

        System.out.println();
        System.out.println("Iterator: ");
        Iterator iterator = model.getIterator("Point");

        while (iterator.hasnext()) {
            System.out.println(iterator.next());
        }
    }
}
