package ru.fix.aggregating.profiler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Collections;

/**
 *
 * @author Andrey Kiselev
 */

public class IndicationProviderTagged implements Tagged {
    private final Map<String, String> tags = new ConcurrentHashMap<>();
    private final IndicationProvider provider;
    
    public IndicationProviderTagged(IndicationProvider provider) {
        this.provider = provider;
    }

    public IndicationProvider getProvider() {
        return this.provider;
    }

    @Override
    public Map<String, String> getTags() {
        return Collections.unmodifiableMap(this.tags);
    }

    @Override
    public void setTag(String name, String value) {
        this.tags.put(name, value);
    }
}