package com.rsj.aerion.security;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
@Scope("singleton")
public class SecurityMapper {
    @JsonProperty("urls")
    private Map<String, SecurityURL> urls;
    public static String XSS = "(?i)<script.*?>.*?</script.*?>|<.*?on\\w+\\s*=.*?>|javascript:|vbscript:|data:text/html|document\\.cookie|document\\.location|window\\.location|eval\\(.*?\\)|alert\\(.*?\\)";

    public SecurityMapper() {
    }

    public SecurityMapper(Map<String, SecurityURL> urls) {
        this.urls = urls;
    }

    public void secureURL(HttpServletRequest request) throws SecurityException, IOException {
        String url = request.getRequestURI();
        String method = request.getMethod();
        String urlKey = url + "_" + method;
        urlKey = urlKey.replaceAll("/api", "");
        SecurityURL urlConfig = urls.get(urlKey);
        if (urlConfig == null) {
            throw new SecurityException("No security mapping found for url: " + url + " and method: " + method);
        }
        //SecurityRequest securityRequest = new SecurityRequest(request);
        JsonNode requestParamsBody = getRequestBodyAsMap(request);
        Map<String, SecurityParam> paramMap = urlConfig.getParams();
        if(paramMap == null) {
            paramMap = new HashMap<>();
        }
        for (Iterator<Map.Entry<String, JsonNode>> it = requestParamsBody.fields(); it.hasNext(); ) {
            Map.Entry<String, JsonNode> field = it.next();
            String paramName = field.getKey();
            JsonNode paramValue = field.getValue();
            if(!paramMap.containsKey(paramName)) {
                throw new SecurityException("Extra param found: " + paramName);
            }
            SecurityParam param = paramMap.get(paramName);
            if(paramValue.isArray()) {
                for (JsonNode arrayEntry : paramValue) {
                    String value = arrayEntry.textValue();
                    if (XSS.matches(value)) {
                        throw new SecurityException("XSS found in param: " + paramName);
                    }
                    if (param.getRegex() != null && !param.getRegex().isEmpty() && !value.matches(param.getRegex())) {
                        throw new SecurityException("Invalid value for param: " + paramName);
                    }
                }
                continue;
            }
            String value = paramValue.textValue();
            if (XSS.matches(value)) {
                throw new SecurityException("XSS found in param: " + paramName);
            }
            if (param.getRegex() != null && !param.getRegex().isEmpty() && !value.matches(param.getRegex())) {
                throw new SecurityException("Invalid value for param: " + paramName);
            }
        }
        for(String paramName : paramMap.keySet()) {
            if(!requestParamsBody.has(paramName)) {
                throw new SecurityException("Missing param: " + paramName);
            }
        }
    }

    public static JsonNode getRequestBodyAsMap(HttpServletRequest request) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(request.getInputStream());
    }

    public Map<String, SecurityURL> getUrls() {
        return urls;
    }

    public void setUrls(Map<String, SecurityURL> urls) {
        this.urls = urls;
    }

    @Override
    public String toString() {
        return "SecurityMapper{" +
                "urls=" + urls +
                '}';
    }
}
