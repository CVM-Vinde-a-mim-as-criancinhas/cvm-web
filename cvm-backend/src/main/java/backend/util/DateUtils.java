package backend.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class DateUtils {

    private static DateUtils _INSTANCE = new DateUtils();

    public static DateUtils getInstance(){
        return _INSTANCE;
    }

    private SimpleDateFormat sdfReferencia;
    private SimpleDateFormat sdfDate;
    private SimpleDateFormat sdfDateTime;

    private DateUtils(){
        this.sdfReferencia = new SimpleDateFormat("MM/yyyy");
        this.sdfDate = new SimpleDateFormat("dd/MM/yyyy");
        this.sdfDateTime = new SimpleDateFormat("dd/MM/yyyy - HH:mm:SS");
    }

    /**
     * Formata a data em MM/YYYY
     * @param date
     * @return
     */
    public String formatReferencia(Date date){
        return this.sdfReferencia.format(date);
    }

    public String formatDate(Date date){
        return this.sdfDate.format(date);
    }

    public String formatDateTime(Date date){
        return this.sdfDateTime.format(date);
    }

    public Date getInicioAno(int ano){
        GregorianCalendar gc = new GregorianCalendar();
        gc.set(GregorianCalendar.DAY_OF_MONTH, 1);
        gc.set(GregorianCalendar.MONTH, GregorianCalendar.JANUARY);
        gc.set(GregorianCalendar.YEAR, ano);
        this.resetHours(gc);
        return gc.getTime();
    }

    public Date getFimAno(int ano){
        GregorianCalendar gc = new GregorianCalendar();
        gc.set(GregorianCalendar.DAY_OF_MONTH, 31);
        gc.set(GregorianCalendar.MONTH, GregorianCalendar.DECEMBER);
        gc.set(GregorianCalendar.YEAR, ano);
        this.setFimDiaHoras(gc);
        return gc.getTime();
    }

    public void resetHours(Date date){
        if ( date != null ){
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTime(date);
            this.resetHours(gc);
            date.setTime(gc.getTimeInMillis());
        }
    }

    public void resetHours(GregorianCalendar calendar){
        if ( calendar != null ){
            calendar.set(GregorianCalendar.HOUR_OF_DAY, 0);
            calendar.set(GregorianCalendar.MINUTE, 0);
            calendar.set(GregorianCalendar.SECOND, 0);
            calendar.set(GregorianCalendar.MILLISECOND, 0);
        }
    }

    public void setFimDiaHoras(Date date){
        if ( date != null ){
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTime(date);
            this.setFimDiaHoras(gc);
            date.setTime(gc.getTimeInMillis());
        }
    }

    public void setFimDiaHoras(GregorianCalendar calendar){
        if ( calendar != null ){
            calendar.set(GregorianCalendar.HOUR_OF_DAY, 23);
            calendar.set(GregorianCalendar.MINUTE, 59);
            calendar.set(GregorianCalendar.SECOND, 59);
            calendar.set(GregorianCalendar.MILLISECOND, 999);
        }
    }

    public String getLabelPeriodo(Date inicio, Date fim){
        if (inicio == null && fim == null){
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        if (fim == null){
            return "Início: " + sdf.format(inicio);
        }
        if (inicio == null){
            return "Fim: " + sdf.format(fim);
        }

        if ( inicio.getTime() == fim.getTime() ){
            return "Data: " + sdf.format(inicio);
        }
        else{
            return "De: " + sdf.format(inicio)  +" a " + sdf.format(fim);
        }
    }

    public String getDuracao(long duration) {
        String res = "";
        long hours = TimeUnit.MILLISECONDS.toHours(duration) - TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(duration));
        long minutes = TimeUnit.MILLISECONDS.toMinutes(duration) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(duration));
        long seconds = TimeUnit.MILLISECONDS.toSeconds(duration) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration));
        long milis = TimeUnit.MILLISECONDS.toMillis(duration) - TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(duration));
        if ( hours > 0 ){
            res = String.format("%02d horas, %02d minutos, %02d segundos e %04d milissengundos", hours, minutes, seconds, milis);
        }
        else if ( minutes > 0 ){
            res = String.format("%02d minutos, %02d segundos e %04d milissegundos", minutes, seconds, milis);
        }
        else if ( seconds > 0 ){
            res = String.format("%02d segundos e %04d milissegundos", seconds, milis);
        }
        else{
            res = String.format("%04d milissegundos", milis);
        }
        return res;
    }

    public String getDuracaoLite(long duration) {
        String res = "";
        long hours = TimeUnit.MILLISECONDS.toHours(duration) - TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(duration));
        long minutes = TimeUnit.MILLISECONDS.toMinutes(duration) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(duration));
        long seconds = TimeUnit.MILLISECONDS.toSeconds(duration) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration));
        if ( hours > 0 ){
            res = hours > 1 ? String.format("%02d horas", hours) : "1 hora";
        }
        else if ( minutes > 0 ){
            res = minutes > 1 ? String.format("%02d minutos", minutes) : "1 minuto";
        }
        else if ( seconds > 0 ){
            res = seconds > 1 ? String.format("%02d segundos", seconds) : "1 segundo";
        }
        else{
            res = "menos de 1 segundo";
        }
        return res;
    }

    public String getDuracao(Date inicio, Date fim) {
        return this.getDuracao(fim.getTime() - inicio.getTime());
    }

    public static Date subtraiUmDia(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        return calendar.getTime();
    }

    public static Date adicionaUmDia(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }
}
