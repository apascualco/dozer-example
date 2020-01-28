package com.apascualco.dozer.example;

import com.apascualco.dozer.example.domain.City;
import com.apascualco.dozer.example.domain.Employer;
import com.apascualco.dozer.example.domain.Form;
import org.dozer.DozerBeanMapper;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DozerMapperTest {

    private Form form;
    private DozerBeanMapper dozerBeanMapper;

    @Before
    public void setUp() {
        this.buildFormStub();
        this.buildDozerConfiguration();
    }

    @Test
    public void mapping_auto_fields() {
        final Employer employer = dozerBeanMapper.map(this.form, Employer.class);

        assertEquals("The name should be equals", employer.getName(), this.form.getName());
        assertEquals("The surname should be equals", employer.getSurname(), this.form.getSurname());
    }

    @Test
    public void mapping_with_support_date_in_java8() {
        final Employer employer = dozerBeanMapper.map(this.form, Employer.class);

        assertEquals("The date should be equals", employer.getBirthday(), this.form.getBirthday());
    }

    @Test
    public void mapping_with_annotation() {
        final Employer employer = dozerBeanMapper.map(this.form, Employer.class);

        assertEquals("The employer id should be equals", employer.getEmployerID(), this.form.getIdentificationNumber());
    }

    @Test
    public void mapping_with_xml() {
        final Employer employer = dozerBeanMapper.map(this.form, Employer.class);
        final City city = employer.getCity();

        assertNotNull("The city mustn't be null",city);
        assertEquals("The city name should be equals", city.getName(), this.form.getCityName());
        assertEquals("The country name should be equals", city.getCountry(), this.form.getConuntryName());
    }

    @Test
    public void mapping_with_xml_and_custom_converter() {
        final Employer employer = dozerBeanMapper.map(this.form, Employer.class);

        final String compositeName = form.getName() + " " +form.getSurname();
        assertEquals("The country name should be equals", employer.getCompositeName(), compositeName);
    }

    @Test
    public void mapping_with_xml_and_configursble_custom_converter() {
        final Employer employer = dozerBeanMapper.map(this.form, Employer.class);

        assertEquals("The years should be 16", employer.getYeas(), 16);
    }


    private void buildDozerConfiguration() {
        this.dozerBeanMapper = new DozerBeanMapper();
        this.dozerBeanMapper.setMappingFiles(Collections.singletonList("dozerJdk8Converters.xml"));

        final List<String> mappingFiles = new ArrayList<>();
        mappingFiles.add("dozerJdk8Converters.xml");
        mappingFiles.add("mappingDozer.xml");

        this.dozerBeanMapper.setMappingFiles(mappingFiles);

    }

    private void buildFormStub() {
        final Form form = new Form();
        form.setName("Roberto");
        form.setSurname("Sanchez");
        form.setBirthday(LocalDate.of(1991, Month.JANUARY, 1));
        form.setIdentificationNumber("44508345J");
        form.setCityName("Barcelona");
        form.setConuntryName("Spain");
        this.form = form;
    }
}
