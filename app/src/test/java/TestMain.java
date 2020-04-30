import cn.com.heaton.blelibrary.ble.utils.ByteUtils;
import cn.com.heaton.blelibrary.ble.utils.CrcUtils;

public class TestMain {

    public static void main(String[] args) {
        //AA 01 04 3C 12 01 00
        byte[] testBytes = new byte[]{(byte)0xAA,(byte)0x01,(byte)0x04,(byte)0x00,(byte)0x01,(byte)0x12,(byte)0x3C,(byte)0x01,(byte)0x04,(byte)0x00,(byte)0x01,(byte)0x12,(byte)0x3C,(byte)0x01,(byte)0x04,(byte)0x00,(byte)0x01,(byte)0x12,(byte)0x3C,(byte)0x01,(byte)0x04,(byte)0x00,(byte)0x01,(byte)0x12,(byte)0x3C};
        //        byte[] testBytes = new byte[]{(byte)0xAA,(byte)0x01,(byte)0x04};
        byte[] crc16 = CrcUtils.CRC16.CRC16_HY(testBytes,0,testBytes.length);
        System.out.println(ByteUtils.bytes2HexStr(testBytes));
        System.out.println(ByteUtils.bytes2HexStr(crc16));
    }

}
