package com.menuz.gps.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.menuz.gps.GeoDistance;

@RunWith(JUnit4.class)
public class GeoDistanceTest{
	
	@Test
	public void testGeoDistance() {
		double dis = GeoDistance.computeCompareDistance(30.0, 120.0, 31.0, 121.0);
		System.out.println(dis);
	}
}
