package com.spr.registration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.spr.model.Shop;
import com.spr.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@Component
@ManagedBean
@SessionScoped
public class TableBean implements Serializable {



	@Autowired
	private ShopService shopService;

	private List<Shop> shops;



	public void refreshList(){
		shops = shopService.findAll();
	}

	public List<Shop> getShops() {
		return shops;
	}


}

