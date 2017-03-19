package com.alioune.utils;

public class UtilsMethods {
	/**
	 * Renvoie vrai si le paramétre est null ou vide. faux sinon
	 * 
	 * @param param
	 * @return
	 */
	public static boolean isNullOrEmpty(String param) {
		if (param != null && param.length() > 0) {
			return false;
		}
		return true;
	}
}
