package backend.repository.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    public static final String PROPERTIES = "";
    public static final String PROPERTIES_DIR = "";
    public static final String USER_DIR = System.getProperty("user.dir");

    public static final String DATABASE_URL = "database.url";
    public static final String DATABASE_PORT = "database.port";
    public static final String DATABASE_SCHEMA = "database.schema";

    public static final String DATABASE_USERNAME = "database.username";
    public static final String DATABASE_PASSWORD = "database.password";

    public static final String PROPRIEDADE_URL_JPA = "javax.persistence.jdbc.url";
    public static final String PROPRIEDADE_USUARIO_JPA = "javax.persistence.jdbc.user";
    public static final String PROPRIEDADE_SENHA_JPA = "javax.persistence.jdbc.password";

    private static PropertiesReader instance;

    public static PropertiesReader getInstance() throws Exception{
        if (instance == null){
            instance = new PropertiesReader();
        }

        return instance;
    }

    private PropertiesReader() throws Exception {
        this.readProperties();
    }

    private Properties properties;

    public Properties getProperties(){
        return this.properties;
    }

    private void readProperties() throws Exception{
        try {
            String diretorio = System.getProperty(PROPERTIES_DIR, USER_DIR);

            File f = new File ( diretorio + File.separator + PROPERTIES );
            if (f.exists()){
                properties = new Properties();
                properties.load(new FileInputStream(f));
            }
            else{
                throw new Exception("Arquivo de propriedades não encontrado ["+ f.getAbsolutePath() +"]");
            }
        } catch (IOException e) {
            throw new Exception("Erro ao ler arquivo de propriedades: ["+ e.getMessage() +"]", e);
        }
    }

}