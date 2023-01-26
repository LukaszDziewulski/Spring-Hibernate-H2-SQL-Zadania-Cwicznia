package SpringBootKurs.controller;

import SpringBootKurs.model.Post;
import SpringBootKurs.model.TokenResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class LoginControlerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldLoginAndGetContent() throws Exception {
        MvcResult login = mockMvc.perform(post("/login")
                        .contentType(APPLICATION_JSON_VALUE)
                        .content("{\"username\": \"test\", \"password\": \"test\"}")
                )
                .andDo(print())
                .andExpect(status().is(200))
                .andReturn();
        TokenResponse tokenResponse = objectMapper.readValue(login.getResponse().getContentAsString(), TokenResponse.class);

        mockMvc.perform(get("/secured")
                        .header("Authorization", "Bearer " + tokenResponse.getToken())
                )
                .andDo(print())
                .andExpect(status().is(200))
                .andExpect(content().string("secured"));

        mockMvc.perform(get("/secured"))
                .andDo(print())
                .andExpect(status().is(401));

    }

}