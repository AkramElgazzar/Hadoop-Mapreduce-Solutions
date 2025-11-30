import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

public class AvgTempMapper extends Mapper<LongWritable, Text, Text, DoubleWritable> {
    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {

        String[] fields = value.toString().split(",");
        String city = fields[0].trim();
        double temp = Double.parseDouble(fields[1].trim());

        context.write(new Text(city), new DoubleWritable(temp));
    }
}
