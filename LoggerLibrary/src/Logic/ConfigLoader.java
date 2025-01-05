package Logic;

import java.util.HashMap;
import java.util.Map;
import Utility.StringValidation;

public class ConfigLoader {
    public static Map<String, String> loadConfig(String config) {
        Map<String, String> configMap = new HashMap<>();

        if (StringValidation.isNotBlank(config)) {
            String[] pairs = config.split("\\r?\\n");
            for (String pair : pairs) {
                if (StringValidation.isNotBlank(pair)) {
                    String[] keyValue = pair.split(":");
                    if (keyValue.length == 2) {
                        configMap.put(keyValue[0].trim(), keyValue[1].trim());
                    }
                }
            }
        }

        return configMap;
    }
}
