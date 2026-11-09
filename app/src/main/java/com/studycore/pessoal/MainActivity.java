package com.studycore.pessoal;
import android.app.*;
import android.os.*;
import android.content.*;
import android.content.pm.PackageManager;
import android.webkit.*;
import android.view.*;
import android.graphics.Color;

public class MainActivity extends Activity {
 WebView web;
 @Override public void onCreate(Bundle b){super.onCreate(b);getWindow().setStatusBarColor(Color.rgb(0,154,224));
  web=new WebView(this);setContentView(web);WebSettings s=web.getSettings();s.setJavaScriptEnabled(true);s.setDomStorageEnabled(true);s.setAllowFileAccess(true);s.setAllowContentAccess(true);
  web.setWebViewClient(new WebViewClient());web.setWebChromeClient(new WebChromeClient());
  web.addJavascriptInterface(new Object(){@JavascriptInterface public void configure(int morning,int afternoon,int evening){getPreferences(0).edit().putInt("morning",morning).putInt("afternoon",afternoon).putInt("evening",evening).apply();Reminders.schedule(MainActivity.this);}},"StudyCoreAndroid");
  web.loadUrl("file:///android_asset/index.html");Reminders.channel(this);Reminders.schedule(this);
  if(Build.VERSION.SDK_INT>=33 && checkSelfPermission("android.permission.POST_NOTIFICATIONS")!=PackageManager.PERMISSION_GRANTED)requestPermissions(new String[]{"android.permission.POST_NOTIFICATIONS"},123);
 }
 @Override public void onBackPressed(){if(web.canGoBack())web.goBack();else super.onBackPressed();}
}
