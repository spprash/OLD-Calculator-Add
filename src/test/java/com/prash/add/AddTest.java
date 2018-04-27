package com.prash.add;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@RunWith(SpringRunner.class)
@WebMvcTest(Add.class)

public class AddTest {
 
    @Autowired
    private MockMvc mvc;
 
    @Test
    public void testAddOk() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/add/API").accept(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("API is /add/{N1}/{N2} or /add?param1={N1}&param2={N2}"));
    }

    @Test
    public void testAddPathStyle() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/add/1/2").accept(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("3"));
    }


    @Test
    public void testAddParamStyle() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/add?param1=1&param2=2").accept(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("3"));
    }

    @Test
    public void testAddJSONStyle() throws Exception {
        String requestJson = "{\"param1\":1,\"param2\":2,\"result\":0}";
        String responseJson = "{\"param1\":1,\"param2\":2,\"result\":3}";

        mvc.perform(MockMvcRequestBuilders.post("/add/JSON").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
        .content(requestJson))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().json(responseJson));
    }

}