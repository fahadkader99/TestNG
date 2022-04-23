package test.java.utils;

import org.apache.poi.xssf.usermodel.*;
import org.testng.annotations.Test;

import java.io.*;

public class Files {

    // This class is for won reference || not part of the requirements.

    @Test(enabled = false)
    public static void write_File() throws Exception{

        File file = new File("/Users/fahadkader/Desktop/Git/TestNG/MRO_QA_Automation/src/test/resources/data/summary.txt");
        FileWriter fw = new FileWriter(file);
        BufferedWriter writer = new BufferedWriter(fw);

        writer.write("Hello This is Ashikul Fahad");
        writer.newLine();
        writer.write("The event is pending at this moment");
        writer.close();

    }


    @Test
    public static void readFile2() throws Exception{

        File file = new File("/Users/fahadkader/Desktop/Git/TestNG/MRO_QA_Automation/src/test/resources/data/summary.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String v;
        // save the read-line int he v variable and keep rotating until the last line in null
        while ((v=br.readLine())!=null){
            System.out.println(v);
        }


    }
    @Test
    public static void write_to_excel() throws Exception{

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("write_test");

        sheet.createRow(0);
        sheet.getRow(0).createCell(0).setCellValue("Hello");
        sheet.getRow(0).createCell(1).setCellValue("World");

        sheet.createRow(1);
        sheet.getRow(1).createCell(0).setCellValue("Pass");
        sheet.getRow(1).createCell(1).setCellValue("Fail");

        File file = new File("src/test/resources/data/write_test.xlsx");
        FileOutputStream fos = new FileOutputStream(file);
        workbook.write(fos);

        workbook.close();
    }

    @Test
    public static void read_from_excel() throws Exception{
        File src = new File("src/test/resources/data/write_test.xlsx");
        FileInputStream fis = new FileInputStream(src);

        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);

        String data1 = sheet.getRow(0).getCell(0).getStringCellValue();
        String data2 = sheet.getRow(0).getCell(1).getStringCellValue();
        String data3 = sheet.getRow(1).getCell(0).getStringCellValue();
        String data4 = sheet.getRow(1).getCell(1).getStringCellValue();

        System.out.println(data1+" "+ data2+" "+data3+" "+ data4);
    }


}
