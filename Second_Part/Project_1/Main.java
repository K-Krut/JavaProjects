import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String []args) throws Exception {
        Point_Class point_1 = new Point_Class(23, 42);
        Rectangular rectangle_1 = new Rectangular(10.7, 20.8, 5.4, 3);
        System.out.printf("%s\n%s\n\n",point_1, rectangle_1);


//        getting_annotated_methods(rectangle_1);


//        getting_class_fields(rectangle_1);
//        getting_class_fields(point_1);


//        getting_method_by_name(rectangle_1, "toString");
//        getting_filed_by_name(rectangle_1, "width");

//        get_annotations(rectangle_1);

//        check_invocation(rectangle_1);
    }


    //        getting_class_methods(rectangle_1);
//        getting_class_methods(point_1);
    public static void getting_class_methods(Object object) throws Exception {
        System.out.println("getting_class_methods");
        for(Method method : object.getClass().getMethods()) {
            if (method.isAnnotationPresent(AnnotationReflectable.class)) {
                System.out.println(object.getClass().getSimpleName() + "." +
                        method.getName() + "() = " + method.invoke(object.getClass()));
            }
        }
        System.out.println();
    }


    public static void getting_class_fields(Object object) throws Exception {
        System.out.println("getting_class_fields");
        for(Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            System.out.println(object.getClass().getSimpleName() + "." + field.getName() + " = " + field.get(object) +
                    "\ntype: " + field.getType() + "\nmodifier: " + Modifier.toString(field.getModifiers()));
        }
        System.out.println();
    }

    public static void getting_annotated_methods(Object object) throws Exception {
        System.out.println("getting_annotated_methods");
        System.out.println(object.getClass().getSimpleName());
        for (Method method : object.getClass().getDeclaredMethods()) {
            for (Annotation annotation : method.getDeclaredAnnotations()) {
                System.out.println("\n" + annotation);
            }
            System.out.print(method.isAnnotationPresent(AnnotationReflectable.class) ?
                    method.getName() + "()\n\n" : method.getName() + "()\n"); //Arrays.toString(method.getTypeParameters())

        }
    }

    public static void getting_method_by_name(Object object, String name) throws Exception {
        System.out.println("getting_method_by_name");
        if (name.startsWith("set")) {
            throw new IllegalAccessException("Object immutable");
        }
        try {
            Method method = object.getClass().getDeclaredMethod(name);
            method.setAccessible(true);
            System.out.println(method.invoke(object));
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    public static void getting_filed_by_name(Object object, String name) throws Exception {
        System.out.println("getting_method_by_name");
        try {
            Field field = object.getClass().getDeclaredField(name);
            field.setAccessible(true);
            System.out.println(field.get(object));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void get_annotations(Object object) throws ClassNotFoundException {
        List<Field> annotatedFields = new LinkedList<Field>();
        for (Method method : object.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(AnnotationReflectable.class)){
                for (Annotation annotation : method.getDeclaredAnnotations()) {
                    System.out.println(annotation); // System.out.println(Arrays.toString(method.getAnnotations()));
                }
            }
        }
    }

    public static void check_invocation(Rectangular rectangular) throws Exception {
        System.out.println("check_invocation");
        Class<Virtual> object = Virtual.class;
        Virtual result = (Virtual) Proxy.newProxyInstance(object.getClassLoader(), new Class<?>[]{object},
                new ImmutableProxyInvocationHandler(rectangular));

        System.out.println(result.getHeight());
        result.setWidth(1.7);
    }

    static class ImmutableProxyInvocationHandler implements InvocationHandler {

        final Object target;

        ImmutableProxyInvocationHandler(Object ref) {
            this.target = ref;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.getName().startsWith("set")) {
                throw new RuntimeException("Object immutable");
            }
            return method.invoke(target, args);
        }
    }
}







//      public static String MethodsTypes(Method method) {
//        Class<?>[] parameterTypes = method.getParameterTypes();
//        for (int i = 0; i < parameterTypes.length; i++) {
//            if (i > 0) {
//                System.out.print(", ");
//            }
//            System.out.print(parameterTypes[i].getName());
//        }
//        return "";
//    }



//    public static void fun4(Object object) throws Exception {
//        System.out.println("# Project_1.Main.fun4");
//        Class<RegularPolygon> c = RegularPolygon.class;
//        RegularPolygon r = (RegularPolygon) Proxy.newProxyInstance(c.getClassLoader(), new Class<?>[]{c},
//                new Lab1.src.Project_1.Main.MyImmutableProxyInvocationHandler(new MyRegularPolygon(10, 20, 5, 3)));
//        System.out.println("r.getX() = " + r.getX());
//        System.out.println("r.getVertexCount() = " + r.getVertexCount());
//        r.setSide(123.4);
//    }
/*
    public static void getting_class_annotated_methods(Object object) throws Exception {
        for(Method method : object.getClass().getMethods()) {
            if (method.isAnnotationPresent(Project_1.AnnotationReflectable.class)) {
                System.out.println(Arrays.toString(method.getDeclaredAnnotations()) + " = " + method.invoke(point));
            }
        }
        System.out.println();
    }
    */
//
//    public static void getting_class_fields(Project_1.Rectangular rectangular) throws Exception {
//        for(Field field : rectangular.getClass().getDeclaredFields()) {
//            field.setAccessible(true);
//            System.out.println("rectangle." + field.getName() + " = " + field.get(rectangular));
//        }
//        System.out.println();
//    }