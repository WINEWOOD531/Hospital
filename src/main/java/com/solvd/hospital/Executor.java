package com.solvd.hospital;

import com.solvd.hospital.models.PatientModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.OutputKeys;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.IOException;

public class Executor {

    private static final Logger LOGGER = LogManager.getLogger(Executor.class);

    public static void main(String[] args) throws IOException {
        writeToXML();
        readFromXML();
    }

    private static void writeToXML() {
        PatientModel patientForEmpty = new PatientModel(1, 27, "A+", "F");
        patientForEmpty.setId(1);
        patientForEmpty.setAge(27);
        patientForEmpty.setBloodGroup("A+");
        patientForEmpty.setSex("F");

        String xmlFilePath = "src/main/resources/xml/Empty.xml";
        try {

            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

            Document document = documentBuilder.newDocument();

            Element root = document.createElement("patient");
            document.appendChild(root);

            Element employee = document.createElement("characteristics");

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
    }

    private static void readFromXML() {
        PatientModel patientForFull = new PatientModel(0, 0, "", "");
        try {
            String filePath = "src/main/resources/xml/Full.xml";

            File inputFile = new File(filePath);

            DocumentBuilderFactory dbFactory
                    = DocumentBuilderFactory.newInstance();

            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document document = dBuilder.parse(inputFile);
            document.getDocumentElement().normalize();

            LOGGER.info("Root element:"
                    + document.getDocumentElement().getNodeName());
            NodeList nodeList =
                    document.getElementsByTagName("characteristics");

            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Node nNode = nodeList.item(temp);
                System.out.println("\nCurrent Element:"
                        + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    patientForFull.setId(Integer.parseInt(eElement.getAttribute("id")));

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
    }
}
