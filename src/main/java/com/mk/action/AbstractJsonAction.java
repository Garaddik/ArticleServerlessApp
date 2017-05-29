package com.mk.action;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 
 * @author kirankumar.garaddi
 *
 */
public class AbstractJsonAction {
	protected Gson getGson() {
		return new GsonBuilder().setPrettyPrinting().create();
	}
}
