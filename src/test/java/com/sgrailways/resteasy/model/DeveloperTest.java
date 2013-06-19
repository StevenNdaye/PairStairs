package com.sgrailways.resteasy.model;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class DeveloperTest {

    @Test
    public void shouldExposeNameAndId(){
        Developer developer = new Developer("name");
        assertThat(developer.getName(), is("name"));
    }
}
