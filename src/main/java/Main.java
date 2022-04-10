import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        List<Employee> list = ParseCsv.parseCSV(columnMapping, "data.csv");
        Json.writeEmployeetoJson(list, "data.json");

        List<Employee> employeeList = Xml.parseXML("data.xml");
        Json.writeEmployeetoJson(employeeList, "data2.json");
    }
}


