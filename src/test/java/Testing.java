import org.codehaus.groovy.transform.SourceURIASTTransformation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class Testing {

    public static void main(String[] args) throws IOException {
        String filePath = "src/main/resources/qa.properties";

        FileInputStream fileInputStream = new FileInputStream(filePath);

        Properties properties = new Properties();

        properties.load(fileInputStream);

        properties.setProperty("kdkdk" , "laxman");

        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        properties.store(fileOutputStream, "updated");

        List<String> list = Arrays.asList("QA", "DEV", "BA" , "MANAGER");
        Collections.shuffle(list);
        //System.out.println( list.stream().findAny().get());


    }
}
