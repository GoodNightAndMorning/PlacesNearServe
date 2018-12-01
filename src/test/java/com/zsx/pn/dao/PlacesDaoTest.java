package com.zsx.pn.dao;

import com.zsx.pn.entity.Places;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlacesDaoTest {
    @Autowired
    private PlacesDao placesDao;
    @Test
    public void queryPlacesListByState() {
        List<Places> list = placesDao.queryPlacesListByState(0);
        System.out.println(list);
    }

    @Test
    public void queryPlacesList() {
//        List<Places> list = placesDao.queryPlacesList();
//        System.out.println(list);
    }

    @Test
    public void insertPlaces() {
    }

    @Test
    public void updatePlacesOfState() {
    }

    @Test
    public void updatePlaces() {
    }

    @Test
    public void deletePlaces() {
    }
}