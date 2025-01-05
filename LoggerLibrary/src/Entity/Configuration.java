package Entity;

import java.util.HashMap;
import java.util.Map;

public class Configuration {
    private Map<String, String> configMap = new HashMap<>();

    public Map<String, String> getConfigMap() {
        return configMap;
    }

    public void setConfigMap(Map<String, String> configMap) {
        this.configMap = configMap;
    }

}
