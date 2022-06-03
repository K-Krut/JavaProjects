class StrategyRectangular implements Strategy {

    Controller controller;
    Model model;

    @Override
    public void Action(Double x, Double y, Double height, Double width) {

        Rectangular RectangularObject = model.Rectangular(x, y, height, width);

        controller.AnnotationMethodInvoke(RectangularObject, Rectangular.class);
        controller.ToString(RectangularObject);
        controller.gettingClassModifier(RectangularObject);
        controller.getConstructors(RectangularObject);
        controller.gettingClassFields(RectangularObject);
        controller.NameClass(Rectangular.class);
        controller.gettingInterfaces(Rectangular.class);
        controller.ProxyObject(RectangularObject);

        System.out.println();

        Iterator iterator = model.getIterator("Rectangular");

        while (iterator.hasnext()) {
            System.out.println(iterator.next());
        }
    }
}
