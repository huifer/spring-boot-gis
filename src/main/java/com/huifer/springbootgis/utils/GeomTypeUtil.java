package com.huifer.springbootgis.utils;

import javax.validation.constraints.NotNull;

import com.huifer.springbootgis.exception.GisRunTimeException;
import org.geotools.geometry.jts.JTSFactoryFinder;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;

public class GeomTypeUtil {
	private static GeometryFactory geometryFactory = JTSFactoryFinder.getGeometryFactory(null);

	private GeomTypeUtil() {
		throw new GisRunTimeException("This is a utility class and cannot be instantiated!");
	}


	/**
	 * 判断是否可以转换为 geometry 对象
	 * @param wkt
	 * @return
	 */
	public static boolean isGeom(@NotNull String wkt) {
		WKTReader reader = new WKTReader(geometryFactory);
		try {
			reader.read(wkt);
			return true;
		}
		catch (ParseException e) {
			return false;
		}
	}

}
