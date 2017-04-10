package com.snofty.common.log.service;

import java.util.Properties;

import com.snofty.mm.util.ConfigurationsHolder;

public class SnoftyLoggerService {

	private static final String DEFAULT_LOG_FILE_PATH = "D:/Stuff/projects/logs/mm.log";

	public String getLoggerFilePath() {
		String path = DEFAULT_LOG_FILE_PATH;
		Properties properties = ConfigurationsHolder.getConfigurationsHolder().getProperties();
		if (properties != null) {
			path = properties.getProperty("mm.snofty.conf.log.path");
			if (path == null) {
				path = DEFAULT_LOG_FILE_PATH;
			}
		}
		return path;
	}
}
