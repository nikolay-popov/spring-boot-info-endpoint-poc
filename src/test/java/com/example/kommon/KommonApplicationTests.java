package com.example.kommon;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class KommonApplicationTests {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void accessInfoUnauthorized() throws Exception {
    mockMvc
        .perform(
            get("/info")
                .with(httpBasic("user", "invalid_pwd")))
        .andExpect(status().isUnauthorized());
  }

  @Test
  public void accessInfoAuthorized() throws Exception {
    mockMvc
        .perform(
            get("/info")
                .with(httpBasic("user", "pwd")))
        .andExpect(status().isOk());
  }

  @Test
  public void otherEndpointsAreUnavailable() throws Exception {
    mockMvc
        .perform(
            get("/health")
                .with(httpBasic("user", "pwd")))
        .andExpect(status().isNotFound());
  }

}
