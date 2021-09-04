

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class FileTest {
	
	public static void main(String[] args) throws IOException {
		Configuration configuration = new Configuration();
		FileSystem fileSystem = FileSystem.newInstance(configuration);
		//场景驱动的方式（元数据的更新流程）
		fileSystem.mkdirs(new Path("/usr/hive/warehouse/test/mydata"));
		/**
		 *  Namenode namenode=new Namenode(conf)
		 *  namenode.mkdirs(new Path("xx"))
		 */
		//完成写数据流程
		/**
		 *
		 * 之前：创建目录（更新元数据） Inode: INodeDirectory
		 * 现在：创建文件（更新元数据） Inode: INodeFile
		 *  初始化的工作：
		 *  1）添加了文件，修改目录树
		 *  2）添加契约
		 *  3）启动Data Streamer
		 *  4）开启续约的线程
		 */
		FSDataOutputStream fsous = fileSystem.create(new Path("/user.txt"));
		//TODO HdfsDataOutputStream
		fsous.write("fdsafdsafdsafs".getBytes());
	}

}
