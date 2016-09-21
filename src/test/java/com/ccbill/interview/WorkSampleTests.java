package com.ccbill.interview;

import org.apache.log4j.Logger;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class WorkSampleTests extends WorkSample {

    private static final Logger logger = Logger.getLogger(WorkSampleTests.class);

    private WorkSample unitUnderTest;

    /**
     * Entire setup consists of just creating a new object for testing
     */
    @Before
    public void setUp() {
        logger.info("setting up env....");

        unitUnderTest = new WorkSample();
    }

    /**
     * @Test - first defined test case in the problem description
     */
    @Test
    public void test001 () {
        String input = "4 3\n-1 -3 4 2";

        Data data = unitUnderTest.parse(input);

        Assert.assertNotNull(data);

        Assert.assertEquals(4, data.N);
        Assert.assertEquals(3, data.K);

        int[] expected = new int[] {-1, -3, 4, 2};

        for (int i = 0; i < data.N; i++)
            Assert.assertEquals(expected[i], data.arrival_times[i]);
    }

    /**
     * @Test - second defined test in sample output
     */
    @Test
    public void test002 () {
        String input = "4 2\n0 -1 2 1";

        Data data = unitUnderTest.parse(input);

        Assert.assertNotNull(data);

        Assert.assertEquals(4, data.N);
        Assert.assertEquals(2, data.K);

        int[] expected = new int[] {0, -1, 2, 1};

        for (int i = 0; i < data.N; i++)
            Assert.assertEquals(expected[i], data.arrival_times[i]);
    }

    /**
     * @Test - tests that the above tests execute correctly when put together and thrown at the main method (
     * redirects input and output from stdin and stdout (respectively) and compares that against expected output)
     */
    @Test
    public void test003() {

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        System.setIn(new BufferedInputStream(WorkSampleTests.class.getResourceAsStream("/test-003.txt")));
        System.setOut(new PrintStream(output));

        WorkSample.main(new String[]{});

        try (BufferedReader reader = new BufferedReader(
            new InputStreamReader(
                WorkSampleTests.class.getResourceAsStream("/test-output-expected-003.txt")
            )
        )) {

            StringBuffer buffer = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
                buffer.append("\n");
            }

            String expectedOutput = buffer.toString();

            Assert.assertTrue(expectedOutput.equals(output.toString()));

        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    @After
    public void tearDown() {
        logger.info("tearing down....");

            // Doesn't guarantee that gc will happen, but close enough for government work
        unitUnderTest = null;
        System.gc();
    }

}
