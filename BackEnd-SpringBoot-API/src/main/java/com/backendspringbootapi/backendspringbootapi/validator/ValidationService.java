package com.backendspringbootapi.backendspringbootapi.validator;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.ValidationMessage;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.Set;

@Service
public class ValidationService
{
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void validateJson(String jsonPayload, String schemaPath) {
        try {
            // Read the JSON schema
            InputStream schemaInputStream = this.getClass().getClassLoader().getResourceAsStream(schemaPath);
            JsonSchema schema = JsonSchemaFactory.getInstance().getSchema(schemaInputStream);

            // Read the JSON payload
            JsonNode jsonNode = objectMapper.readTree(jsonPayload);

            // Validate the JSON payload
            Set<ValidationMessage> errors = schema.validate(jsonNode);

            // Throw exception if there are validation errors
            if (!errors.isEmpty()) {
                StringBuilder stringBuilder = new StringBuilder();
                errors.forEach(error -> stringBuilder.append(error.getMessage()).append("\n"));
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        } catch (JsonParseException e) {
            // Exception when there is an issue in the JSON payload
            throw new IllegalArgumentException("Invalid JSON data: " + e.getMessage());
        } catch (IOException e) {
            // Exception when there is an issue reading the JSON payload or schema
            throw new RuntimeException("Error reading JSON data or schema: " + e.getMessage());
        } catch (Exception e) {
            // Generic exception
            throw new RuntimeException("An error occurred during validation: " + e.getMessage());
        }
    }


    public void validateXml(String rawXml) throws Exception {
        try {
            InputStream schemaStream = this.getClass().getResourceAsStream("/freedom.xsd");
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            javax.xml.validation.Schema schema = schemaFactory.newSchema(new StreamSource(schemaStream));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new StringReader(rawXml))); // throws a SAXException if this object is invalid
        } catch (SAXException e) {
            throw new IllegalArgumentException("Invalid XML data: " + e.getMessage());
        }
    }
}
