package com.solvd.hospital.utility.parsers;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.solvd.hospital.Hospital;
import com.solvd.hospital.models.PersonModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class JsonParser {

    private static final String filePathForWrite = "src/main/resources/json/Empty.json";
    private static final String filePathForRead = "src/main/resources/json/Full.json";
    private static final Logger LOGGER = LogManager.getLogger(JsonParser.class);

    public static void writeToJson() throws IOException {
        PersonModel personModel = new PersonModel();
        personModel.setPersonId(10);
        personModel.setFirstName("Petro");
        personModel.setLastName("Vitrovui");
        personModel.setPhoneNumber("+380955550955");

        List<String> treatingDoctors = new ArrayList<String>();
        treatingDoctors.add("Ophthalmologist");
        treatingDoctors.add("Dentist");
        treatingDoctors.add("Neuropathologist");

        personModel.setTreatingDoctors(treatingDoctors);

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("ID", personModel.getPersonId());
        jsonObject.put("First Name", personModel.getFirstName());
        jsonObject.put("Last Name", personModel.getLastName());
        jsonObject.put("Employees Count", personModel.getPhoneNumber());
        jsonObject.put("Treating Doctors", personModel.getTreatingDoctors());
        try {
            ObjectMapper mapper = new ObjectMapper();
            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
            writer.writeValue(Paths.get(filePathForWrite).toFile(), personModel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFromJson() {
        ObjectMapper mapper = new ObjectMapper();
        FileReader file = null;
        try {
            file = new FileReader(filePathForRead);
            PersonModel personModel = mapper.readValue(file, PersonModel.class);
            LOGGER.info(personModel.toString());
            LOGGER.info(personModel.getPersonId());
            LOGGER.info(personModel.getFirstName());
            LOGGER.info(personModel.getLastName());
            LOGGER.info(personModel.getPhoneNumber());
            LOGGER.info(personModel.getTreatingDoctors());
        } catch (JsonParseException jpe) {
            LOGGER.info(jpe.getMessage());
        } catch (JsonMappingException jme) {
            LOGGER.info(jme.getMessage());
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        } finally {
            try {
                file.close();
            } catch (IOException e) {
                LOGGER.info(e.getMessage());
            }
        }

    }

}
