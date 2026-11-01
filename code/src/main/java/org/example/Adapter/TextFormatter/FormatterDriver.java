package org.example.Adapter.TextFormatter;


import org.junit.Test;

public class FormatterDriver {
    @Test
    public void testFormatText() throws Exception {
        String testString=" Formatting line 1. Formatting line 2. Formatting line 3.";
        TextFormattable newLineFormatter=new NewLineFormatter();
        String resultString = newLineFormatter.formatText(testString);
        System.out.println(resultString);

        CsvFormattable csvFormatter=new CsvFormatter();
        TextFormattable csvAdapter=new CsvAdapterImpl(csvFormatter);
        String resultCsvString=csvAdapter.formatText(testString);
        System.out.println(resultCsvString);
    }
}
