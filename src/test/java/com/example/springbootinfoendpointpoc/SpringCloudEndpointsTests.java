package com.example.springbootinfoendpointpoc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
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
    testEndpoint("/env");
  }

  private void testEndpoint(String endpoint) throws Exception {
    testEndpointWithoutAuthorization(endpoint);
    testEndpointWithInvalidAuthorization(endpoint);
    testEndpointWithAuthorizationValidBySecurityConfig(endpoint);
  }

  private void testEndpointWithoutAuthorization(String endpoint) throws Exception {
    mockMvc
        .perform(post(endpoint))
        .andExpect(status().isForbidden());
  }

  private void testEndpointWithInvalidAuthorization(String endpoint) throws Exception {
    mockMvc
        .perform(
            post(endpoint)
                .with(httpBasic("user", "invalid_pwd")))
        .andExpect(status().isForbidden());
  }

  private void testEndpointWithAuthorizationValidBySecurityConfig(String endpoint) throws Exception {
    mockMvc
        .perform(
            post(endpoint)
                .with(httpBasic("user", "pwd")))
        .andExpect(status().isForbidden()); // TODO: see MAIN QUESTION in README
  }

  @Test
  public void envReset() throws Exception {
    testEndpoint("/env/reset");
  }

  @Test
  public void refresh() throws Exception {
    testEndpoint("/refresh");
  }

  @Test
  public void restart() throws Exception {
    testEndpoint("/restart");
  }

  @Test
  public void pause() throws Exception {
    testEndpoint("/pause");
  }

  @Test
  public void resume() throws Exception {
    testEndpoint("/resume");
  }

}
