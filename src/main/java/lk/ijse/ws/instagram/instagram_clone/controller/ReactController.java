package lk.ijse.ws.instagram.instagram_clone.controller;


import lk.ijse.ws.instagram.instagram_clone.dto.ReactDto;
import lk.ijse.ws.instagram.instagram_clone.dto.ShareDto;
import lk.ijse.ws.instagram.instagram_clone.service.ReactService;
import lk.ijse.ws.instagram.instagram_clone.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/react")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ReactController {

    @Autowired
    ReactService reactService;

    @PostMapping(value = "/post", consumes = {"application/json"}, produces = "application/json")
    public ResponseEntity<StandardResponse> register(@RequestBody ReactDto reactDto) {
        try {
            System.out.println(reactDto);

            System.out.println("react call : ");
//            this.amazonS3ClientService.uploadFileToS3Bucket(postDto.getImageUrl(), true);
            StandardResponse responseResponse = reactService.reactPost(reactDto);
            return new ResponseEntity<>(responseResponse, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}