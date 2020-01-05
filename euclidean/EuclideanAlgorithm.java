package euclidean;

/**
 * @see <a href="https://en.wikipedia.org/wiki/Euclidean_algorithm">Euclidean algorithm</a>
 */
public class EuclideanAlgorithm {
    /**
     * See https://en.wikipedia.org/wiki/Euclidean_algorithm
     * @param a first number
     * @param b second number
     * @return int gretest common divisor of "a" and "b"
     */
    public int findGreatestCommonDivisor(int a, int b) {
        int sub = Math.abs(a - b);
        if(sub != b && sub != a) {
            if(a > b) {
                findGreatestCommonDivisor(sub, b);
            } else {
                findGreatestCommonDivisor(sub, a);
            }
        }
        return sub;
    }
}
