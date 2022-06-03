import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import org.apache.commons.lang3.StringUtils;


public class Controller implements Command {

    View view ;
    Model model ;
    StrategyPoint strategyPoint;
    StrategyRectangular strategyRectangular;
    ContextStrategy contextStrategy;

    public Controller(View view, Model model, StrategyPoint strategyPoint, StrategyRectangular strategyRectangular, ContextStrategy contextStrategy) {
        this.view = view;
        this.model = model;
        this.strategyPoint = strategyPoint;
        this.strategyRectangular = strategyRectangular;
        this.contextStrategy = contextStrategy;
    }

    @Override
    public void execute(Double x, Double y, Double height, Double width) throws Exception {
        strategyRectangular.controller = this;
        strategyRectangular.model = model;
        strategyPoint.controller = this;
        strategyPoint.model = model;
        contextStrategy.strategy = strategyRectangular;
        contextStrategy.ActivateAction(x, y, height, width);
        contextStrategy.strategy = strategyPoint;
        contextStrategy.ActivateAction(x, y, height, width);
    }

    void ToString (Object object) {
        view.toStringObj(object);
    }

    void ProxyObject(Object object){
        view.proxyView((Virtual) Proxy.newProxyInstance(object));
    }

    double AnnotationMethodInvoke(Object PointObject, Class clazz) {
        for(Method method: clazz.getDeclaredMethods()) {
            Annotation annotation = method.getAnnotation(AnnotationReflectable.class);
            if (annotation != null && annotation.annotationType() == AnnotationReflectable.class) {
                Object[] params = new Object[method.getParameterTypes().length];
                try {
                    view.annotationInvokeView((double) method.invoke(PointObject, params));
                    return (double) method.invoke(PointObject, params);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }

    String NameClass(Class obj) {
        view.classNameView(obj.getName());
        return obj.getName();
    }

    StringBuffer gettingClassFields(Object object) {

        StringBuffer stringBuffer = new StringBuffer();

        try {
            for (Field field : object.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                stringBuffer.append(object.getClass().getSimpleName() + "." + field.getName() + " = " + field.get(object) +
                        "\ttype: " + field.getType() + "\tmodifier: " + Modifier.toString(field.getModifiers()) + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        view.fieldsView(stringBuffer);
        return stringBuffer;
    }

    StringBuffer gettingClassMethods(Object object) throws Exception {
        StringBuffer stringBuffer = new StringBuffer();
        for (Method method : object.getClass().getMethods()) {
            if (method.isAnnotationPresent(AnnotationReflectable.class)) {
                method.setAccessible(true);
                stringBuffer.append(object.getClass().getSimpleName() + "." +
                        method.getName() + "(" + get_types(method) + ") = " + method.invoke(object) + "\n");
            }
        }
        view.methodsView(stringBuffer);
        return stringBuffer;
    }

    StringBuffer getAnnotations(Object object) throws Exception {
        StringBuffer stringBuffer = new StringBuffer();
        for (Method method : object.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(AnnotationReflectable.class)){
                for (Annotation annotation : method.getDeclaredAnnotations()) {
                    stringBuffer.append(annotation + "\n"); // System.out.println(Arrays.toString(method.getAnnotations()));
                }
            }
        }
        view.annotationsView(stringBuffer);
        return stringBuffer;
    }

    String gettingClassModifier(Object object) {
        String modifierName = Modifier.toString(object.getClass().getModifiers());
        view.modifiersView(modifierName);
        return modifierName;
    }

    StringBuffer gettingInterfaces(Class clazz) {

        StringBuffer stringBuffer = new StringBuffer();

        for (Class inter : clazz.getInterfaces()) {
            stringBuffer.append(inter.getName() + " ");
        }

        view.interfacesView(stringBuffer);
        return stringBuffer;
    }

    StringBuffer getConstructors(Object object) {

        StringBuffer stringBuffer = new StringBuffer();

        for (Constructor<?> constructor : object.getClass().getConstructors()) {
            stringBuffer.append(constructor.getName() + "(" + get_types(constructor) + ")\n");
        }

        view.constructorsView(stringBuffer);
        return stringBuffer;
    }

    public static String get_types(Constructor<?> constructor) {
        return StringUtils.join(constructor.getParameterTypes(), ", ");
    }

    public static String get_types(Method method) {
        return StringUtils.join(method.getParameterTypes(), ", ");
    }
}



/*

    public static ArrayList<String> getting_class_methods(Object object) throws Exception {
        ArrayList<String> kek = new ArrayList<>();
        for (Method method : object.getClass().getMethods()) {
            if (method.isAnnotationPresent(AnnotationReflectable.class)) {
                method.setAccessible(true);
                kek.add(object.getClass().getSimpleName() + "." +
                        method.getName() + "(" + get_types(method) + ") = " + method.invoke(object));
            }
        }
        kek.sort(Comparator.naturalOrder());
        return kek;
    }

    public static ArrayList<String> (Object object) throws Exception {
        ArrayList<String> kek = new ArrayList<>();
        for(Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            kek.add(object.getClass().getSimpleName() + "." + field.getName() + " = " + field.get(object) +
                    "\ntype: " + field.getType() + "\nmodifier: " + Modifier.toString(field.getModifiers()));
        }
        kek.sort(Comparator.naturalOrder());
        return kek;
    }

    public static String getting_annotated_methods(Object object) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        for (Method method : object.getClass().getDeclaredMethods()) {
            list.add((!Objects.equals(getting_annotation(method), "") ? getting_annotation(method) + "\n" : "") + (method.isAnnotationPresent(AnnotationReflectable.class) ?
                    method.getName() + "()\n\n" : method.getName() + "()\n")); //Arrays.toString(method.getTypeParameters())
        }
        list.sort(Comparator.naturalOrder());
        return StringUtils.join(list.toArray());
    }

    public static String getting_annotation(Method method) {
        ArrayList<Annotation> list = new ArrayList<>();
        Collections.addAll(list, method.getDeclaredAnnotations());
        return StringUtils.join(list.toArray());
    }

    public static void getting_method_by_name(Object object, String name) throws Exception {
        System.out.println("getting_method_by_name");
        if (name.startsWith("set")) {
            throw new IllegalAccessException("Object immutable");
        }
        try {
            Method method = object.getClass().getDeclaredMethod(name);
            method.setAccessible(true);
            System.out.println(method.getName() + " --> " + method.invoke(object));
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void getting_filed_by_name(Object object, String name) throws Exception {
        System.out.println("getting_method_by_name");
        try {
            Field field = object.getClass().getDeclaredField(name);
            field.setAccessible(true);
            System.out.println(field.getName() + " = " + field.get(object));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void get_annotations(Object object) throws ClassNotFoundException {
        for (Method method : object.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(AnnotationReflectable.class)){
                for (Annotation annotation : method.getDeclaredAnnotations()) {
                    System.out.println(annotation); // System.out.println(Arrays.toString(method.getAnnotations()));
                }
            }
        }
    }

    public static void get_constructors(Object object) {
        for (Constructor<?> constructor : object.getClass().getConstructors()) {
            System.out.println(constructor.getName() + "(" + get_types(constructor) + ")");
        }
    }

    public static String get_types(Constructor<?> constructor) {
        return StringUtils.join(constructor.getParameterTypes(), ", ");
    }

    public static String get_types(Method method) {
        return StringUtils.join(method.getParameterTypes(), ", ");
    }

    public static void Rectangle_constructor_test() {
        try {
            Class[] params = {double.class, double.class, double.class, double.class};
            System.out.println(Class.forName(Rectangular.class.getName()).
                    getConstructor(params).newInstance(5.55,8.2,8.4, 4.1));
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }
*/
