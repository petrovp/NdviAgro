package ndvi.agro.utility;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.util.Base64Utils;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.collect.Lists;

import ndvi.agro.service.exceptions.InvalidFileException;

/**
 * Util class for utility functions that are commonly used in various places in the app.
 */
public final class Utility {

	private Utility() {
		
	}
	
    /**
     * Generates random number with min length 1 and max length 9
     *
     * @param N the length of the random number.
     * @return needed random number.
     */
    public static String generateNDigitRandomNumber(int N) {

        if (N < 1 || N > 9) return null;

        List<Integer> digits = Lists.newArrayList();
        for (int i = 1; i <= 9; i++) {
            digits.add(i);
        }

        Collections.shuffle(digits);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb.append(digits.get(i));
        }

        return sb.toString();
    }

    public static Blob convertMultipartFileToBlob(MultipartFile file) {
        if (file != null) {
            try {
                Blob profilePictureAsBlob = new SerialBlob(file.getBytes());
                if (profilePictureAsBlob != null) {
                    return profilePictureAsBlob;
                }
            } catch (SQLException | IOException e) {
                throw new InvalidFileException("Invalid file recieved as input");
            }
        }

        throw new InvalidFileException("File is null");

    }

    public static String getBlobBase64Encoded(Blob blob) {
        if (blob == null) throw new InvalidFileException("Invalid blob from db");

        byte [] blobBytes = getBytesFromBlob(blob);

        return Base64Utils.encodeToString(blobBytes);
    }

    public static byte [] getBytesFromBlob(Blob blob) {
        try {
            return blob.getBytes(1, (int)blob.length());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new InvalidFileException("Invalid blob");
        }
    }

    public static String formatTime(DateTime time) {
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        String dtStr = fmt.print(time);
        return dtStr;
    }


}
