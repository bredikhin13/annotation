import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by User on 08.12.2015.
 */
public class Inject {
    public <T> T Injector(T obj) {
        List<Field> fieldList = new ArrayList<Field>();
        for (Field f : obj.getClass().getDeclaredFields()) {
            if (f.isAnnotationPresent(SomeClass.TargetField.class)) {
                System.out.println(f.getName().toString());
                fieldList.add(f);
            }
        }

        try {
            Properties pr = new Properties();
            pr.load(new FileInputStream(new File("C:\\Users\\User\\Documents\\GitHub\\annotation\\src\\main\\java\\prop")));

            for (Field f : fieldList) {
                Class c = Class.forName(pr.getProperty(f.getType().getName().toString()));
                f.setAccessible(true);
                f.set(obj, c.newInstance());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return obj;
    }



}
