package com.example.generateqrcode;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class QRCodeController {
    private static final String QR_CODE_IMAGE_PATH = "./src/main/java/store/" + randomName(new Random().nextInt(15) + 1);

    @GetMapping(value = "/qrcode/{text}")
    public String generate(@PathVariable("text") String text) throws Exception {
        QRCodeGenerator.generateQRCodeImage(text, 350,350, QR_CODE_IMAGE_PATH);
        return "Success";
    }

    public static String randomName(int len) {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
                +"lmnopqrstuvwxyz!@#$%&";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb + ".png";
    }
}
