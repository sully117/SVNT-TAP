package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.model.Item;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    // Views under 500
    private final String BAD_POPULARITY = "0";
    // Views from 500 - 1000
    private final String GOOD_POPULARITY = "1";
    // Views more than 1000
    private final String EXCELLENT_POPULARITY = "2";

    @org.springframework.beans.factory.annotation.Autowired
    public VideoApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<String> predictVideoPopularity(@NotNull @ApiParam(value = "categoryId", required = true) @Valid @RequestParam(value = "categoryId", required = true) int categoryId, @Valid @RequestParam(value = "region", required = true) String region,
        @NotNull @Valid @RequestParam(value = "chennelTitle", required = true) String chennelTitle,  @NotNull @Valid @RequestParam(value = "tags", required = true) String tags) {
        String accept = request.getHeader("Accept");

        WeighMaps weighMaps = new WeighMaps();
        Map<Integer, Integer> categoryMap = weighMaps.getCategoryMapMap();
        Map<String, Integer> regionMap = weighMaps.getRegionMap();
        Map<String, Integer> tagsMap = weighMaps.getTagsMap();
        Map<String, Integer> channelTitleMap = weighMaps.getChennelTitleMap();

        int points = categoryMap.getOrDefault(categoryId, 0) + regionMap.getOrDefault(region, 0) +
            tagsMap.getOrDefault(tags, 0) + channelTitleMap.getOrDefault(chennelTitle, 0);

        String res = BAD_POPULARITY;
        if(points > 500 && points < 5000) res = GOOD_POPULARITY;
        if(points > 5000) res = EXCELLENT_POPULARITY;

        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<String>(res, HttpStatus.OK);
        }
        return new ResponseEntity<String>(HttpStatus.NOT_IMPLEMENTED);
    }

}
