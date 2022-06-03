import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@SpringBootApplication
public class ApplicationProject6 {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        Release release = context.getBean("release", Release.class);
        release.AddCommand(context.getBean("controller", Controller.class));
        release.RunCommand();

    }
}
