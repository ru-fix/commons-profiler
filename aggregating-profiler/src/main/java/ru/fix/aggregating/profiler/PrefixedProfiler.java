package ru.fix.aggregating.profiler;

import ru.fix.aggregating.profiler.engine.NameNormalizer;

/**
 * Attach fixed prefix to profiled calls and indicator names
 *
 * @author Kamil Asfandiyarov
 */
public class PrefixedProfiler implements Profiler {
    private final Profiler profiler;
    private final String profilerPrefix;

    public PrefixedProfiler(Profiler profiler, String profilerPrefix) {
        this.profiler = profiler;
        this.profilerPrefix = NameNormalizer.trimDots(profilerPrefix);
    }

    @Override
    public ProfiledCall profiledCall(String name) {
        return profiler.profiledCall(profilerPrefix + "." + NameNormalizer.trimDots(name));
    }

    @Override
    public ProfiledCall profiledCall(Identity identity) {
        return profiler.profiledCall(prefixedIdentity(identity));
    }

    @Override
    public void attachIndicator(String name, IndicationProvider indicationProvider) {
        profiler.attachIndicator(profilerPrefix + "." + NameNormalizer.trimDots(name), indicationProvider);
    }

    @Override
    public void attachIndicator(Identity identity, IndicationProvider indicationProvider) {
        profiler.attachIndicator(prefixedIdentity(identity), indicationProvider);
    }

    @Override
    public void detachIndicator(String name) {
        profiler.detachIndicator(profilerPrefix + "." + NameNormalizer.trimDots(name));
    }

    @Override
    public void detachIndicator(Identity identity) {
        profiler.detachIndicator(prefixedIdentity(identity));
    }

    @Override
    public ProfilerReporter createReporter() {
        return profiler.createReporter();
    }

    private Identity prefixedIdentity(Identity identity){
        return new Identity(
                profilerPrefix + "." + NameNormalizer.trimDots(identity.name),
                identity.getTags()
        );
    }
}
