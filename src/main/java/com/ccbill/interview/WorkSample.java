package com.ccbill.interview;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class WorkSample {

    private static final Logger logger = Logger.getLogger(WorkSample.class);

    protected class Data {
        int N;
        int K;
        int arrival_times[];
    }


    protected Data parse(String input) {

        Data result = null;

        assert(input != null);

        String[] lines = input.split("\\n");

        assert(lines.length == 2);

        String[] fields = lines[0].split(" ");

        assert(fields.length == 2); // Expects only N and K to be on the first length

        result = new Data();

        result.N = Integer.parseInt(fields[0]);
        result.K = Integer.parseInt(fields[1]);

        String[] data = lines[1].split(" ");

        assert(data.length == result.N);    // Expect <N> arrival times

        result.arrival_times = new int[result.N];

        for (int index = 0; index < result.N; index++)
            result.arrival_times[index] = Integer.parseInt(data[index]);


        return result;
    }

    protected String solve(Data data) {
        String result = "YES";

            // Simle sanity check
        assert (data != null && data.N >= 0 && data.K <= data.N);

        int count = 0;

        for (int index = 0; index < data.N; index++)
            if (data.arrival_times[index] <= 0)
                count += 1;

        if (count >= data.K)
            result = "NO";

        return result;
    }

    /**
     * General Procedure below:
     *  T = readLine()
     *  for i in (1..T)
     *      data = parse(input)
     *      solution = solve(data)
     *      print (solution)
     * @param args - Command Line arguments (expects none)
     */
    public static void main (String[] args) {

        WorkSample sample = new WorkSample();

        try (InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader reader = new BufferedReader(isr)) {

            Integer numTestCases = Integer.parseInt(reader.readLine().trim());

            while (numTestCases-- > 0) {
                String input = reader.readLine() + "\n" + reader.readLine();

                Data data = sample.parse(input);

                String solution = sample.solve(data);

                System.out.println(solution);

            }

        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }

    }

}
