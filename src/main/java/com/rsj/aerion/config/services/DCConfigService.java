package com.rsj.aerion.config.services;

import com.rsj.aerion.config.models.DCConfig;
import com.rsj.aerion.config.repositories.DCConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DCConfigService {

    @Autowired
    private Map<String, String> configMap;

    @Autowired
    private DCConfigRepository dcConfigRepository;

    public List<DCConfig> fetchAllConfigs() {
        return dcConfigRepository.findAll();
    }

    public String get(String key) {
        return configMap.get(key);
    }

    public void save(DCConfig dcConfig) {
        dcConfigRepository.save(dcConfig);
        configMap.put(dcConfig.getName(), dcConfig.getValue());
    }
}
