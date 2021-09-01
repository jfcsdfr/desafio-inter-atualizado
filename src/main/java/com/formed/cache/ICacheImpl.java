package com.formed.cache;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.formed.entities.DigitoUnico;

@Service
public class ICacheImpl implements ICache{
	
	private static ICacheImpl instance;
	
	private HashMap<String, DigitoUnico> cache;
	
	private ICacheImpl() {
		this.cache = new HashMap<String, DigitoUnico>();
	}
	
	public ICacheImpl getInstance() {
		if(instance == null) {
			instance = new ICacheImpl();
		}
		
		return instance;
	}

	@Override
	public void add(String key, DigitoUnico value) {
		if(cache.size() > 10) {
			cache.remove(key, 0);
			cache.put(key, value);
		}else {
			cache.put(key, value);
		}
		
	}

	@Override
	public void remove(String key) {
		cache.remove(key);		
	}

	@Override
	public DigitoUnico get(String key) {
		return cache.get(key);
	}

	@Override
	public void clear() {
		cache.clear();
		
	}

	@Override
	public long size() {
		return cache.size();
	}

}
