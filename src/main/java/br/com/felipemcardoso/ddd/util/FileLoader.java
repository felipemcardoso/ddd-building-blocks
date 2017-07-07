package br.com.felipemcardoso.ddd.util;

import br.com.felipemcardoso.ddd.SegboxConstant;
import br.com.felipemcardoso.ddd.exception.SegboxException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by felipe on 8/23/14.
 */
public class FileLoader {

    private static final Map<String, Properties> properties = new HashMap<>();

    public static Properties load(String path) throws SegboxException {
        try {
            if (properties.containsKey(path)) {
                return properties.get(path);
            }

            ClassLoader loader = FileLoader.class.getClassLoader();
            InputStream is = loader.getResourceAsStream(path);

            if (is == null) {
                is = FileLoader.class.getResourceAsStream(path);

                if (is == null) {
                    // tentando recuperar o arquivo sem considerar o classpath
                    File propertiesFile = new File(path);
                    if (propertiesFile.exists()) {
                        is = new FileInputStream(propertiesFile);

                    } else {
                        throw new SegboxException(SegboxConstant.FILE_NOT_FOUND);
                    }
                }
            }
            Reader isr = new InputStreamReader(is, "UTF-8");

            Properties newProperties = new Properties();
            newProperties.load(isr);

            properties.put(path, newProperties);

            return newProperties;

        } catch (IOException ex) {
            throw new SegboxException(ex.getMessage());
        }
    }
}
