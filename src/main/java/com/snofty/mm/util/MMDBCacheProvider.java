package com.snofty.mm.util;

import java.util.LinkedHashSet;
import java.util.Set;

public class MMDBCacheProvider {

	private static Set<MMDBConnector> connectorCache=new LinkedHashSet<>();

	public static Set<MMDBConnector> getConnectorCache() {
		return connectorCache;
	}

}
