package com.nagpal.webservices.rest.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {

    @GetMapping(path = "/hello-world", params = {"version=1"})
    public String goodMorning_params_v1() {
        return "versioning using params - version : 1";
    }

    @GetMapping(path = "/hello-world", params = {"version=2"})
    public String goodMorning_params_v2() {
        return "versioning using params - version : 2";
    }

    @GetMapping(path = "/hello-world", headers = {"X-version=1"})
    public String goodMorning_headers_v1() {
        return "versioning using headers - version : 1";
    }
    @GetMapping(path = "/hello-world", headers = {"X-version=2"})
    public String goodMorning_headers_v2() {
        return "versioning using headers - version : 2";
    }

    @GetMapping(path = "/hello-world/v1")
    public String goodMorning_uri_v1() {
        return "versioning using uri - version : 1";
    }

    @GetMapping(path = "/hello-world/v2")
    public String goodMorning_uri_v2() {
        return "versioning using uri - version : 2";
    }

    @GetMapping(path = "/hello-world", produces = "application/vnd.company.app-v1+json")
    public String goodMorning_produces_v1() {
        return "versioning using produces - version : 1";
    }

    @GetMapping(path = "/hello-world", produces ="application/vnd.company.app-v2+json")
    public String goodMorning_produces_v2() {
        return "versioning using produces - version : 2";
    }
}
