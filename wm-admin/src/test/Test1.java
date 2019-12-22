import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

public class Test1 {

    @Test
    public  void getpath(){
        Resource resource = new ClassPathResource("Images");
        try {
            String Path = resource.getFile().getPath();
            System.out.println(Path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
