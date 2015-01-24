package io.induct.util;

import java.util.Arrays;
import java.util.function.Supplier;

/**
 * @author Esko Suomi <suomi.esko@gmail.com>
 * @since 24.1.2015
 */
public class MoreArrays {

    /**
     * Pivot given table by its axii, eg. turn
     * <pre><code>
     *[[a,b,c]
     * [d,e,f]]</code></pre>
     * to
     * <pre><code>
     *[[a,d],
     * [b,e],
     * [c,f]]
     * </code></pre>
     *
     * @param bytes
     * @return
     */
    public static byte[][] pivot(byte[][] bytes) {
        int maxWidth = bytes[0].length;
        int maxHeight = bytes.length;
        byte[][] pivot = new byte[maxWidth][];
        MoreArrays.fill(pivot, () -> new byte[maxHeight]);

        for (int x = 0; x < maxHeight; x++) {
            for (int y = 0; y < maxWidth; y++) {
                byte b = bytes[x][y];
                pivot[y][x] = b;
            }
        }
        return pivot;
    }

    /**
     * Fill array entries with supplier provided values. Unlike {@link Arrays#fill(Object[], Object)} this causes unique
     * values to be used for each cell
     *
     * @param arr Array to fill
     * @param supplier Supplier for fill value
     */
    public static void fill(Object[] arr, Supplier<?> supplier) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = supplier.get();
        }
    }
}
