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
    mockMvc
        .perform(
            post("/env"))
//                .with(httpBasic("user", "invalid_pwd")))
        .andExpect(status().isOk());
//        .andExpect(status().isForbidden());

//    mockMvc
//        .perform(
//            post("/env")
//                .with(httpBasic("user", "pwd")))
//        .andExpect(status().isForbidden());
  }

  @Test
  public void envReset() throws Exception {
    mockMvc
        .perform(
            post("/env/reset"))
//                .with(httpBasic("user", "invalid_pwd")))
        .andExpect(status().isOk());
//        .andExpect(status().isForbidden());

//    mockMvc
//        .perform(
//            post("/env")
//                .with(httpBasic("user", "pwd")))
//        .andExpect(status().isForbidden());
  }

  @Test
  public void refreshIsDisabledByDefault() throws Exception {
    mockMvc
        .perform(
            post("/refresh"))
//                .with(httpBasic("user", "invalid_pwd")))
        .andExpect(status().isNotFound());
//        .andExpect(status().isForbidden());

//    mockMvc
//        .perform(
//            post("/env")
//                .with(httpBasic("user", "pwd")))
//        .andExpect(status().isForbidden());
  }

  @Test
  public void restartIsDisabledByDefault() throws Exception {
    mockMvc
        .perform(
            post("/restart"))
//                .with(httpBasic("user", "invalid_pwd")))
        .andExpect(status().isNotFound());
//        .andExpect(status().isForbidden());

//    mockMvc
//        .perform(
//            post("/env")
//                .with(httpBasic("user", "pwd")))
//        .andExpect(status().isForbidden());
  }

  @Test
  public void pause() throws Exception {
    mockMvc
        .perform(
            post("/pause"))
//                .with(httpBasic("user", "invalid_pwd")))
        .andExpect(status().isOk());
//        .andExpect(status().isForbidden());

//    mockMvc
//        .perform(
//            post("/env")
//                .with(httpBasic("user", "pwd")))
//        .andExpect(status().isForbidden());
  }

  @Test
  public void resume() throws Exception {
    mockMvc
        .perform(
            post("/resume"))
//                .with(httpBasic("user", "invalid_pwd")))
        .andExpect(status().isOk());
//        .andExpect(status().isForbidden());

//    mockMvc
//        .perform(
//            post("/env")
//                .with(httpBasic("user", "pwd")))
//        .andExpect(status().isForbidden());
  }

}
