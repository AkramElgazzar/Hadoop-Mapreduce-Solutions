import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;

public class InvertedIndexReducer extends Reducer<Text, Text, Text, Text> {

    private Text outValue = new Text();

    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {

        Set<String> fileSet = new HashSet<>();
        for (Text val : values) {
            fileSet.add(val.toString());
        }

        StringBuilder sb = new StringBuilder();
        Iterator<String> it = fileSet.iterator();
        boolean first = true;
        while (it.hasNext()) {
            if (!first) sb.append(",");
            sb.append(it.next());
            first = false;
        }

        outValue.set(sb.toString());
        context.write(key, outValue);
    }
}
