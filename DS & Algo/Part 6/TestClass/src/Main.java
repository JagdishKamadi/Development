import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class TestClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            long start = scanner.nextLong();
            long end = scanner.nextLong();

            if (min > start) {
                min = start;
            }
            if (max < end) {
                max = end;
            }
            segments[i] = new Segment(start, end);
        }

        Arrays.sort(segments, new SegmentSort());

        long q = scanner.nextLong();
        for (long i = 0; i < q; i++) {
            long K = scanner.nextLong();
            long X = scanner.nextLong();

            long count = 0;
            long result = -1;

            if ((X > max) || (X < min)) {
                System.out.println(-1);
                continue;
            }

            for (Segment segment : segments) {
                if (segment.l <= X && X <= segment.r) {
                    count++;
                    if (count == K) {
                        result = segment.r - segment.l + 1;
                        break;
                    }
                }
            }

            System.out.println(result);
        }
    }


static class Segment {
    long l;
    long r;

    public Segment(long l, long r) {
        this.l = l;
        this.r = r;
    }
}

static class SegmentSort implements Comparator<Segment> {
    public int compare(Segment a, Segment b) {
        return (int) ((a.r - a.l) - (b.r - b.l));
    }
}
}