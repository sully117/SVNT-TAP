package io.swagger.api;
import java.util.*;

public class getAllMaps {
  Map<Integer, Integer> categoryMap = new HashMap<>();
  Map<String, Integer> regionMap = new HashMap<>();
  Map<String, Integer> tagsMap = new HashMap<>();
  Map<String, Integer> chennelTitleMap = new HashMap<>();

  public Map<Integer, Integer> getCategoryMapMap() {
    return categoryMap;
  }

  public Map<String, Integer> getRegionMap() {
    return regionMap;
  }

  public Map<String, Integer> getTagsMap() {
    return tagsMap;
  }

  public Map<String, Integer> getChennelTitleMap() {
    return chennelTitleMap;
  }
}
