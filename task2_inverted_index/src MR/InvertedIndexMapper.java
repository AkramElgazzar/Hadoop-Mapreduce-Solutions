import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

public class InvertedIndexMapper extends Mapper<LongWritable, Text, Text, Text> {

    private Text wordText = new Text();
    private Text fileNameText = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {

        String fileName = ((FileSplit) context.getInputSplit()).getPath().getName();
        fileNameText.set(fileName);

        String line = value.toString().toLowerCase();
        line = line.replaceAll("[^a-z0-9\\s]", " ");

        StringTokenizer itr = new StringTokenizer(line);
        while (itr.hasMoreTokens()) {
            String token = itr.nextToken().trim();
            if (token.length() > 0) {
                wordText.set(token);
                context.write(wordText, fileNameText);
            }
        }
    }
}
