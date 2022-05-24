package com.solvd.hospital;

import com.solvd.hospital.dao.jdbcMySQLImpl.*;
import com.solvd.hospital.models.*;
import com.solvd.hospital.utility.parsers.JaxB;
import com.solvd.hospital.utility.parsers.JsonParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBException;

import java.io.IOException;
import java.sql.SQLException;

public class Executor {

    private static final Logger LOGGER = LogManager.getLogger(Executor.class);


    public static void main(String[] args) throws IOException, JAXBException, SQLException, ClassNotFoundException {

        JsonParser jsonParser= new JsonParser();
        //jsonParser.writeToJson();
        jsonParser.readFromJson();
    }


}
