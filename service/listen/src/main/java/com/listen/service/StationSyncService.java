package com.listen.service;

public interface StationSyncService {
    void getCountrieslist();
    void getLanguageList();
    void getTagList();
    void getAllStations();
    void getAllStationsByBatch();
    void getTopClick();
}
