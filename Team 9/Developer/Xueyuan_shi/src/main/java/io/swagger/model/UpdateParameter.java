package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Item;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UpdateParameter
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-09-28T00:11:16.337Z[GMT]")
public class UpdateParameter   {
  @JsonProperty("orderId")
  private String orderId = null;

  @JsonProperty("isAddItem")
  private Boolean isAddItem = null;

  @JsonProperty("item")
  private Item item = null;

  public UpdateParameter orderId(String orderId) {
    this.orderId = orderId;
    return this;
  }

  /**
   * Get orderId
   * @return orderId
  **/
  @ApiModelProperty(example = "1222", required = true, value = "")
  @NotNull

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public UpdateParameter isAddItem(Boolean isAddItem) {
    this.isAddItem = isAddItem;
    return this;
  }

  /**
   * Get isAddItem
   * @return isAddItem
  **/
  @ApiModelProperty(example = "true", required = true, value = "")
  @NotNull

  public Boolean isIsAddItem() {
    return isAddItem;
  }

  public void setIsAddItem(Boolean isAddItem) {
    this.isAddItem = isAddItem;
  }

  public UpdateParameter item(Item item) {
    this.item = item;
    return this;
  }

  /**
   * Get item
   * @return item
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid
  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
    this.item = item;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateParameter updateParameter = (UpdateParameter) o;
    return Objects.equals(this.orderId, updateParameter.orderId) &&
        Objects.equals(this.isAddItem, updateParameter.isAddItem) &&
        Objects.equals(this.item, updateParameter.item);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderId, isAddItem, item);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateParameter {\n");
    
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    isAddItem: ").append(toIndentedString(isAddItem)).append("\n");
    sb.append("    item: ").append(toIndentedString(item)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
