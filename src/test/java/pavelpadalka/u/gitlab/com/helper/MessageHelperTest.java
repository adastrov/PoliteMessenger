package pavelpadalka.u.gitlab.com.helper;

import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class MessageHelperTest {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private static String result;

    @Test
    public void testNightFirst()throws ParseException {
        result = MessageHelper.getPartOfDay(dateFormat.parse("23:00:00"));
        Assert.assertEquals("NIGHT", result);
    }

    @Test
    public void testNightSecond()throws ParseException{
        result = MessageHelper.getPartOfDay(dateFormat.parse("05:59:59"));
        Assert.assertEquals("NIGHT", result);
    }

    @Test
    public void testNightThree()throws ParseException{
        result = MessageHelper.getPartOfDay(dateFormat.parse("23:00:01"));
        Assert.assertEquals("NIGHT", result);
    }

    @Test
    public void testNightFour()throws ParseException{
        result = MessageHelper.getPartOfDay(dateFormat.parse("02:00:00"));
        Assert.assertEquals("NIGHT", result);
    }

    @Test
    public void testMorningFirst()throws ParseException{
        result = MessageHelper.getPartOfDay(dateFormat.parse("06:00:01"));
        Assert.assertEquals("MORNING", result);
    }

    @Test
    public void testMorningSecond()throws ParseException{
        result = MessageHelper.getPartOfDay(dateFormat.parse("08:59:59"));
        Assert.assertEquals("MORNING", result);
    }

    @Test
    public void testMorningThree()throws ParseException{
        result = MessageHelper.getPartOfDay(dateFormat.parse("07:25:01"));
        Assert.assertEquals("MORNING", result);
    }

    @Test
    public void testMorningFour()throws ParseException{
        result = MessageHelper.getPartOfDay(dateFormat.parse("08:00:00"));
        Assert.assertEquals("MORNING", result);
    }

    @Test
    public void testDayFirst()throws ParseException{
        result = MessageHelper.getPartOfDay(dateFormat.parse("09:00:01"));
        Assert.assertEquals("DAY", result);
    }

    @Test
    public void testDaySecond()throws ParseException{
        result = MessageHelper.getPartOfDay(dateFormat.parse("18:59:59"));
        Assert.assertEquals("DAY", result);
    }

    @Test
    public void testDayThree()throws ParseException{
        result = MessageHelper.getPartOfDay(dateFormat.parse("15:35:51"));
        Assert.assertEquals("DAY", result);
    }

    @Test
    public void testDayFour()throws ParseException{
        result = MessageHelper.getPartOfDay(dateFormat.parse("16:53:15"));
        Assert.assertEquals("DAY", result);
    }

    @Test
    public void testEveningFirst()throws ParseException{
        result = MessageHelper.getPartOfDay(dateFormat.parse("19:00:01"));
        Assert.assertEquals("EVENING", result);
    }

    @Test
    public void testEveningSecond()throws ParseException{
        result = MessageHelper.getPartOfDay(dateFormat.parse("22:59:59"));
        Assert.assertEquals("EVENING", result);
    }

    @Test
    public void testEveningThree()throws ParseException{
        result = MessageHelper.getPartOfDay(dateFormat.parse("21:25:01"));
        Assert.assertEquals("EVENING", result);
    }

    @Test
    public void testEveningFour()throws ParseException{
        result = MessageHelper.getPartOfDay(dateFormat.parse("22:00:00"));
        Assert.assertEquals("EVENING", result);
    }

    @Test
    public void testForReadingDataDayAndNightTimeLimitsProperties() throws ParseException {

        ResourceBundle resourceBundle = ResourceBundle.getBundle("DayAndNightTimeLimits");

        dateFormat.parse(resourceBundle.getString("timeLimit.morning"));
        dateFormat.parse(resourceBundle.getString("timeLimit.day"));
        dateFormat.parse(resourceBundle.getString("timeLimit.evening"));
        dateFormat.parse(resourceBundle.getString("timeLimit.night"));

    }

    @Test
    public void testOfDataProperties_en_US_Morning() throws ParseException {

        Locale.setDefault(new Locale("en_US"));

        ResourceBundle res = ResourceBundle.getBundle("data");

        result = res.getString("greeting." + "morning");

        Assert.assertEquals("Good morning, World!", result);

    }

    @Test
    public void testOfDataProperties_en_US_Day() throws ParseException {

        Locale.setDefault(new Locale("en_US"));

        ResourceBundle res = ResourceBundle.getBundle("data");

        result = res.getString("greeting." + "day");

        Assert.assertEquals("Good day, World!", result);

    }

    @Test
    public void testOfDataProperties_en_US_Evening() throws ParseException {

        Locale.setDefault(new Locale("en_US"));

        ResourceBundle res = ResourceBundle.getBundle("data");

        result = res.getString("greeting." + "evening");

        Assert.assertEquals("Good evening, World!", result);

    }

    @Test
    public void testOfDataProperties_en_US_Night() throws ParseException {

        Locale.setDefault(new Locale("en_US"));

        ResourceBundle res = ResourceBundle.getBundle("data");

        result = res.getString("greeting." + "night");

        Assert.assertEquals("Good night, World!", result);

    }

    @Test
    public void testOfDataProperties_ru_Morning() {

        Locale.setDefault(new Locale("ru"));

        ResourceBundle res = ResourceBundle.getBundle("data");

        result = res.getString("greeting." + "morning");

        Assert.assertEquals("Доброе утро, Мир!", result);

    }

    @Test
    public void testOfDataProperties_ru_Day() {

        Locale.setDefault(new Locale("ru"));

        ResourceBundle res = ResourceBundle.getBundle("data");

        result = res.getString("greeting." + "day");

        Assert.assertEquals("Добрый день, Мир!", result);

    }

    @Test
    public void testOfDataProperties_ru_Evening() {

        Locale.setDefault(new Locale("ru"));

        ResourceBundle res = ResourceBundle.getBundle("data");

        result = res.getString("greeting." + "evening");

        Assert.assertEquals("Добрый вечер, Мир!", result);

    }

    @Test
    public void testOfDataProperties_ru_Night() {

        Locale.setDefault(new Locale("ru"));

        ResourceBundle res = ResourceBundle.getBundle("data");

        result = res.getString("greeting." + "night");

        Assert.assertEquals("Доброй ночи, Мир!", result);

    }

}