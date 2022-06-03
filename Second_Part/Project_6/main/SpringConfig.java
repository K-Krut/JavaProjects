import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public View view() {
        return new View();
    }

    @Bean
    public Point_Class point() {
        return new Point_Class();
    }

    @Bean
    public Rectangular rectangular() {
        return new Rectangular();
    }

    @Bean
    public Factory factory() {
        return new Factory(point(), rectangular());
    }

    @Bean
    public Model model() {
        return new Model(factory());
    }

    @Bean
    public StrategyRectangular strategyRectangular() {
        return new StrategyRectangular();
    }

    @Bean
    public StrategyPoint strategyPoint() {
        return new StrategyPoint();
    }

    @Bean
    public ContextStrategy contextStrategy() {
        return new ContextStrategy();
    }
    @Bean
    public Controller controller(){
        return new Controller(view(),model(),strategyPoint(),strategyRectangular(),contextStrategy());
    }

    @Bean
    public Release release(){
        return new Release();
    }

    @Bean
    public ProxxyPattern proxxyPattern(){
        return new ProxxyPattern(controller());
    }


}
