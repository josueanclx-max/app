# StudyCore Android — projeto para compilar APK

Este projeto contém o StudyCore web local, encapsulado em WebView Android, e lembretes locais diários às 08h, 14h e 20h, sem servidor.

## Compilação
1. Abra a pasta `StudyCore_Android` no Android Studio (versão com Android Gradle Plugin 8.7.3 ou compatível).
2. Instale Android SDK 35 quando solicitado e aguarde o Gradle sincronizar.
3. Menu **Build > Build Bundle(s) / APK(s) > Build APK(s)**.
4. Instale o APK gerado em `app/build/outputs/apk/debug/app-debug.apk` no Galaxy S22.
5. Ao abrir o aplicativo, autorize as notificações.

## Observações
- Os lembretes nativos são programados em horários padrão 08h, 14h e 20h, podendo ser modificados futuramente na integração da tela de configurações. O painel web de lembretes existente não altera automaticamente os alarmes nativos.
- Alarmes são aproximados (Android pode atrasá-los para poupar bateria). Não são notificações push.
- Os dados ficam armazenados no dispositivo via WebView. Não há sincronização.
- O carregamento de PDF.js via CDN no StudyCore original ainda pode requerer internet.
- Esta é uma base de projeto Android não compilada/não testada neste ambiente, não um APK pronto.
