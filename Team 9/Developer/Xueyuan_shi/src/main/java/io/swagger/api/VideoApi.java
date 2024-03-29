/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.11).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.annotations.*;
import io.swagger.model.Item;
import io.swagger.model.ListOfItems;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-09-28T00:11:16.337Z[GMT]")
@Api(value = "video", description = "the video API")
public interface VideoApi {
    @ApiOperation(value = "predict video", nickname = "predictVideoPopularity", notes = "By passing the params , you can predict the popularity", response = String.class, tags={ "users", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "search results matching criteria", response = String.class),
        @ApiResponse(code = 400, message = "bad input parameter") })
    @RequestMapping(value = "/video",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<String> predictVideoPopularity(@NotNull @ApiParam(value = "categoryId", required = true) @Valid @RequestParam(value = "categoryId", required = true) int categoryId, @Valid @RequestParam(value = "region", required = false) String region,
        @Valid @RequestParam(value = "channelTitle", required = false) String channelTitle,  @Valid @RequestParam(value = "tags", required = false) String tags);

}
