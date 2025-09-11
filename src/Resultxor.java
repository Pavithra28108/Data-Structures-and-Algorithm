
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
public class Resultxor {

    public static int maximizingXor(int l, int r) {
        // Write your code here
        int xor = l ^ r;
        int significantBit = 0;

        // Find position of the most significant differing bit
        while (xor > 0) {
            significantBit++;
            xor >>= 1;
        }

        // Maximum XOR with that number of bits set
        return (1 << significantBit) - 1;

    }

    public static void main(String[] args) throws IOException {

        int result = Resultxor.maximizingXor(11, 12);

}}

