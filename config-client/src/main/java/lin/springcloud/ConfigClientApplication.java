package lin.springcloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class ConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}

    @Value("${myconfigtest}") // git配置文件里的key
    public String myconfigtest;

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${server.port}")
    private Integer serverPort;

    @Value("${spring.profiles}")
    private String profiles;

    @RequestMapping(value = "/hi")
    public Map<String,Object> getConfig4Remote() {
        Map<String, Object> retMap = new HashMap<>();
        retMap.put("applicationName", applicationName);
        retMap.put("port", serverPort);
        retMap.put("profiles", profiles);
        retMap.put("myconfigtest", myconfigtest);
        return retMap;
    }

}
