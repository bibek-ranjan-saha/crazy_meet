package com.crazylabs.crazy_meet.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController
public class RootController {

    @GetMapping("/call")
    @ResponseBody
    public String callEndpoint(@RequestParam String id) throws IOException {
        return loadFileContent("static/call.html");
    }

    @GetMapping("/.well-known/android_assets.json")
    @ResponseBody
    public ResponseEntity<String> androidAssetLink() throws Exception {
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(loadFileContent("static/android_assets.json"));
    }

    @GetMapping("/.well-known/apple-app-site-association")
    public ResponseEntity<String> iosAppSiteAssociation() throws IOException {
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(loadFileContent("static/ios_assets.json"));
    }

    private String loadFileContent(String filePath) throws IOException {
        Resource resource = new ClassPathResource(filePath);
        Path path = resource.getFile().toPath();
        return Files.readString(path, StandardCharsets.UTF_8);
    }
}
