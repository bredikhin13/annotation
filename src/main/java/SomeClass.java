import java.awt.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by User on 08.12.2015.
 */
public class SomeClass {
    @Target(value = ElementType.FIELD)
    @Retention(value = RetentionPolicy.RUNTIME)
    public @interface TargetField{

    }
    public FirstInterface a;
    public int b;

    @TargetField
    public FirstInterface c;

    @TargetField
    private FirstInterface d;

    @TargetField
    private SecondInterface r;

    private int e;
    private int f;
    public void doSome(){
        c.doSomething();
        d.doSomething();
        r.doOtherSomething();
    }

}