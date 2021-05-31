package utility;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

public class AddressBookFileIOTest {
    @Test
    public void given3AddressBookDataWhenWrittenToFileShuldMatchCount() {
        PersonDetails[] arrayOfData = {
                new PersonDetails("Sohamv", "Jagtap", "Pune", "Maharastra", "41012", "9740614842", "somu@123"),
                new PersonDetails("Aayush", "Suryawanshi", "Bangalore", "Karnataka", "51520", "8140614842", "ayu@123"),
                new PersonDetails("Ganesh", "Patil", "Gulbarga", "Karnataka", "58012", "7740614842", "ganu@123")
        };
        AddressBookFileIO addressBookFileIO = new AddressBookFileIO();
        addressBookFileIO.writeDataToFile(Arrays.asList(arrayOfData));
        addressBookFileIO.readData();
        long count = addressBookFileIO.listCount();
        Assertions.assertEquals(3,count);
    }

    @Test
    public void givenThreeAddressBookDataWhenWritten_tOCSV_FileShouldGiveResult() throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        PersonDetails[] arrayOfData = {
                new PersonDetails("Soham", "Jagtap", "Pune", "Maharastra", "41012", "9740614842", "somu@123"),
                new PersonDetails("Aayush", "Suryawanshi", "Bangalore", "Karnataka", "51520", "8140614842", "ayu@123"),
                new PersonDetails("Ganesh", "Patil", "Gulbarga", "Karnataka", "58012", "7740614842", "ganu@123")
        };
        AddressBookFileIO addressBookFileIO = new AddressBookFileIO();
        addressBookFileIO.writeDataToCSVfile(Arrays.asList(arrayOfData));
        addressBookFileIO.readCsvData();
        long count = addressBookFileIO.CsvlistCount();
        Assertions.assertEquals(4,count);
    }

    @Test
    public void givenThreeAddressBookDataWhenWritten_tOJSON_FileShouldGiveResult() throws IOException {
        PersonDetails[] arrayOfData = {
                new PersonDetails("Soham", "Jagtap", "Pune", "Maharastra", "41012", "9740614842", "somu@123"),
                new PersonDetails("Aayush", "Suryawanshi", "Bangalore", "Karnataka", "51520", "8140614842", "ayu@123"),
                new PersonDetails("Ganesh", "Patil", "Gulbarga", "Karnataka", "58012", "7740614842", "ganu@123")
        };
        AddressBookFileIO addressBookFileIO = new AddressBookFileIO();
        addressBookFileIO.writeDataToJSONFile(Arrays.asList(arrayOfData));
        addressBookFileIO.readJsonData();
        long count = addressBookFileIO.JsonlistCount();
        Assertions.assertEquals(1,count);
    }

}
