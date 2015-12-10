/**
 * Created by User on 08.12.2015.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");
        //SomeClass someClass = new SomeClass();
        Inject inject = new Inject();
        SomeClass someClass = inject.Injector( new SomeClass());
        someClass.doSome();


    }
}
