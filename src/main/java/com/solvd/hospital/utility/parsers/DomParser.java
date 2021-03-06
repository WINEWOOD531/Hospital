package com.solvd.hospital.utility.parsers;


import com.solvd.hospital.models.PatientModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class DomParser {
    private static final Logger LOGGER = LogManager.getLogger(DomParser.class);

   /* public static void writeToXML() {
        PatientModel patientForEmpty = new PatientModel();
        patientForEmpty.setPersonId(1);
        patientForEmpty.setAge(27);
        patientForEmpty.setBloodGroup("A+");
        patientForEmpty.setSex("F");

        String xmlFilePath = "src/main/resources/xml/Empty.xml";
        try {

            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

            Document document = documentBuilder.newDocument();

            Element root = document.createElement("patients");
            document.appendChild(root);

            Element employee = document.createElement("patient");

            root.appendChild(employee);

            Attr attr = document.createAttribute("id");
            attr.setValue(String.valueOf(patientForEmpty.getId()));
            employee.setAttributeNode(attr);

            Element age = document.createElement("age");
            age.appendChild(document.createTextNode(String.valueOf(patientForEmpty.getAge())));
            employee.appendChild(age);

            Element bloodGroup = document.createElement("bloodGroup");
            bloodGroup.appendChild(document.createTextNode(String.valueOf(patientForEmpty.getBloodGroup())));
            employee.appendChild(bloodGroup);

            Element sex = document.createElement("sex");
            sex.appendChild(document.createTextNode(patientForEmpty.getSex()));
            employee.appendChild(sex);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(xmlFilePath));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.transform(domSource, streamResult);

            LOGGER.info("Done creating XML File");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }*/

    /*public static void readFromXML() {
        PatientModel patientForFull = new PatientModel();
        try {
            String filePath = "src/main/resources/xml/Full.xml";

            File inputFile = new File(filePath);

            DocumentBuilderFactory dbFactory
                    = DocumentBuilderFactory.newInstance();

            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document document = dBuilder.parse(inputFile);
            document.getDocumentElement().normalize();

            LOGGER.info("Root element: "
                    + document.getDocumentElement().getNodeName());
            NodeList nodeList =
                    document.getElementsByTagName("patient");

            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Node nNode = nodeList.item(temp);
                System.out.println("\nCurrent Element: "
                        + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    patientForFull.setPersonId(Integer.parseInt(eElement.getAttribute("id")));

                    patientForFull.setAge(Integer.parseInt(eElement.getElementsByTagName("age")
                            .item(0).getTextContent()));

                    patientForFull.setBloodGroup(eElement.getElementsByTagName("bloodGroup")
                            .item(0).getTextContent());

                    patientForFull.setSex(eElement.getElementsByTagName("sex")
                            .item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        LOGGER.info("Id: " + patientForFull.getId() + "\n" + "Age: " + patientForFull.getAge() + "\n" + "BloodGroup: " +
                patientForFull.getBloodGroup() + "\n" + "Sex: " + patientForFull.getSex());
    }*/
}
