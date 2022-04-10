import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class Proxy implements InvocationHandler {
    private Object ref;
    private Proxy(Object ref) {
        this.ref = ref;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().startsWith("get")) {
            return method.invoke(ref, args);
        }
        throw new IllegalAccessException("Not allowed");
    }

    public static Object newProxyInstance(Object obj) {
        return java.lang.reflect.Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                new Proxy(obj));
    }
}

