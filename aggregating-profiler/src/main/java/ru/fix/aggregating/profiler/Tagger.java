package ru.fix.aggregating.profiler;

/**
 *
 * @author Andrey Kiselev
 */

public interface Tagger {
    String EMPTY_VALUE = "";
    <T extends Tagged> T assignTag(String profiledCallName, T tagged);
}
