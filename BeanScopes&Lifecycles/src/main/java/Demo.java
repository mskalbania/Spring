import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("SpringContext.xml");

        SingletonExample singleton1 = context.getBean("singleton", SingletonExample.class);
        SingletonExample singleton2 = context.getBean("singleton", SingletonExample.class);

        singleton1.setParameter(100);
        //sig1 and sig 2 refers to the same object
        System.out.println("NOW BOTH SHOULD SHOW 100 ->  S1: " + singleton1 + ", S2: " + singleton2);
        System.out.println("IS SAME OBJECT " + singleton1.equals(singleton2));

        PrototypeExample prototype1 = context.getBean("prototype", PrototypeExample.class);
        PrototypeExample prototype2 = context.getBean("prototype", PrototypeExample.class);

        //setting 1
        prototype1.setParameter(100);
        prototype2.setParameter(200);
        System.out.println("DIFFERENT OBJECTS -> P1: " + prototype1.getParameter() + ", P2: " + prototype2.getParameter());
        System.out.println("IS SAME OBJECT " + prototype1.equals(prototype2));

        System.out.println();

        for(int i = 0; i < 5; i++){
            System.out.println(context.getBean("prototype",PrototypeExample.class));
        }

        context.close();
    }
}
