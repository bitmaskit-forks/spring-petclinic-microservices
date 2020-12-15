package org.springframework.samples.petclinic.vets.system;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "vets")
public class VetsProperties {
	private Cache cache;

	public static class Cache {
		private int ttl;
		private int heapSize;

		public int getTtl() {
			return ttl;
		}

		public void setTtl(int ttl) {
			this.ttl = ttl;
		}

		public int getHeapSize() {
			return heapSize;
		}

		public void setHeapSize(int heapSize) {
			this.heapSize = heapSize;
		}
	}

	public Cache getCache() {
		return cache;
	}

	public void setCache(Cache cache) {
		this.cache = cache;
	}
}
