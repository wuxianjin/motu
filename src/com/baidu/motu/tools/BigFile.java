package com.baidu.motu.tools;

import java.io.FileNotFoundException;
import java.io.IOException;

public class BigFile {

	public static void main(String[] args)
    {
        try {
            long lo = System.currentTimeMillis();
            java.io.RandomAccessFile raf = new java.io.RandomAccessFile("d:/abc.txt", "rw");
           //1G
            raf.setLength(1024 * 1024 * 1024 );
            raf.close();
        
            System.out.print(System.currentTimeMillis() - lo);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}
