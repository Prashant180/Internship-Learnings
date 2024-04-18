import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FromExcel {
    public static void main(String[] args) {
        try{
            FileInputStream file=new FileInputStream(new File("d:/studentsdb.xlsx"));

            XSSFWorkbook workbook=new XSSFWorkbook(file);
            XSSFSheet sheet=workbook.getSheetAt(0);

            Iterator<Row> rowIterator=sheet.iterator();

            while (rowIterator.hasNext()){
                Row row=rowIterator.next();

                Iterator<Cell> cellIterator=row.cellIterator();

                while (cellIterator.hasNext()){
                    Cell cell=cellIterator.next();

                    System.out.println(cell.getStringCellValue());

//                    System.out.println(cell.getStringCellValue());

//                    switch (cell.getCellType()){
//                        case NUMERIC:
//                            System.out.println(cell.getNumericCellValue());
//                            break;
//                        case STRING:
//                            System.out.println(cell.getStringCellValue());
//                            break;
//                    }
                    System.out.println();
                }
                file.close();
            }


        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
