package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.model.Item;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-09-28T00:11:16.337Z[GMT]")
@RestController
public class VideoApiController implements VideoApi {

    private static final Logger log = LoggerFactory.getLogger(VideoApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public VideoApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<String> predictVideoPopularity(@NotNull @ApiParam(value = "categoryId", required = true) @Valid @RequestParam(value = "categoryId", required = true) int categoryId, @Valid @RequestParam(value = "region", required = false) String region,
        @Valid @RequestParam(value = "chennelTitle", required = false) String chennelTitle,  @Valid @RequestParam(value = "tags", required = false) String tags) {
        String accept = request.getHeader("Accept");

        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<String>("1", HttpStatus.OK);
        }
        return new ResponseEntity<String>(HttpStatus.NOT_IMPLEMENTED);
    }

}
