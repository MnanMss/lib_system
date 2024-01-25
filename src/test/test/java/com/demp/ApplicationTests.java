package java.com.demp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Date;

@SpringBootTest
class ApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(new Date());
    }

    @Test
    public void testString() {
        String uri = "http://localhost:9090:" + "/";
        String img = "http://localhost:9090/Machine Learning Basics.jpg";
        System.out.println(img.substring(uri.length()-1));
    }

    @Test
    public void testLocalDate() {
        LocalDate current = LocalDate.now();
        System.out.println(current);
    }
}
