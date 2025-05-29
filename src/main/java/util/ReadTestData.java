package util;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.Properties;

public class ReadTestData {

    public static Properties initvalues = null;
    public static String pathSeparator = FileSystems.getDefault().getSeparator();
    public static String projectPath = System.getProperty("user.dir") + pathSeparator;
    public static String imagePath = System.getProperty("user.dir") + "\\Resources\\Image\\";
    public static String image2Path = pathSeparator;


    /**
     * Reads values from config file testdata.cfg
     * return properties object read from the given file
     */
    public static void readCFGfile()  throws Exception{

        try
        {

            Properties indProp = new Properties();
            //indProp.load(Files.newInputStream(Paths.get(projectPath+"Resources\\Data\\testdata.cfg")));
            indProp.load(new InputStreamReader(Files.newInputStream(Paths.get(projectPath + "Resources\\Data\\testdata.cfg")), StandardCharsets.UTF_8));
            initvalues = new Properties();

            // add common properties
            Enumeration<?> en = indProp.propertyNames();
            String key = "";
            String val = "";
            // Read all the elements from common property file
            while ( en.hasMoreElements() )
            {
                key = (String)en.nextElement();
                val = indProp.getProperty(key);
                initvalues.setProperty(key, val);
                //System.out.println("Properties load exception: " + initvalues.getProperty(key));
            }

        }catch (Exception e)
        {
            e.printStackTrace();
            //return null;
        }
    }//end of readCFGfile


    /**
     * Returns the property value for the given key.
     * getScriptValue returns the value of property for the script.
     * param key the property key whose value is been searched for
     * return string value
     */
    public static String getScriptValue(String key)  throws Exception
    {
        try{
            return(initvalues.getProperty(key));
        }catch (Exception e){
            System.out.println("Properties load exception: " + e.getMessage());
            return null;
        }
    }//End of getScriptValue

}//End of ReadTestData
