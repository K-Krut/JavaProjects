public class View {

    public void toStringObj(Object object) {
        System.out.println(object.toString());
    }

    public void annotationInvokeView(double annotation) {
        System.out.println("Annotation methods invoke " + annotation + "\n");
    }

    public void methodsView(StringBuffer methods) {
        System.out.println("Methods:\n" + methods + "\n");
    }

    public void annotationsView(StringBuffer methods) {
        System.out.println("Annotations:\n" + methods + "\n");
    }

    public void classNameView(String nameClass) {
        System.out.println("Class Name : " + nameClass+ "\n");
    }

    public void fieldsView(StringBuffer fields) {
        System.out.println("Class Fields:\n" + fields.toString() + "\n");
    }

    public void modifiersView(String modifierClass) {
        System.out.println("Class Modifier: " + modifierClass + "\n");
    }

    public void constructorsView(StringBuffer constructors) {
        System.out.println("Constructors:\n" + constructors.toString() + "\n");
    }

    public void interfacesView(StringBuffer interfaces) {
        System.out.println("Class Interfaces: " + interfaces.toString() + "\n");
    }

    public void proxyView(Virtual proxy) {
        System.out.println("Proxy: " + proxy.getInterface());
    }
}
