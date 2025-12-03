package com.listen.service.impl;

import com.listen.service.StationSyncService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StationServiceImplTest {

    @Autowired
    private StationSyncService stationService;

    @Test
    public void getCountrieslist() {
        stationService.getCountrieslist();
    }

    @Test
    public void getLanguageList() {
        stationService.getLanguageList();
    }
    @Test
    public void getTagList() {
        stationService.getTagList();
    }

    @Test
    public void getAllStations() {
        stationService.getAllStations();
    }
    @Test
    public void getAllStationsByBatch() {
        stationService.getAllStationsByBatch();
    }

    @Test
    public void getTopClick() {
        stationService.getTopClick();
    }
}