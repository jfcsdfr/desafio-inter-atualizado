package com.formed.cache;

import com.formed.entities.DigitoUnico;

public interface ICache {
	
	void add(String key, DigitoUnico value);
	void remove(String key);
	DigitoUnico get(String key);
	void clear();
	long size();
}
