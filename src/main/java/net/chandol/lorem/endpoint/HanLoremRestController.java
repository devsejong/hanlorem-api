package net.chandol.lorem.endpoint;

import net.chandol.lorem.core.Lorem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HanLoremRestController {

    @RequestMapping("/sentences")
    public ResponseEntity<LoremResult> getSentences(@RequestParam(required = false, defaultValue = "1") int count) {
        return ResponseEntity.ok(
                new LoremResult(Lorem.getSentences(count))
        );
    }

    @RequestMapping(value = "/sentences", params = {"betweenStart", "betweenEnd"})
    public ResponseEntity<LoremResult> getSentencest(@RequestParam int betweenStart, @RequestParam int betweenEnd) {
        return ResponseEntity.ok(
                new LoremResult(Lorem.getSentences(betweenStart, betweenEnd))
        );
    }

    @RequestMapping("/paragraphs")
    public ResponseEntity getParagraphs(@RequestParam(required = false, defaultValue = "1") int count) {
        return ResponseEntity.ok(
                new LoremResult(Lorem.getParagraphs(count))
        );
    }

    @RequestMapping(value = "/paragraphs", params = {"betweenStart", "betweenEnd"})
    public ResponseEntity getParagraphs(@RequestParam int betweenStart, @RequestParam int betweenEnd) {
        return ResponseEntity.ok(
                new LoremResult(Lorem.getParagraphs(betweenStart, betweenEnd))
        );
    }

    @RequestMapping("/firstname")
    public ResponseEntity getFirstName() {
        return ResponseEntity.ok(
                new LoremResult(Lorem.getFirstName())
        );
    }


    @RequestMapping("/lastname")
    public ResponseEntity getLastName() {
        return ResponseEntity.ok(
                new LoremResult(Lorem.getLastName())
        );
    }

    @RequestMapping("/fullname")
    public ResponseEntity getFullName(){
        return ResponseEntity.ok(
                new LoremResult(Lorem.getName())
        );
    }

    @RequestMapping("/phonenumber")
    public ResponseEntity getPhoneNumber(){
        return ResponseEntity.ok(
                new LoremResult(Lorem.getPhoneNumber())
        );
    }

    // 결과 DTO
    public static class LoremResult {
        private String result;

        public LoremResult(String result) {
            this.result = result;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }
    }
}


