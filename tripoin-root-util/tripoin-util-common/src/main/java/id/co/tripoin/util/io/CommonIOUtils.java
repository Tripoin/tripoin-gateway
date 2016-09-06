package id.co.tripoin.util.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * <b>Common IO Utils:</b></br>
 * &emsp;&emsp;&emsp;Reference = org.apache.commons.io.IOUtils</br>
 * 
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class CommonIOUtils {
	
	private static final int DEFAULT_BUFFER_SIZE = 1024 * 4;
	private static final int EOF = -1;
	
	/**
	 * @param input
	 * @param output
	 * @return
	 * @throws IOException
	 */
	public static int copy(InputStream input, OutputStream output) throws IOException {
        long count = copyLarge(input, output);
        if (count > Integer.MAX_VALUE) {
            return -1;
        }
        return (int) count;
    }
	
	/**
	 * @param input
	 * @param output
	 * @return
	 * @throws IOException
	 */
	public static long copyLarge(InputStream input, OutputStream output)
            throws IOException {
        return copyLarge(input, output, new byte[DEFAULT_BUFFER_SIZE]);
    }
	/**
	 * @param input
	 * @param output
	 * @param buffer
	 * @return
	 * @throws IOException
	 */
	public static long copyLarge(InputStream input, OutputStream output, byte[] buffer)
            throws IOException {
        long count = 0;
        int n = 0;
        while (EOF != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
            count += n;
        }
        return count;
    }
	
}
