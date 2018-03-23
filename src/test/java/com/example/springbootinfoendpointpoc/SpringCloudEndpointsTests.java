package com.example.springbootinfoendpointpoc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SpringCloudEndpointsTests {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void env() throws Exception {
    testEndpointIsDisabled("/env");
  }

  private void testEndpointIsDisabled(String endpoint) throws Exception {
    mockMvc
        .perform(post(endpoint))
        .andExpect(status().isNotFound());
  }

  @Test
  public void envReset() throws Exception {
    testEndpointIsDisabled("/env/reset");
  }

  @Test
  public void refresh() throws Exception {
    testEndpointIsDisabled("/refresh");
  }

  @Test
  public void restart() throws Exception {
    testEndpointIsDisabled("/restart");
  }

  @Test
  public void pause() throws Exception {
    testEndpointIsDisabled("/pause");
  }

  @Test
  public void resume() throws Exception {
    testEndpointIsDisabled("/resume");
  }

}
