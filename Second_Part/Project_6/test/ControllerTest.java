import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ControllerTest {

    Controller controller = Mockito.mock(Controller.class);
    Point_Class point = Mockito.mock(Point_Class.class);
    Rectangular rectangular = Mockito.mock(Rectangular.class);
    Rectangular rectangularObject = new Rectangular(9, 9, 9, 9);
    Point_Class pointObject = new Point_Class(9, 9);
    StringBuffer kek = new StringBuffer("kek");
    StringBuffer kekekek = new StringBuffer("mda");


    @Test
    void annotationMethodInvoke() {
        Point_Class point = new Point_Class(1, 1);
        Mockito.when(controller.AnnotationMethodInvoke(point, Point_Class.class)).thenReturn(1.);
        assertEquals(controller.AnnotationMethodInvoke(point, Point_Class.class), 1.);
        controller.AnnotationMethodInvoke(rectangular, Rectangular.class);
        Mockito.verify(controller).AnnotationMethodInvoke(rectangular, Rectangular.class);
    }

    @Test
    void nameClass() {
        Mockito.when(controller.NameClass(Point_Class.class)).thenReturn("P");
        assertEquals(controller.NameClass(Point_Class.class), "P");
        assertNotEquals(controller.NameClass(Point_Class.class), "R");
        controller.NameClass(Rectangular.class);
        Mockito.verify(controller).NameClass(Rectangular.class);
    }

    @Test
    void gettingClassFields() {
        Mockito.when(controller.gettingClassFields(rectangularObject)).thenReturn(kek);
        assertEquals(controller.gettingClassFields(rectangularObject), kek);
    }

    @Test
    void gettingClassMethods() throws Exception {
        Mockito.when(controller.gettingClassMethods(rectangularObject)).thenReturn(kek);
        assertEquals(controller.gettingClassMethods(rectangularObject), kek);
    }

    @Test
    void getAnnotations() throws Exception {
        Mockito.when(controller.getAnnotations(rectangular)).thenReturn(kek);
        assertEquals(controller.getAnnotations(rectangular), kek);
    }

    @Test
    void gettingClassModifier() {
        Mockito.when(controller.gettingClassModifier(rectangular)).thenReturn("KEK");
        assertEquals(controller.gettingClassModifier(rectangular), "KEK");
    }

    @Test
    void gettingInterfaces() {
        Mockito.when(controller.gettingInterfaces(Rectangular.class)).thenReturn(kek);
        assertEquals(controller.gettingInterfaces(Rectangular.class), kek);
    }

    @Test
    void getConstructors() {
        Mockito.when(controller.getConstructors(rectangularObject)).thenReturn(kek);
        assertEquals(controller.getConstructors(rectangularObject), kek);
        assertNotEquals(controller.getConstructors(rectangularObject), kekekek);
    }
}