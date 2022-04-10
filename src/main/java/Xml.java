import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Xml {
    public static List<Employee> parseXML(String fileName) throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File(fileName));

        List<Employee> resultList = new ArrayList<>();
        NodeList employees = doc.getElementsByTagName("employee");
        for (int i = 0; i < employees.getLength(); i++) {
            Element employee = (Element) employees.item(i);
            resultList.add(parseEmployee(employee));
        }
        return resultList;
    }

    private static Employee parseEmployee(Element employee) {
        long id = Long.parseLong(getElementText(employee, "id"));
        String firstName = getElementText(employee, "firstName");
        String lastName = getElementText(employee, "lastName");
        String country = getElementText(employee, "country");
        int age = Integer.parseInt(getElementText(employee, "age"));

        return new Employee(id, firstName, lastName, country, age);
    }

    private static String getElementText(Element employee, String elementName) {
        return employee.getElementsByTagName(elementName).item(0).getTextContent();
    }
}
