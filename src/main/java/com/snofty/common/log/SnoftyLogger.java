package com.snofty.common.log;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.snofty.common.log.service.SnoftyLoggerService;

public final class SnoftyLogger {

	public boolean debug = false;
	private Class<?> glass;
	private SnoftyLoggerService loggerService;
	private String logFilePath;

	public SnoftyLogger(Class<?> glass) {
		this.glass = glass;
		loggerService = new SnoftyLoggerService();
	}

	public void debug(Object data) {
		if (debug) {
			doWrite(prefix() + data, false);
		}
	}

	public void info(Object message) {
		doWrite(message, false);
	}

	private void doWrite(Object message, boolean isError) {
		PrintWriter writer = getWriter();
		if (writer != null) {
			try {
				if (message instanceof String) {
					writer.println((String) message);
				} else {
					writer.println(message.toString());
				}
				writer.flush();
			} finally {
				try {
					writer.close();
				} catch (Exception ex) {
				}
			}
		} else {
			writeToDefault(message, isError);
		}
	}

	private void writeToDefault(Object message, boolean isError) {
		if (!isError) {
			System.out.println(message);
		} else {
			System.err.println(message);
		}
	}

	private PrintWriter getWriter() {
		try {
			PrintWriter writer = new PrintWriter(
					new BufferedWriter(new OutputStreamWriter(new FileOutputStream(getFilePath(), true), "utf-8")));
			return writer;
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	private String getFilePath() {
		if (logFilePath == null) {
			logFilePath = loggerService.getLoggerFilePath();
		}
		return logFilePath;
	}

	public void warn(Object message) {
		doWrite(prefix() + message, true);
	}

	private String prefix() {
		return glass.getSimpleName() + "@" + getCurrentLocalDateTimeStamp() + "~  ";
	}
	
	private String getCurrentLocalDateTimeStamp() {
	    return LocalDateTime.now()
	       .format(DateTimeFormatter.ofPattern("dd,MMM yyyy HH:mm:ss.SSS"));
	}
}
