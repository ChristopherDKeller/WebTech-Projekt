package htwberlin.de.WebTech;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CourseController.class)
public class CourseDeleteTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CourseService service;


    @Test
    public void courseDeleteTest() throws Exception{

        Course c1 = new Course("Webtechnologien");
        c1.setId(31L);
        when(service.get(31L)).thenReturn(c1);

        String expected = "{\"id\":31,\"name\":\"Webtechnologien\"}";

        //check if student suc. added
        this.mockMvc.perform(get("/course/31"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString(expected)));

        //check if student suc. deleted
        this.mockMvc.perform(delete("/course/delete/31"))
                .andExpect(status().isOk());

        verify(service).delete(31L);


    }

}
