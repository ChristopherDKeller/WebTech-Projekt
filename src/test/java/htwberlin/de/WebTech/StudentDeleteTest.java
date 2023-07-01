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

@WebMvcTest(StudentController.class)
public class StudentDeleteTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService service;


    @Test
    public void studentDeleteTest() throws Exception{

        Student st1 = new Student("Leon", 84444);
        st1.setId(12L);
        when(service.get(12L)).thenReturn(st1);


        String expected = "{\"id\":12,\"name\":\"Leon\",\"matrikelnr\":84444}";

        //check if student suc. added
        this.mockMvc.perform(get("/students/12"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString(expected)));
        //check if student suc. deleted
        this.mockMvc.perform(delete("/students/delete/12"))
                .andExpect(status().isOk());


        verify(service).delete(12L);

    }

}
