public class SingletonExample {

    private int parameter;

    public void setParameter(int parameter) {
        this.parameter = parameter;
    }

    public void initMethod(){
        System.out.println("--------INIT METHOD INVOKED--------");
    }

    public void destroyMethod(){
        System.out.println("--------DESTROY METHOD INVOKED--------");
    }

    @Override
    public String toString(){
        return "Value" + this.parameter;
    }
}
