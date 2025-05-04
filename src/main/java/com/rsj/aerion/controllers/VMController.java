package com.rsj.aerion.controllers;

import com.rsj.aerion.inventory.models.VirtualNode;
import com.rsj.aerion.inventory.repositories.VMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/inv/vm")
public class VMController {

    @Autowired
    private VMRepository vmRepository;

    @GetMapping("")
    public List<VirtualNode> getVMInfo() {
        List<VirtualNode> virtualNodes = vmRepository.findAll();
        return virtualNodes;
    }
}
