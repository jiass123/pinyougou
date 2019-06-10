package com.asiainfo.lambda;

@FunctionalInterface
interface IMath{
    int add(Integer x , Integer y);
}

public class TypeDemo {

    public static void main(String[] args) {
        IMath iMath = (x, y)-> x+y;
        IMath iMath1 = (x,y)->{
            return x+y;
        };
        Object iMath2 = (IMath)(x, y)-> x+y;
        IMath iMath3 = createLambda();
        TypeDemo demo = new TypeDemo();
        demo.test((x,y)->x+y);
    }

    public void test(IMath iMath){

    }

    private static IMath createLambda() {
        return (x,y)->x+y;
    }
}
