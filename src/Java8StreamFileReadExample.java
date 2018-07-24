import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Java8StreamFileReadExample {
	private static String bigExcelFile = "c:\\data.txt";

	public static void main(String[] args) throws Exception {
		// //Create file object
		// File file = new File(bigExcelFile);
		//
		// //Get file channel in readonly mode
		// FileChannel fileChannel = new RandomAccessFile(file, "r").getChannel();
		//
		// //Get direct byte buffer access using channel.map() operation
		// MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0,
		// fileChannel.size());
		//
		// // the buffer now reads the file as if it were loaded in memory.
		// System.out.println(buffer.isLoaded()); //prints false
		// System.out.println(buffer.capacity()); //Get the size based on content size
		// of file
		// System.out.println("buffer.limit()="+buffer.limit());
		//
		// //You can read the file from this buffer the way you like.
		// for (int i = 0; i < buffer.limit(); i++)
		// {
		// System.out.print((char) buffer.get()); //Print the content of file
		// }
		long now = System.currentTimeMillis();
		// read file into stream, try-with-resources
		// Use stream to avoid memory issues due to file size
		// Stream loads data as needed and hence manages memory dynamically
		// Time complexity: O(l*n) where l=no of lines and n=no of phrases per line
		try (Stream<String> stream = Files.lines(Paths.get(bigExcelFile))) {

			stream.forEach((buffer) -> {
				System.out.println(buffer);
			});

		} catch (IOException e) {
			e.printStackTrace();
		}

		long later = System.currentTimeMillis();
		System.out.println("Time taken: " + (later - now));
	}

}