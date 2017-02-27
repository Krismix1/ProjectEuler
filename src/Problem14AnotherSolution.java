public class Problem14AnotherSolution
{
    private static final short[] cache = new short[1000000];

    public static int collatzNum(long n) {
        if (n == 1) return 1;
        // The length is saved in the cache
        if (n < cache.length) {
            int count = cache[((int) n)];
            if (count > 0)
                return count;
        }
        int next = (n & 1) == 0
                ? 1 + collatzNum(n >> 1)
                : 2 + collatzNum((n * 3 + 1) >> 1);
        if (n < cache.length)
            cache[((int) n)] = (short) next;
        return next;
    }

    static {
        for (int i = 10; i < cache.length; i *= 2)
            collatzNum(i - 1);
    }

    public static void main(String... ignored) {
        long start = System.nanoTime();
        int maxCount = 0, max = 0;
        for (int i = 1; i < 1000000; i++) {
            int count = collatzNum(i);
            if (count > maxCount) {
                maxCount = count;
                max = i;
            }
        }
        long time = System.nanoTime() - start;
        System.out.println("count=" + maxCount + ", value=" + max + ", took=" + time / 1000 / 1000.0 + " ms.");
    }
}
