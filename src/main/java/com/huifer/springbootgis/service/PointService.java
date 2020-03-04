package com.huifer.springbootgis.service;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

import com.huifer.springbootgis.entity.PointAddReq;
import com.huifer.springbootgis.entity.PointTable;
import com.huifer.springbootgis.mapper.PointMapper;
import com.huifer.springbootgis.utils.GeomTypeUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PointService {
	@Autowired
	private PointMapper pointMapper;

	private AtomicInteger atomicInteger = new AtomicInteger(-1);

	@Value("${useing.mysql}")
	private boolean useingMsql;

	private HashMap<Integer, PointTable> pointTableHashMap = new HashMap<>();

	public Object byId(int id) {
		if (useingMsql) {
			return pointMapper.selectByPrimaryKey(id);
		}
		else {
			return pointTableHashMap.get(id);
		}

	}

	public Object add(PointAddReq pointAddReq) {
		String geom = pointAddReq.getGeom();

		if (useingMsql) {

			if (GeomTypeUtil.isGeom(geom)) {
				// 因为在设计表的时候我们可以规定只存放点线面的具体一个类型的数据这里就不对具体数据类型进行判断了
				if (pointAddReq.isPoint()) {
					PointTable conver = conver(pointAddReq);
					this.pointMapper.insertSelective(conver);
					return conver;
				}
			}
			return null;
		}
		else {
			if (GeomTypeUtil.isGeom(geom)) {
				int id = this.atomicInteger.incrementAndGet();
				PointTable conver = conver(pointAddReq);
				this.pointTableHashMap.put(id, conver);
				return conver;
			}
			else {
				return null;
			}
		}

	}

	private PointTable conver(PointAddReq pointAddReq) {
		PointTable pointTable = new PointTable();
		pointTable.setName(pointAddReq.getName());
		pointTable.setGeom(pointAddReq.getGeom());
		return pointTable;
	}

	public Object update(PointAddReq pointAddReq) {
		if (useingMsql) {
			if (GeomTypeUtil.isGeom(pointAddReq.getGeom())) {
				// 因为在设计表的时候我们可以规定只存放点线面的具体一个类型的数据这里就不对具体数据类型进行判断了
				if (pointAddReq.isPoint()) {
					PointTable conver = conver(pointAddReq);
					conver.setId(pointAddReq.getId());
					this.pointMapper.updateByPrimaryKeySelective(conver);
					return conver;
				}
			}
			return null;
		}
		else {
			if (GeomTypeUtil.isGeom(pointAddReq.getGeom())) {
				PointTable conver = conver(pointAddReq);
				conver.setId(pointAddReq.getId());
				pointTableHashMap.put(pointAddReq.getId(), conver);
				return pointTableHashMap.get(pointAddReq.getId());
			}
			return null;
		}

	}
}
