package com.snofty.mm.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationsHolder {

	private Properties properties;

	private ConfigurationsHolder() {
		getProperties();
	}

	private static class ConfigurationsHolderHelper {
		private static final ConfigurationsHolder HOLDER = new ConfigurationsHolder();
	}

	public static ConfigurationsHolder getConfigurationsHolder() {
		return ConfigurationsHolderHelper.HOLDER;
	}

	public Properties getProperties() {
		if (properties == null) {
			properties = new Properties();
			ClassLoader classloader = Thread.currentThread().getContextClassLoader();
			InputStream input = classloader.getResourceAsStream("system.properties");
			try {
				properties.load(input);
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return properties;
	}
}
