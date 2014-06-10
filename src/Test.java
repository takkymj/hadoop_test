import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.apache.hadoop.fs.Path;


  
public class Test{  
    public static void main(String[] args) throws IOException {  
    	Configuration cfg = new Configuration();
    	FileSystem fs = FileSystem.get(URI.create("hdfs://192.168.74.200:9000"), cfg);
    	InputStream in = null;
    	in = fs.open(new Path("/user/grid/input/nohup.out"));
    	System.out.print(in);
    	in.close();
    }  
}  
