package com.studycore.pessoal;
import android.app.*;import android.content.*;import android.os.*;
public class ReminderReceiver extends android.content.BroadcastReceiver {
 @Override public void onReceive(Context c,Intent i){Reminders.channel(c);int slot=i.getIntExtra("slot",0);String[] titles={"Bom dia! Hora de praticar","Sua revisão está esperando","Feche o dia com progresso"};String[] bodies={"Que tal resolver 10 questões no StudyCore?","Revise seus flashcards e fortaleça a memória.","Faça alguns exercícios antes de encerrar o dia."};
 Intent open=new Intent(c,MainActivity.class);PendingIntent pi=PendingIntent.getActivity(c,slot,open,PendingIntent.FLAG_UPDATE_CURRENT|PendingIntent.FLAG_IMMUTABLE);
 Notification.Builder n=new Notification.Builder(c,Reminders.CHANNEL).setSmallIcon(android.R.drawable.ic_menu_edit).setContentTitle(titles[slot]).setContentText(bodies[slot]).setAutoCancel(true).setContentIntent(pi);
 ((NotificationManager)c.getSystemService(Context.NOTIFICATION_SERVICE)).notify(100+slot,n.build());}
}
