package com.epam.lesson.finalize;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class FinalizeExample {
    private OutputStream stream = null;

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Hello, I'm finalize");
        if (stream != null) {
            stream.close();
        }
    }

    public static void main(String[] args) {
        OutputStream stream = null;
        try {
            stream = new FileOutputStream(new File("/tmp"));
        }
        catch (Exception e){}
        finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (Exception e) {}
            }
        }

        System.runFinalization();
        //Runtime.getRuntime().addShutdownHook();

        try (OutputStream stream1 = new FileOutputStream(new File(""))) {

        } catch (Exception e){}
    }
}
