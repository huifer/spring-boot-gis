package com.huifer.springbootgis.controller;

import com.huifer.springbootgis.entity.PointAddReq;
import com.huifer.springbootgis.service.PointService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/point")
@RestController
public class PointController {
	@Autowired
	PointService pointService;

	@GetMapping("/{id}")
	public Object byId(@PathVariable("id") int id) {
		return pointService.byId(id);
	}

	@PostMapping(value = "/add", consumes = { "application/json" })
	public Object add(
			@RequestBody PointAddReq pointAddReq
	) {
		return pointService.add(pointAddReq);
	}


	@PostMapping("/update")
	public Object update(@RequestBody PointAddReq pointAddReq
	) {
		return pointService.update(pointAddReq);
	}
}
