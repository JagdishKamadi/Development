/*
    Important rule fo lambda expression
    1) only we can use with function interface ( function interface means only having one method in interface)
    2) Also it does not create the class file for that interface
    3) input data type is optional in lambda expression
    */

interface LambdaInterface
    {
        void show();
}

interface LambdaInterfaceWithParam
{
    void show(int a,int b);
}

public class LambdaMethodTest {
    public static void main(String[] args) {
        // we cannot create the object of lambda expression
        // that why we are using the lambda expression

        // first example of lambda expression
        LambdaInterface lambdaInterface1 = ()-> System.out.println("Hello Jagdish");
        lambdaInterface1.show();

        // another way of doing
        LambdaInterface lambdaInterface2 = ()-> {
            System.out.println("Also, It is valid");
        };
        lambdaInterface2.show();

        // let's see  some more example
        // valid way
        LambdaInterfaceWithParam lambdaInterfaceWithParam = (a,b)->
                System.out.println("Value1 "+a+" : Value2 "+b);

        lambdaInterfaceWithParam.show(4,5);

        // another valid way
        LambdaInterfaceWithParam lambdaInterfaceWithParam1 = (int a,int b)->
        {
          System.out.println("With curly braces");
        };

        lambdaInterfaceWithParam1.show(5,6);

    }
}
