package htwberlin.de.WebTech;

import org.h2.util.json.JSONValidationTargetWithoutUniqueKeys;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StudentGradeController.class)
public class GradeDeleteTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentGradeService service;


    @Test
    public void courseDeleteTest() throws Exception{

        Student st1 = new Student("Leon", 84444);
        Course c1 = new Course("Webtechnologien");
        StudentGrade g1 = new StudentGrade(st1, c1, 4.0);

        st1.setId(1L);
        c1.setId(1L);
        g1.setId(new StudentGradeKey(st1.getId(), c1.getId()));
        when(service.get(new StudentGradeKey(st1.getId(), c1.getId()))).thenReturn(g1);


        String expected = "{\"id\":{\"student_id\":1,\"course_id\":1},\"student_id\":{\"id\":1,\"name\":\"Leon\",\"matrikelnr\":84444},\"course_id\":{\"id\":1,\"name\":\"Webtechnologien\"},\"grade\":4.0}";

        //check if student suc. added
        this.mockMvc.perform(get("/grades/1/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString(expected)));
        //check if student suc. deleted
        this.mockMvc.perform(delete("/grades/delete/1/1"))
                .andExpect(status().isOk());
        //check if student doesn´t exists anymore
        this.mockMvc.perform(get("/grades/1/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString("")));

    }

}
