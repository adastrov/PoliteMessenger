package pavelpadalka.u.gitlab.com.helper;

import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MessageHelperTest {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private static String result;

    @Test
    public void testNightFirst()throws ParseException {
        result = MessageHelper.getCurrentPartOfDay(dateFormat.parse("23:00:00"));
        Assert.assertEquals(result, "NIGHT");
    }

    @Test
    public void testNightSecond()throws ParseException{
        result = MessageHelper.getCurrentPartOfDay(dateFormat.parse("05:59:59"));
        Assert.assertEquals(result, "NIGHT");
    }

    @Test
    public void testNightThree()throws ParseException{
        result = MessageHelper.getCurrentPartOfDay(dateFormat.parse("23:00:01"));
        Assert.assertEquals(result, "NIGHT");
    }

    @Test
    public void testNightFour()throws ParseException{
        result = MessageHelper.getCurrentPartOfDay(dateFormat.parse("02:00:00"));
        Assert.assertEquals(result, "NIGHT");
    }

    @Test
    public void testMorningFirst()throws ParseException{
        result = MessageHelper.getCurrentPartOfDay(dateFormat.parse("06:00:01"));
        Assert.assertEquals(result, "MORNING");
    }

    @Test
    public void testMorningSecond()throws ParseException{
        result = MessageHelper.getCurrentPartOfDay(dateFormat.parse("08:59:59"));
        Assert.assertEquals(result, "MORNING");
    }

    @Test
    public void testMorningThree()throws ParseException{
        result = MessageHelper.getCurrentPartOfDay(dateFormat.parse("07:25:01"));
        Assert.assertEquals(result, "MORNING");
    }

    @Test
    public void testMorningFour()throws ParseException{
        result = MessageHelper.getCurrentPartOfDay(dateFormat.parse("08:00:00"));
        Assert.assertEquals(result, "MORNING");
    }

    @Test
    public void testDayFirst()throws ParseException{
        result = MessageHelper.getCurrentPartOfDay(dateFormat.parse("09:00:01"));
        Assert.assertEquals(result, "DAY");
    }

    @Test
    public void testDaySecond()throws ParseException{
        result = MessageHelper.getCurrentPartOfDay(dateFormat.parse("18:59:59"));
        Assert.assertEquals(result, "DAY");
    }

    @Test
    public void testDayThree()throws ParseException{
        result = MessageHelper.getCurrentPartOfDay(dateFormat.parse("15:35:51"));
        Assert.assertEquals(result, "DAY");
    }

    @Test
    public void testDayFour()throws ParseException{
        result = MessageHelper.getCurrentPartOfDay(dateFormat.parse("16:53:15"));
        Assert.assertEquals(result, "DAY");
    }

    @Test
    public void testEveningFirst()throws ParseException{
        result = MessageHelper.getCurrentPartOfDay(dateFormat.parse("19:00:01"));
        Assert.assertEquals(result, "EVENING");
    }

    @Test
    public void testEveningSecond()throws ParseException{
        result = MessageHelper.getCurrentPartOfDay(dateFormat.parse("22:59:59"));
        Assert.assertEquals(result, "EVENING");
    }

    @Test
    public void testEveningThree()throws ParseException{
        result = MessageHelper.getCurrentPartOfDay(dateFormat.parse("21:25:01"));
        Assert.assertEquals(result, "EVENING");
    }

    @Test
    public void testEveningFour()throws ParseException{
        result = MessageHelper.getCurrentPartOfDay(dateFormat.parse("22:00:00"));
        Assert.assertEquals(result, "EVENING");
    }

}