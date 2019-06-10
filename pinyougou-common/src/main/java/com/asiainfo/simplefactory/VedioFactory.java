package com.asiainfo.simplefactory;

public class VedioFactory {

    public static Vedio getVedio(Class c){
        Vedio vedio = null;
        try {
            vedio = (Vedio) Class.forName(c.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return vedio;
    }
}
