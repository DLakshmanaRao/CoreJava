import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileUtil {


    public static List<FileAvlbDomine> readFileFromXcel() {
        List<FileAvlbDomine> fileAvlbDomineList = new ArrayList<>();

        File file = new File(FileUtil.class.getResource("/payments.xlsx").getFile());
        try {
            FileInputStream inputStream = new FileInputStream(file);

            Workbook baeuldungWorkBook = new XSSFWorkbook(inputStream);
            for (Sheet sheet : baeuldungWorkBook) {
                int firstRow = sheet.getFirstRowNum();
                int lastRow = sheet.getLastRowNum();

                for (int index = firstRow+1 ; index <= lastRow; index++) {
                    Row row = sheet.getRow(index);

                    Cell cell0 = row.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    int id = (int) cell0.getNumericCellValue();
                    Cell cell1 = row.getCell(1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    String accNo = String.valueOf(cell1.getNumericCellValue());
                    Cell cell2 = row.getCell(2, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    double amount = cell2.getNumericCellValue();
                    Cell cell3 = row.getCell(3, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    String invoiceNo = String.valueOf(cell3.getNumericCellValue());
                    Cell cell4 = row.getCell(4, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    String name = cell4.getStringCellValue();
                    Cell cell5 = row.getCell(5, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    Date date = cell5.getDateCellValue();

                    FileAvlbDomine fileAvlbDomine = FileAvlbDomine.builder()
                            .id(id)
                            .accountNumber(accNo)
                            .amount(amount)
                            .invoiceNumber(invoiceNo)
                            .name(name)
                            .date(String.valueOf(date))
                            .build();
                    fileAvlbDomineList.add(fileAvlbDomine);

                }
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileAvlbDomineList;
    }

//    public List<String[]> array(){
//        List<FileAvlbDomine> list = readFile();
//        String[] al = new String[]{"id","account number","amount","invoice number","name,date"};
//        List<String[]> listArr = new ArrayList<>();
//        listArr.add(al);
//        for (int i =1;i<= list.size();i++){
//            String[] arrays = new String[6];
//            arrays[1] = s.getAccountNumber();
//            arrays[2] = String.valueOf(s.getAmount());
//            arrays[3] = s.getInvoiceNumber();
//            arrays[4] = s.getName();
//            arrays[5] = String.valueOf(s.getDate());
//            listArr.add(arrays);
//        }
//        return listArr;
//    }

    public List<FileDomine> setFileDomainHeadings(){
        List<FileDomine> fileAvlbDomineList = new ArrayList<>();
        String accountNum = "account number";
        String amount = "amount";
        String invoiceNum = "invoice number";
        FileDomine fileDo = new FileDomine(accountNum,amount,invoiceNum);

        fileAvlbDomineList.add(fileDo);
        return  fileAvlbDomineList;
    }



//        public List<FileDomine> getFileDomine() {
//
//        List<FileDomine> list1 = setFileDomainHeadings();
//        for (FileDomine fd:list1){
//            String accNo = fd.getAccountNumber();
//            String amount = String.valueOf(fd.getAmount());
//
//
//        }
//    }

}