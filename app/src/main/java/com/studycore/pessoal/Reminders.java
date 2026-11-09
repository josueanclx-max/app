package com.studycore.pessoal;
import android.app.*;import android.content.*;import android.os.*;import java.util.*;
public class Reminders {
 static final String CHANNEL="studycore_estudos";
 static void channel(Context c){if(Build.VERSION.SDK_INT>=26){NotificationChannel ch=new NotificationChannel(CHANNEL,"Lembretes de estudo",NotificationManager.IMPORTANCE_DEFAULT);ch.setDescription("Notificações para resolver questões e revisar flashcards");c.getSystemService(NotificationManager.class).createNotificationChannel(ch);}}
 static void schedule(Context c){AlarmManager am=(AlarmManager)c.getSystemService(Context.ALARM_SERVICE);int[] hours={c.getSharedPreferences("MainActivity",0).getInt("morning",8),c.getSharedPreferences("MainActivity",0).getInt("afternoon",14),c.getSharedPreferences("MainActivity",0).getInt("evening",20)};
 for(int i=0;i<3;i++){Intent intent=new Intent(c,ReminderReceiver.class).putExtra("slot",i);PendingIntent pi=PendingIntent.getBroadcast(c,100+i,intent,PendingIntent.FLAG_UPDATE_CURRENT|PendingIntent.FLAG_IMMUTABLE);am.cancel(pi);if(hours[i]<0||hours[i]>23)continue;Calendar cal=Calendar.getInstance();cal.set(Calendar.HOUR_OF_DAY,hours[i]);cal.set(Calendar.MINUTE,0);cal.set(Calendar.SECOND,0);if(cal.getTimeInMillis()<=System.currentTimeMillis())cal.add(Calendar.DAY_OF_YEAR,1);am.setInexactRepeating(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pi);}}
}
