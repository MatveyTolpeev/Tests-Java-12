import org.junit.Test;

import static org.junit.Assert.*;

public class MyClassTest {

    @Test(expected = NumberFormatException.class)
    public void decode_Exception() {
        MyClass.decode("");
    }

    @Test
    public void decode_MinusDec() {
        Integer decode = MyClass.decode("-123");
        assertEquals(decode, new Integer(-123));
    }

    @Test
    public void decode_Plus() {
        Integer decode = MyClass.decode("+123");
        assertEquals(decode, new Integer(123));
    }

    @Test
    public void decode_HexFirst_LowerCase() {
        Integer decode = MyClass.decode("-0x11");
        assertEquals(decode, new Integer(-17));
    }

    @Test
    public void decode_HexFirst_UpperCase() {
        Integer decode = MyClass.decode("-0X11");
        assertEquals(decode, new Integer(-17));
    }

    @Test
    public void decode_HexSecond() {
        Integer decode = MyClass.decode("+#11");
        assertEquals(decode, new Integer(17));
    }

    @Test
    public void decode_Octal() {
        Integer decode = MyClass.decode("011");
        assertEquals(decode, new Integer(9));
    }

    @Test(expected = NumberFormatException.class)
    public void decode_DoublePlus() {
        MyClass.decode("++11");
    }

    @Test(expected = NumberFormatException.class)
    public void decode_WrongPlus() {
        MyClass.decode("0+11");
    }

    @Test(expected = NumberFormatException.class)
    public void decode_WrongMinus() {
        MyClass.decode("0-11");
    }

    @Test()
    public void decode_MIN_VALUE() {
        String minValue = Integer.toString(Integer.MIN_VALUE);
        Integer decode = MyClass.decode(minValue);
        assertEquals(decode, new Integer(Integer.MIN_VALUE));
    }

    @Test
    public void decode_MAX_VALUE() {
        String maxValue = Integer.toString(Integer.MAX_VALUE);
        Integer decode = MyClass.decode(maxValue);
        assertEquals(decode, new Integer(Integer.MAX_VALUE));
    }

    @Test(expected = NumberFormatException.class)
    public void decode_WrongFormat_NoDigits() {
        MyClass.decode("abc");
    }

    @Test(expected = NumberFormatException.class)
    public void decode_LONG_MIN_VALUE() {
        String minValue = Long.toString(Long.MIN_VALUE);
        MyClass.decode(minValue);
    }

    @Test(expected = NumberFormatException.class)
    public void decode_LONG_MAX_VALUE() {
        String maxValue = Long.toString(Long.MAX_VALUE);
        MyClass.decode(maxValue);
    }
}