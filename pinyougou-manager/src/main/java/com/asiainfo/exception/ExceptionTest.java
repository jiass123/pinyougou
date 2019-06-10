package com.asiainfo.exception;

public class ExceptionTest {

    public static void main(String[] args) {
//        try{
//            System.out.println("开始");
//            int i = 1/0;
//            System.err.println("通过");
//        }catch (Exception e){
//            System.err.println("异常");
//        }finally {
//            System.err.println("finally");
//        }
//        System.out.println("结束");


        while (true) {
            System.out.println("循环");
            try {
                int i = 1 / 0;
            } catch (Exception e) {
                System.err.println("finally");
            }
            System.out.println("结束");
            System.out.println("结束循环");
        }

    }
}
