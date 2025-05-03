package com.rsj.aerion.inventory.repositories;

import com.rsj.aerion.inventory.models.RAMModule;
import com.rsj.aerion.inventory.models.RAMType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RAMModuleRepository extends JpaRepository<RAMModule, Long> {

    public Optional<RAMModule> findByTypeAndSizeAndSpeedAndConfiguredClockSpeedAndManufacturerAndPartNumberAndLocator(RAMType type, int size, int speed, int configuredClockSpeed, String manufacturer, String partNumber, String locator);
}
