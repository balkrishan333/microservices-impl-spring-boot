package com.nagpal.limitsservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public LimitsConfiguration retrieveLimitsConfig() {
        return new LimitsConfiguration(configuration.getMinimum(), configuration.getMaximum());
    }

    @GetMapping("/fault-tolerance-example")
    @HystrixCommand(fallbackMethod = "fallBackRetrieveConfig")
    public LimitsConfiguration retrieveLimitsConfigs() {
        throw new RuntimeException("Not available");
    }

    public LimitsConfiguration fallBackRetrieveConfig() {
        return new LimitsConfiguration(9, 999);
    }
}
