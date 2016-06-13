package com.rahmi.BuildCar.util;

import javax.naming.Context;

public class EjbApplicationClient {

	public static <T> T doLookup(Class<T> bean) {
		Context context = null;

		try {
			// 1. Obtaining Context
			context = JNDILookupClass.getInitialContext();
			// 2. Generate JNDI Lookup name
			String lookupName = getLookupName(bean);
			// 3. Lookup and cast
			return (T) context.lookup(lookupName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static String getLookupName(Class<?> bean) {

		String appName = "";
		String moduleName = "BuildCar-ejb";
		String distinctName = "";

		String beanName = bean.getSimpleName();

		// Fully qualified remote interface name
		final String interfaceName = bean.getName();

		// Create a look up string name
		String name = "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + interfaceName;
		return name;
	}
}
