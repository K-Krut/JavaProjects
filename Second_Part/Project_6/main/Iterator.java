public interface Iterator {
    boolean hasnext();
    Object next();
}
interface Container {
    Iterator getIterator(String name);
}
