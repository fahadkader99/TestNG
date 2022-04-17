package test.java.utils;

import org.testng.annotations.Test;

import java.io.*;

public class Files {

    @Test(enabled = false)
    public static void writeFile() throws Exception{

        File file = new File("/Users/fahadkader/Desktop/Git/TestNG/MRO_QA_Automation/src/test/resources/data/summary.txt");
        FileWriter fw = new FileWriter(file);
        BufferedWriter writer = new BufferedWriter(fw);

        writer.write("Hello This is Ashikul Fahad");
        writer.newLine();
        writer.write("The event is pending at this moment");
        writer.close();

    }

    @Test
    public static void readFile1() throws Exception{

        //FileInputStream fis = new FileInputStream("/Users/fahadkader/Desktop/Git/TestNG/MRO_QA_Automation/src/test/resources/data/summary.txt");
        File file = new File("/Users/fahadkader/Desktop/Git/TestNG/MRO_QA_Automation/src/test/resources/data/summary.txt");
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);

        while (reader.readLine()!=null){
            String str = reader.readLine();
            System.out.println(str);
        }


    }

    @Test
    public static void readFile2() throws Exception{

        File file = new File("/Users/fahadkader/Desktop/Git/TestNG/MRO_QA_Automation/src/test/resources/data/summary.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String v;
        // save the readline int he v variable and keep rotating until the last line in null
        while ((v=br.readLine())!=null){
            System.out.println(v);
        }


    }
}
