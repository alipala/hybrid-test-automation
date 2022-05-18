package ais.utilities;

import net.thucydides.core.annotations.Managed;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;


/**
 * Utility class is a common usage class.
 * It mainly contains methods are used by different tests:
 *
 * @author  Ali Pala
 * @version 1.0
 */

public class Utilities {

    @Managed
    static
    WebDriver driver;

    // Test data directory for csv files on windows OS
    public static final String TEST_DATA_DIR_WINDOWS = System.getProperty("user.dir")+"\\src\\test\\resources\\assets\\test_data\\";

    // Test data directory for csv files on linux OS
    public static final String TEST_DATA_DIR = System.getProperty("user.dir")+"/src/test/resources/assets/test_data/";


    /**
     * This method is used to get the latest file from a specific directory
     * @param dirPath directory of the file
     * @return
     */
    public static File getLatestFilefrom(String dirPath){
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            return null;
        }

        File lastModifiedFile = files[0];
        for (int i = 1; i < files.length; i++) {
            if (lastModifiedFile.lastModified() < files[i].lastModified()) {
                lastModifiedFile = files[i];
            }
        }
        return lastModifiedFile;
    }

    /**
     * This method is used to read the Excel sheet in an Excel file and returns the row count
     * @param filePath path of the file
     * @param fileName name of the file
     * @param sheetName SheetName of the Excel file
     * @return row count
     * @throws IOException
     */
    public static int readExcelRowCount(String filePath, String fileName, String sheetName) throws IOException {
        //Create an object of File class to open xlsx file
        File file = new File(filePath + "\\" + fileName);
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook aisWorkBook = null;
        aisWorkBook = new XSSFWorkbook(inputStream);

        //Read sheet inside the workbook by its name
        XSSFSheet workBookSheet = aisWorkBook.getSheet(sheetName);

        //Find number of rows in excel file
        int rowCount = workBookSheet.getLastRowNum() - workBookSheet.getFirstRowNum();

        return rowCount;
    }

    /**
     * This method is used to delete a file in the directory
     * @param directory to be deleted
     */
    public static void deleteFile(String directory) {
        try {
            Files.deleteIfExists(
                    Paths.get(directory));
        }
        catch (NoSuchFileException e) {
            System.out.println(
                    "No such file/directory exists");
        }
        catch (DirectoryNotEmptyException e) {
            System.out.println("Directory is not empty.");
        }
        catch (IOException e) {
            System.out.println("Invalid permissions.");
        }
        System.out.println("Deletion successful.");
    }

    /**
     * This method works for waiting specified time
     * @param time to wait for ms
     */
    public static void waitFor(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
