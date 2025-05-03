package com.rsj.aerion.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class JsonUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static JsonNode getSubArray(JsonNode data, int fromIndex, int toIndex) {
        ArrayNode subArr = objectMapper.createArrayNode();
        int start = Math.max(0, fromIndex);
        int end = Math.min(data.size(), toIndex);
        for(int i = start; i < end; i++) {
            subArr.add(data.get(i));
        }
        return subArr;
    }
}
