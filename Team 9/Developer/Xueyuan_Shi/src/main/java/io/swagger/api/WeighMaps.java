package io.swagger.api;
import java.util.*;

public class WeighMaps {
  Map<Integer, Integer> categoryMap = new HashMap<>();
  Map<String, Integer> regionMap = new HashMap<>();
  Map<String, Integer> tagsMap = new HashMap<>();
  Map<String, Integer> chennelTitleMap = new HashMap<>();

  public WeighMaps() {
    categoryMap.put(1, 3000);
    categoryMap.put(2, 3);
    regionMap.put("WA", 1000);
    regionMap.put("CA", 500);
    tagsMap.put("fail", 10);
    tagsMap.put("funny", 50000);
    chennelTitleMap.put("EminemVEVO", 100);
    chennelTitleMap.put("iDubbbzTV", 1000);
  }

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
