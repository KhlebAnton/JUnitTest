import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


class MainTest {
    @Test
    void testParseXML() throws ParserConfigurationException, IOException, SAXException {
        String fileNameTest = "Test.xml";
        Employee testEmp = new Employee(1,"Test","Test","Test",1);
        List<Employee> employeeList = Main.parseXML(fileNameTest);
        List<Employee> testEmpList = new ArrayList<>();
        testEmpList.add(testEmp);

        String expected = testEmpList.toString();
        String actual = employeeList.toString();

        Assertions.assertEquals(expected,actual);
    }
    @Test
    void testParseCSV() {
        String[] testColumnMapping = {"id", "firstName", "lastName", "country", "age"};
        String fileNameTest = "Test.csv";
        Employee testEmp = new Employee(1,"Test","Test","Test",1);
        List<Employee> employeeList = Main.parseCSV(testColumnMapping,fileNameTest);
        List<Employee> testEmpList = new ArrayList<>();
        testEmpList.add(testEmp);

        String expected = testEmpList.toString();
        String actual = employeeList.toString();

        Assertions.assertEquals(expected,actual);
    }
    @Test
    void testListToJson() {
        Employee testEmp = new Employee(1,"Test","Test","Test",1);
        List<Employee> testList = new ArrayList<>();
        testList.add(testEmp);
        String actual = Main.listToJson(testList);
        String expected = "[{\"id\":1,\"firstName\":\"Test\"," +
                "\"lastName\":\"Test\",\"country\":\"Test\",\"age\":1}]";
        Assertions.assertEquals(expected,actual);
    }

}