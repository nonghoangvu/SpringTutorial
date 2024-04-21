package com.vunh.controller;

import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class UploadController {
    private static final Logger log = LoggerFactory.getLogger(UploadController.class);

    @RequestMapping("/getImage/{photo}")
    ResponseEntity<ByteArrayResource> getImage(@PathVariable("photo") String photo) {
        if (photo != null && !photo.isEmpty()) {
            try {
                Path fileName = Paths.get("uploads", photo);
                byte[] buffer = Files.readAllBytes(fileName);
                ByteArrayResource byteArrayResource = new ByteArrayResource(buffer);
                MediaType mediaType;
                if (photo.toLowerCase().endsWith(".jpg") || photo.toLowerCase().endsWith(".jpeg")) {
                    mediaType = MediaType.IMAGE_JPEG;
                } else if (photo.toLowerCase().endsWith(".png")) {
                    mediaType = MediaType.IMAGE_PNG;
                } else {
                    return ResponseEntity.badRequest().build();
                }
                return ResponseEntity.ok()
                        .contentLength(buffer.length)
                        .contentType(mediaType)
                        .body(byteArrayResource);
            } catch (Exception e) {
                log.error("Error occurred while fetching image: {}", e.getMessage());
            }
        }
        return ResponseEntity.badRequest().build();
    }
}
