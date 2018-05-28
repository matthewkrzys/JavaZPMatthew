package generatortransakcjispring.generatortransakcji.logic;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class RandomData {

    public int randomGenerate(int max, int min) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public String generatedata(String FirstDate,String SecondDate){
        Random random=new Random();
        LocalDateTime start = LocalDateTime.parse(FirstDate.replace("-0100",""));
        LocalDateTime end = LocalDateTime.parse(SecondDate.replace("-0100",""));
        long amount = start.until(end, ChronoUnit.NANOS);
        if (amount < 0) throw new IllegalArgumentException();
        long generatedDate = (long) (random.nextFloat() * amount);
        return start.plusNanos(generatedDate).toString()+"-0100";
    }

}
