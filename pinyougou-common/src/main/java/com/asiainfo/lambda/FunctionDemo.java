package com.asiainfo.lambda;

import java.text.DecimalFormat;
import java.util.function.Function;

public class FunctionDemo {

    public static class MyMoney {
        private int myMoney;

        public MyMoney(int myMoney) {
            this.myMoney = myMoney;
        }

        public void printMoney(Function<Integer,String> formatFunction){
            System.out.println("我的存款: "+formatFunction.apply(myMoney));
        }
    }

    public static void main(String[] args) {
        MyMoney myMoney = new MyMoney(999999);
        Function<Integer,String> formatFunction = i -> new DecimalFormat("#,###").format(i);
        myMoney.printMoney(formatFunction.andThen(s -> "人民币"+s));
    }
}
