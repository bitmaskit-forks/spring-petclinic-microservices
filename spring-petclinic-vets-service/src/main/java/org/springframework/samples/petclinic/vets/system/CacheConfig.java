package org.springframework.samples.petclinic.vets.system;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.*;

@Configuration
@EnableCaching
@Profile("production")
class CacheConfig {
}
