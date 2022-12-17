package io.zipcoder.crudapp.modeltest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.zipcoder.crudapp.models.Person;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.Entity;
public class PersonTest {
    @Test
    public void testClassSignatureAnnotations() {
        Assert.assertTrue(Person.class.isAnnotationPresent(Entity.class));
    }
    @Test
    public void testCreateJson() throws JsonProcessingException { //filled in the nullery
        ObjectMapper jsonWriter = new ObjectMapper();
        Person person = new Person();
        String json = jsonWriter.writeValueAsString(person);
    }
}
