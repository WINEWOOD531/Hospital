package com.solvd.hospital.utility.parsers;

public class JaxB {

    /*public static void writeToXML() throws JAXBException {
        final Logger LOGGER = LogManager.getLogger(JaxB.class);
        Patient patient = new Patient(3, 27, "A", "F", "KO777125");
        File file = new File("src/main/resources/xml/JaxbEmpty.xml");
        try {
            JAXBContext context = JAXBContext.newInstance(Patient.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(patient, file);
            LOGGER.info("Writing to the file successfully executed");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }*/

/*    public static void readFromXML() {
        final Logger LOGGER = LogManager.getLogger(JaxB.class);
        File file = new File("src/main/resources/xml/JaxbFull.xml");
        try {
            JAXBContext context = JAXBContext.newInstance(Patient.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Patient patientNew = (Patient) unmarshaller.unmarshal(file);
            if (patientNew != null) LOGGER.info(patientNew.toString());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }*/

}
