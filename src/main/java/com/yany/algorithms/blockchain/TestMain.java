package com.yany.algorithms.blockchain;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by yanyong on 2017/12/5.
 */
public class TestMain {

    public static void main(String[] args) throws Exception{
        String text = "10992,19676,24267,24270,24270";
        System.out.println(text.indexOf(String.valueOf(10992)));

        File file = new File("/Users/yanyong/Downloads/c");
        if(!file.exists()){
            file.mkdirs();
        }


    }


}
