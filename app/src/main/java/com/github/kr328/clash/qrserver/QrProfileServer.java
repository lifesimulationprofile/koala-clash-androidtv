package com.github.kr328.clash.qrserver;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import coil.network.HttpException;
import com.github.kr328.clash.FilesActivity$showError$1;
import com.github.kr328.clash.compose.newprofile.ProfileAddResult;
import com.github.kr328.clash.compose.qrcode.TvQrCodeSheetKt$TvQrCodeSheet$3$1$profileServer$1;
import fi.iki.elonen.NanoHTTPD;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.UUID;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.ExposingBufferByteArrayOutputStream;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.JobKt;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.http1.HeadersReader;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class QrProfileServer extends NanoHTTPD {
    public final byte[] appIcon;
    public final TvQrCodeSheetKt$TvQrCodeSheet$3$1$profileServer$1 onFileReceived;
    public final TvQrCodeSheetKt$TvQrCodeSheet$3$1$profileServer$1 onUrlReceived;
    public final String token;
    public volatile boolean tokenConsumed;

    public QrProfileServer(TvQrCodeSheetKt$TvQrCodeSheet$3$1$profileServer$1 tvQrCodeSheetKt$TvQrCodeSheet$3$1$profileServer$1, TvQrCodeSheetKt$TvQrCodeSheet$3$1$profileServer$1 tvQrCodeSheetKt$TvQrCodeSheet$3$1$profileServer$2, byte[] bArr) {
        this.asyncRunner = new HeadersReader(5);
        this.onUrlReceived = tvQrCodeSheetKt$TvQrCodeSheet$3$1$profileServer$1;
        this.onFileReceived = tvQrCodeSheetKt$TvQrCodeSheet$3$1$profileServer$2;
        this.appIcon = bArr;
        this.token = UUID.randomUUID().toString();
    }

    public static String buildResultPage$default(QrProfileServer qrProfileServer, boolean z, String str, String str2, String str3, int i) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        qrProfileServer.getClass();
        String str4 = z ? "<svg viewBox=\"0 0 24 24\" fill=\"none\" stroke=\"#0A0A0A\" stroke-width=\"2.5\" stroke-linecap=\"round\" stroke-linejoin=\"round\"><polyline points=\"20 6 9 17 4 12\"/></svg>" : "<svg viewBox=\"0 0 24 24\" fill=\"none\" stroke=\"#FFF\" stroke-width=\"2.5\" stroke-linecap=\"round\" stroke-linejoin=\"round\"><line x1=\"18\" y1=\"6\" x2=\"6\" y2=\"18\"/><line x1=\"6\" y1=\"6\" x2=\"18\" y2=\"18\"/></svg>";
        String str5 = z ? "linear-gradient(135deg, #00FF77, #05BC5A)" : "linear-gradient(135deg, #F87171, #DC2626)";
        if (str == null) {
            str = "";
        }
        String strReplace$default = str2 != null ? StringsKt__StringsJVMKt.replace$default(str2, "'", "\\'") : "";
        String strReplace$default2 = str3 != null ? StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(str3, "\\", "\\\\"), "'", "\\'"), "\n", "\\n") : "";
        StringBuilder sbM = CaptureSession$State$EnumUnboxingLocalUtility.m("\n            <!DOCTYPE html>\n            <html>\n            <head>\n                <meta charset=\"UTF-8\">\n                <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n                <title>Koala Clash</title>\n                <link rel=\"icon\" type=\"image/png\" href=\"icon.png\">\n                <style>\n                    * { margin: 0; padding: 0; box-sizing: border-box; }\n                    :root {\n                        --bg: #08111A;\n                        --card-bg: rgba(54, 78, 110, 0.45);\n                        --card-border: rgba(255, 255, 255, 0.12);\n                        --card-shadow: 0 8px 32px rgba(0, 0, 0, 0.4);\n                        --text-primary: #FAFAFA;\n                        --text-secondary: #99B3D7;\n                        --input-bg: rgba(0, 0, 0, 0.3);\n                        --input-border: rgba(255, 255, 255, 0.15);\n                    }\n                    @media (prefers-color-scheme: light) {\n                        :root {\n                            --bg: #C5D4F1;\n                            --card-bg: rgba(255, 255, 255, 0.80);\n                            --card-border: rgba(0, 0, 0, 0.12);\n                            --card-shadow: 0 8px 32px rgba(0, 0, 0, 0.10), 0 1px 3px rgba(0, 0, 0, 0.08);\n                            --text-primary: #0A0A0A;\n                            --text-secondary: #4A5568;\n                            --input-bg: rgba(0, 0, 0, 0.05);\n                            --input-border: rgba(0, 0, 0, 0.15);\n                        }\n                    }\n                    body {\n                        font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, sans-serif;\n                        background: var(--bg);\n                        color: var(--text-primary);\n                        min-height: 100dvh;\n                        display: flex;\n                        align-items: center;\n                        justify-content: center;\n                        padding: 20px;\n                    }\n                    .card {\n                        background: var(--card-bg);\n                        border: 1px solid var(--card-border);\n                        border-radius: 16px;\n                        padding: 32px 24px;\n                        width: 100%;\n                        max-width: 400px;\n                        text-align: center;\n                        backdrop-filter: blur(24px) saturate(1.4);\n                        -webkit-backdrop-filter: blur(24px) saturate(1.4);\n                        box-shadow: var(--card-shadow);\n                    }\n                    .icon {\n                        width: 56px;\n                        height: 56px;\n                        border-radius: 50%;\n                        background: ", str5, ";\n                        display: flex;\n                        align-items: center;\n                        justify-content: center;\n                        margin: 0 auto;\n                    }\n                    .icon svg { width: 28px; height: 28px; }\n                    h1 { font-size: 22px; font-weight: 700; margin-bottom: 8px; margin-top: 16px; }\n                    h1:empty { display: none; }\n                    p { font-size: 14px; color: var(--text-secondary); line-height: 1.5; }\n                    p:empty { display: none; }\n                    .support-btn {\n                        display: none;\n                        margin: 16px auto 0;\n                        padding: 12px 24px;\n                        border-radius: 12px;\n                        border: 1px solid var(--input-border);\n                        background: var(--input-bg);\n                        color: var(--text-primary);\n                        font-size: 14px;\n                        font-weight: 600;\n                        cursor: pointer;\n                        text-decoration: none;\n                        transition: opacity 0.2s, border-color 0.2s;\n                    }\n                    .support-btn:hover { border-color: var(--text-secondary); }\n                    .support-btn:active { opacity: 0.7; }\n                    .support-btn:focus-visible { outline: 2px solid var(--text-primary); outline-offset: 2px; }\n                    .error-detail {\n                        display: none;\n                        margin-top: 12px;\n                        padding: 10px 14px;\n                        border-radius: 10px;\n                        border: 1px solid var(--input-border);\n                        background: var(--input-bg);\n                        font-size: 12px;\n                        color: var(--text-secondary);\n                        word-break: break-word;\n                        text-align: left;\n                        line-height: 1.5;\n                    }\n                    @media (prefers-reduced-motion: reduce) {\n                        *, *::before, *::after { transition-duration: 0.01ms !important; }\n                    }\n                </style>\n            </head>\n            <body>\n                <div class=\"card\">\n                    <div class=\"icon\">", str4, "</div>\n                    <h1 id=\"title\"></h1>\n                    <p id=\"detail\"></p>\n                    <div id=\"error-detail\" class=\"error-detail\"></div>\n                    <a id=\"support-btn\" class=\"support-btn\"></a>\n                </div>\n                <script>\n                    var L = {\n                        en: {\n                            success_title: 'Sent to TV!',\n                            success_detail: 'The subscription has been added to your TV.',\n                            error_title: 'Error',\n                            already_used: 'This link has already been used.',\n                            empty_url: 'Please enter a URL.',\n                            invalid_url: 'URL must start with http:// or https://',\n                            empty_file: 'Please select a file.',\n                            hwid_limit: 'Device limit reached. This subscription cannot be activated on more devices.',\n                            server_error: 'Could not add profile. The subscription URL may be invalid or unreachable.',\n                            unknown: 'Unknown error',\n                            support: 'Contact Support',\n                            detail_label: 'Details'\n                        },\n                        ru: {\n                            success_title: 'Отправлено на ТВ!',\n                            success_detail: 'Профиль добавлен на ваш ТВ.',\n                            error_title: 'Ошибка',\n                            already_used: 'Эта ссылка уже была использована.',\n                            empty_url: 'Введите URL.',\n                            invalid_url: 'URL должен начинаться с http:// или https://',\n                            empty_file: 'Выберите файл.',\n                            hwid_limit: 'Достигнут лимит устройств. Эта подписка не может быть активирована на большем количестве устройств.',\n                            server_error: 'Не удалось добавить профиль. Возможно, ссылка на подписку недействительна или недоступна.',\n                            unknown: 'Неизвестная ошибка',\n                            support: 'Связаться с поддержкой',\n                            detail_label: 'Подробности'\n                        },\n                        zh: {\n                            success_title: '已发送到电视！',\n                            success_detail: '配置已添加到您的电视。',\n                            error_title: '错误',\n                            already_used: '此链接已被使用。',\n                            empty_url: '请输入 URL。',\n                            invalid_url: 'URL 必须以 http:// 或 https:// 开头',\n                            empty_file: '请选择文件。',\n                            hwid_limit: '设备数量已达上限，此订阅无法在更多设备上激活。',\n                            server_error: '无法添加配置。订阅链接可能无效或无法访问。',\n                            unknown: '未知错误',\n                            support: '联系支持',\n                            detail_label: '详情'\n                        }\n                    };\n                    var lang = (navigator.language || '').slice(0, 2).toLowerCase();\n                    var t = L[lang] || L.en;\n                    var success = ");
        sbM.append(z);
        sbM.append(";\n                    var errorKey = '");
        sbM.append(str);
        sbM.append("';\n                    var supportURL = '");
        sbM.append(strReplace$default);
        sbM.append("';\n                    var errorDetail = '");
        sbM.append(strReplace$default2);
        sbM.append("';\n                    document.getElementById('title').textContent = success ? t.success_title : t.error_title;\n                    document.getElementById('detail').textContent = success ? t.success_detail : (t[errorKey] || t.unknown);\n                    if (errorDetail) {\n                        var el = document.getElementById('error-detail');\n                        el.textContent = t.detail_label + ': ' + errorDetail;\n                        el.style.display = 'block';\n                    }\n                    if (supportURL) {\n                        var btn = document.getElementById('support-btn');\n                        btn.href = supportURL;\n                        btn.target = '_blank';\n                        btn.rel = 'noopener';\n                        btn.textContent = t.support;\n                        btn.style.display = 'inline-block';\n                    }\n                </script>\n            </body>\n            </html>\n        ");
        return StringsKt__IndentKt.trimIndent(sbM.toString());
    }

    public final NanoHTTPD.Response buildResponseFromResult(ProfileAddResult profileAddResult) {
        if (profileAddResult instanceof ProfileAddResult.Success) {
            return NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.OK, "text/html", buildResultPage$default(this, true, null, null, null, 12));
        }
        if (profileAddResult instanceof ProfileAddResult.HwidLimitHit) {
            return NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.FORBIDDEN, "text/html", buildResultPage$default(this, false, "hwid_limit", ((ProfileAddResult.HwidLimitHit) profileAddResult).marker.supportURL, null, 8));
        }
        if (!(profileAddResult instanceof ProfileAddResult.Error)) {
            throw new HttpException();
        }
        return NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.INTERNAL_ERROR, "text/html", buildResultPage$default(this, false, "server_error", null, ((ProfileAddResult.Error) profileAddResult).message, 4));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARN: Type inference failed for: r15v17 */
    /* JADX WARN: Type inference failed for: r15v19 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r20v0, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r20v1 */
    /* JADX WARN: Type inference failed for: r20v2 */
    /* JADX WARN: Type inference failed for: r20v3 */
    /* JADX WARN: Type inference failed for: r20v4 */
    /* JADX WARN: Type inference failed for: r3v34 */
    /* JADX WARN: Type inference failed for: r3v37 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r6v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    @Override // fi.iki.elonen.NanoHTTPD
    public final NanoHTTPD.Response serve(NanoHTTPD.HTTPSession hTTPSession) throws Throwable {
        Object obj;
        ?? r3;
        long j;
        DataOutput randomAccessFile;
        ?? r15;
        ByteArrayOutputStream byteArrayOutputStream;
        ?? r6;
        ?? r20;
        ByteBuffer map;
        ?? r7;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        NanoHTTPD.Response.Status status = NanoHTTPD.Response.Status.OK;
        NanoHTTPD.Response.Status status2 = NanoHTTPD.Response.Status.BAD_REQUEST;
        String strRemovePrefix = StringsKt.removePrefix(hTTPSession.uri, "/");
        if (hTTPSession.method == 1 && strRemovePrefix.equals("icon.png") && this.appIcon != null) {
            return new NanoHTTPD.Response(status, "image/png", new ByteArrayInputStream(this.appIcon), this.appIcon.length);
        }
        if (hTTPSession.method == 1 && strRemovePrefix.equals(this.token)) {
            String str = (String) hTTPSession.getParms().get("url");
            if (str == null || StringsKt.isBlank(str)) {
                return Intrinsics.areEqual(hTTPSession.getParms().get("mode"), "file") ? NanoHTTPD.newFixedLengthResponse(status, "text/html", "<!DOCTYPE html>\n<html>\n<head>\n    <meta charset=\"UTF-8\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n    <title>Koala Clash</title>\n    <link rel=\"icon\" type=\"image/png\" href=\"icon.png\">\n    <style>\n        * { margin: 0; padding: 0; box-sizing: border-box; }\n        :root {\n            --bg: #08111A;\n            --text-primary: #FAFAFA;\n            --text-secondary: #99B3D7;\n            --accent: #00FF77;\n            --error: #F87171;\n        }\n        @media (prefers-color-scheme: light) {\n            :root {\n                --bg: #C5D4F1;\n                --text-primary: #0A0A0A;\n                --text-secondary: #4A5568;\n                --accent: #00CA5E;\n                --error: #DC2626;\n            }\n        }\n        body {\n            font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, sans-serif;\n            background: var(--bg);\n            color: var(--text-primary);\n            min-height: 100dvh;\n            display: flex;\n            align-items: center;\n            justify-content: center;\n        }\n        .msg { text-align: center; }\n        .msg p { font-size: 14px; color: var(--text-secondary); margin-top: 16px; }\n        .msg .err { color: var(--error); }\n        .spinner {\n            width: 36px;\n            height: 36px;\n            border: 3px solid var(--text-secondary);\n            border-top-color: var(--accent);\n            border-radius: 50%;\n            margin: 0 auto;\n            animation: spin 0.8s linear infinite;\n        }\n        @keyframes spin { to { transform: rotate(360deg); } }\n        .err-icon {\n            width: 40px;\n            height: 40px;\n            margin: 0 auto;\n            color: var(--error);\n        }\n        @media (prefers-reduced-motion: reduce) {\n            .spinner { animation: none; border-top-color: var(--text-secondary); border-right-color: var(--accent); }\n        }\n    </style>\n</head>\n<body>\n    <div class=\"msg\">\n        <div id=\"spinner-wrap\"><div class=\"spinner\"></div></div>\n        <p id=\"status\"></p>\n    </div>\n    <script>\n        var L = {\n            en: { sending: 'Sending file to TV…', no_data: 'No file data received.' },\n            ru: { sending: 'Отправка файла на ТВ…', no_data: 'Нет данных файла.' },\n            zh: { sending: '正在发送文件到电视…', no_data: '未收到文件数据。' }\n        };\n        var lang = (navigator.language || '').slice(0,2).toLowerCase();\n        var t = L[lang] || L.en;\n        var errSvg = '<svg class=\"err-icon\" viewBox=\"0 0 24 24\" fill=\"none\" stroke=\"currentColor\" stroke-width=\"2.5\" stroke-linecap=\"round\" stroke-linejoin=\"round\"><line x1=\"18\" y1=\"6\" x2=\"6\" y2=\"18\"/><line x1=\"6\" y1=\"6\" x2=\"18\" y2=\"18\"/></svg>';\n        function showErr(msg) {\n            document.getElementById('spinner-wrap').innerHTML = errSvg;\n            var p = document.getElementById('status');\n            p.textContent = msg;\n            p.classList.add('err');\n        }\n        var hash = location.hash.slice(1);\n        if (!hash) {\n            showErr(t.no_data);\n        } else {\n            document.getElementById('status').textContent = t.sending;\n            var content = decodeURIComponent(hash);\n            var blob = new Blob([content], {type: 'application/x-yaml'});\n            var fd = new FormData();\n            fd.append('mode', 'file');\n            fd.append('file', blob, 'config.yaml');\n            fetch(window.location.pathname, {method: 'POST', body: fd})\n                .then(function(r) { return r.text().then(function(txt) { return {ok: r.ok, html: txt}; }); })\n                .then(function(d) { document.open(); document.write(d.html); document.close(); })\n                .catch(function() { showErr(t.no_data); });\n        }\n    </script>\n</body>\n</html>") : NanoHTTPD.newFixedLengthResponse(status, "text/html", "<!DOCTYPE html>\n<html>\n<head>\n    <meta charset=\"UTF-8\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n    <title>Koala Clash</title>\n    <link rel=\"icon\" type=\"image/png\" href=\"icon.png\">\n    <style>\n        * { margin: 0; padding: 0; box-sizing: border-box; }\n        :root {\n            --bg: #08111A;\n            --card-bg: rgba(54, 78, 110, 0.45);\n            --card-border: rgba(255, 255, 255, 0.12);\n            --card-shadow: 0 8px 32px rgba(0, 0, 0, 0.4);\n            --text-primary: #FAFAFA;\n            --text-secondary: #99B3D7;\n            --accent: #00FF77;\n            --accent-dark: #05BC5A;\n            --accent-glow: rgba(0, 255, 119, 0.15);\n            --input-bg: rgba(0, 0, 0, 0.3);\n            --input-border: rgba(255, 255, 255, 0.15);\n            --input-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.3);\n            --error: #F87171;\n            --tab-inactive-bg: rgba(255, 255, 255, 0.04);\n        }\n        @media (prefers-color-scheme: light) {\n            :root {\n                --bg: #C5D4F1;\n                --card-bg: rgba(255, 255, 255, 0.80);\n                --card-border: rgba(0, 0, 0, 0.12);\n                --card-shadow: 0 8px 32px rgba(0, 0, 0, 0.10), 0 1px 3px rgba(0, 0, 0, 0.08);\n                --text-primary: #0A0A0A;\n                --text-secondary: #4A5568;\n                --accent: #00CA5E;\n                --accent-dark: #00A84E;\n                --accent-glow: rgba(0, 202, 94, 0.12);\n                --input-bg: rgba(0, 0, 0, 0.05);\n                --input-border: rgba(0, 0, 0, 0.15);\n                --input-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.06);\n                --error: #DC2626;\n                --tab-inactive-bg: rgba(0, 0, 0, 0.03);\n            }\n        }\n        body {\n            font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, sans-serif;\n            background: var(--bg);\n            color: var(--text-primary);\n            min-height: 100dvh;\n            display: flex;\n            align-items: center;\n            justify-content: center;\n            padding: 20px;\n        }\n        .card {\n            background: var(--card-bg);\n            border: 1px solid var(--card-border);\n            border-radius: 16px;\n            padding: 32px 24px;\n            width: 100%;\n            max-width: 400px;\n            backdrop-filter: blur(24px) saturate(1.4);\n            -webkit-backdrop-filter: blur(24px) saturate(1.4);\n            box-shadow: var(--card-shadow);\n        }\n        .logo {\n            display: flex;\n            align-items: center;\n            justify-content: center;\n            gap: 10px;\n            margin-bottom: 8px;\n        }\n        .logo-icon {\n            width: 36px;\n            height: 36px;\n            border-radius: 10px;\n            overflow: hidden;\n        }\n        .logo-icon img { width: 100%; height: 100%; display: block; }\n        h1 {\n            font-size: 22px;\n            font-weight: 700;\n        }\n        .subtitle {\n            font-size: 14px;\n            color: var(--text-secondary);\n            text-align: center;\n            margin-bottom: 20px;\n        }\n        .tabs {\n            display: flex;\n            gap: 0;\n            margin-bottom: 16px;\n            border-radius: 10px;\n            overflow: hidden;\n            border: 1px solid var(--card-border);\n            background: var(--tab-inactive-bg);\n        }\n        .tab {\n            flex: 1;\n            padding: 10px;\n            text-align: center;\n            font-size: 14px;\n            font-weight: 600;\n            cursor: pointer;\n            background: transparent;\n            color: var(--text-secondary);\n            border: none;\n            transition: background 0.2s, color 0.2s;\n        }\n        .tab:hover:not(.active) { background: rgba(128, 128, 128, 0.08); }\n        .tab:focus-visible { outline: 2px solid var(--accent); outline-offset: -2px; }\n        .tab.active {\n            background: var(--accent);\n            color: #0A0A0A;\n        }\n        .mode { display: none; }\n        .mode.active { display: block; }\n        input[type=\"url\"] {\n            width: 100%;\n            padding: 14px 16px;\n            border-radius: 12px;\n            border: 1px solid var(--input-border);\n            background: var(--input-bg);\n            box-shadow: var(--input-shadow);\n            color: var(--text-primary);\n            font-size: 16px;\n            outline: none;\n            transition: border-color 0.2s, box-shadow 0.2s;\n            margin-bottom: 16px;\n        }\n        input[type=\"url\"]:focus {\n            border-color: var(--accent);\n            box-shadow: var(--input-shadow), 0 0 0 3px var(--accent-glow);\n        }\n        input[type=\"url\"]::placeholder { color: var(--text-secondary); opacity: 0.6; }\n        .file-drop {\n            width: 100%;\n            padding: 16px;\n            border-radius: 12px;\n            border: 2px dashed var(--input-border);\n            background: var(--input-bg);\n            box-shadow: var(--input-shadow);\n            color: var(--text-secondary);\n            font-size: 14px;\n            cursor: pointer;\n            transition: border-color 0.2s, background 0.2s;\n            margin-bottom: 16px;\n            display: flex;\n            align-items: center;\n            gap: 10px;\n        }\n        .file-drop:hover { border-color: var(--text-secondary); }\n        .file-drop.has-file { border-color: var(--accent); border-style: solid; }\n        .file-drop.dragover { border-color: var(--accent); background: var(--accent-glow); }\n        .file-drop-icon {\n            width: 24px;\n            height: 24px;\n            flex-shrink: 0;\n            color: var(--text-secondary);\n            opacity: 0.6;\n        }\n        .file-drop-content {\n            min-width: 0;\n        }\n        .file-name {\n            font-size: 13px;\n            color: var(--accent);\n            font-weight: 600;\n            margin-top: 2px;\n            word-break: break-all;\n        }\n        input[type=\"file\"] { display: none; }\n        .btn-submit {\n            width: 100%;\n            padding: 14px;\n            border-radius: 12px;\n            border: none;\n            background: linear-gradient(135deg, var(--accent), var(--accent-dark));\n            color: #0A0A0A;\n            font-size: 16px;\n            font-weight: 600;\n            cursor: pointer;\n            transition: opacity 0.2s, transform 0.1s, box-shadow 0.2s;\n        }\n        .btn-submit:hover:not(:disabled) { box-shadow: 0 4px 16px var(--accent-glow); }\n        .btn-submit:active:not(:disabled) { transform: scale(0.98); opacity: 0.9; }\n        .btn-submit:focus-visible { outline: 2px solid var(--text-primary); outline-offset: 2px; }\n        .btn-submit:disabled { opacity: 0.35; cursor: not-allowed; transform: none; }\n        .error {\n            color: var(--error);\n            font-size: 13px;\n            margin-bottom: 12px;\n            display: none;\n        }\n        .divider {\n            display: flex;\n            align-items: center;\n            gap: 12px;\n            margin: 16px 0;\n            color: var(--text-secondary);\n            font-size: 13px;\n        }\n        .divider::before, .divider::after {\n            content: '';\n            flex: 1;\n            height: 1px;\n            background: var(--card-border);\n        }\n        .btn-app {\n            width: 100%;\n            padding: 14px;\n            border-radius: 12px;\n            border: 1px solid var(--input-border);\n            background: var(--input-bg);\n            color: var(--text-primary);\n            font-size: 15px;\n            font-weight: 600;\n            cursor: pointer;\n            transition: opacity 0.2s, border-color 0.2s, background 0.2s;\n            display: flex;\n            align-items: center;\n            justify-content: center;\n            gap: 8px;\n        }\n        .btn-app:hover { border-color: var(--text-secondary); }\n        .btn-app:active { opacity: 0.7; }\n        .btn-app:focus-visible { outline: 2px solid var(--accent); outline-offset: 2px; }\n        .btn-app svg { width: 20px; height: 20px; }\n        @media (prefers-reduced-motion: reduce) {\n            *, *::before, *::after { transition-duration: 0.01ms !important; }\n        }\n    </style>\n</head>\n<body>\n    <div class=\"card\">\n        <div class=\"logo\">\n            <div class=\"logo-icon\">\n                <img src=\"icon.png\" alt=\"Koala Clash\">\n            </div>\n            <h1>Koala Clash</h1>\n        </div>\n        <p class=\"subtitle\" id=\"subtitle\"></p>\n        <div class=\"tabs\">\n            <button type=\"button\" class=\"tab active\" id=\"tab-url\"></button>\n            <button type=\"button\" class=\"tab\" id=\"tab-file\"></button>\n        </div>\n        <div id=\"mode-url\" class=\"mode active\">\n            <form id=\"f-url\" method=\"POST\">\n                <input type=\"url\" name=\"url\" id=\"url\" placeholder=\"https://example.com/sub\"\n                       autocomplete=\"off\" autocapitalize=\"off\" required>\n                <p class=\"error\" id=\"err-url\"></p>\n                <button type=\"submit\" class=\"btn-submit\" id=\"btn-url\"></button>\n            </form>\n        </div>\n        <div id=\"mode-file\" class=\"mode\">\n            <form id=\"f-file\" method=\"POST\" enctype=\"multipart/form-data\">\n                <input type=\"file\" name=\"file\" id=\"file-input\" accept=\".yaml,.yml\">\n                <div class=\"file-drop\" id=\"file-drop\">\n                    <svg class=\"file-drop-icon\" viewBox=\"0 0 24 24\" fill=\"none\" stroke=\"currentColor\" stroke-width=\"1.5\" stroke-linecap=\"round\" stroke-linejoin=\"round\"><path d=\"M21 15v4a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2v-4\"/><polyline points=\"17 8 12 3 7 8\"/><line x1=\"12\" y1=\"3\" x2=\"12\" y2=\"15\"/></svg>\n                    <div class=\"file-drop-content\">\n                        <span id=\"file-drop-text\"></span>\n                        <div class=\"file-name\" id=\"file-name\"></div>\n                    </div>\n                </div>\n                <p class=\"error\" id=\"err-file\"></p>\n                <button type=\"submit\" class=\"btn-submit\" id=\"btn-file\" disabled></button>\n            </form>\n        </div>\n        <div class=\"divider\" id=\"divider\"></div>\n        <button type=\"button\" class=\"btn-app\" id=\"btn-app\">\n            <svg viewBox=\"0 0 24 24\" fill=\"none\" stroke=\"currentColor\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"><rect x=\"5\" y=\"2\" width=\"14\" height=\"20\" rx=\"2\" ry=\"2\"/><line x1=\"12\" y1=\"18\" x2=\"12.01\" y2=\"18\"/></svg>\n            <span id=\"btn-app-text\"></span>\n        </button>\n    </div>\n    <script>\n        var L = {\n            en: { subtitle: 'Add profile to your TV', tab_url: 'URL', tab_file: 'File', btn: 'Send to TV', sending: 'Sending…', net_err: 'Network error', drop_hint: 'Tap to select .yaml file', drop_or: 'or drag and drop here', or_divider: 'or', from_app: 'Send from app' },\n            ru: { subtitle: 'Добавить профиль на ТВ', tab_url: 'Ссылка', tab_file: 'Файл', btn: 'Отправить на ТВ', sending: 'Отправка…', net_err: 'Ошибка сети', drop_hint: 'Нажмите для выбора .yaml файла', drop_or: 'или перетащите сюда', or_divider: 'или', from_app: 'Отправить из приложения' },\n            zh: { subtitle: '添加配置到电视', tab_url: '链接', tab_file: '文件', btn: '发送到电视', sending: '发送中…', net_err: '网络错误', drop_hint: '点击选择 .yaml 文件', drop_or: '或拖放到此处', or_divider: '或', from_app: '从应用发送' }\n        };\n        var lang = (navigator.language || '').slice(0, 2).toLowerCase();\n        var t = L[lang] || L.en;\n        document.getElementById('subtitle').textContent = t.subtitle;\n        document.getElementById('tab-url').textContent = t.tab_url;\n        document.getElementById('tab-file').textContent = t.tab_file;\n        document.getElementById('btn-url').textContent = t.btn;\n        document.getElementById('btn-file').textContent = t.btn;\n        document.getElementById('file-drop-text').textContent = t.drop_hint;\n        document.getElementById('divider').textContent = t.or_divider;\n        document.getElementById('btn-app-text').textContent = t.from_app;\n\n        var tabUrl = document.getElementById('tab-url');\n        var tabFile = document.getElementById('tab-file');\n        var modeUrl = document.getElementById('mode-url');\n        var modeFile = document.getElementById('mode-file');\n        tabUrl.addEventListener('click', function() {\n            tabUrl.classList.add('active'); tabFile.classList.remove('active');\n            modeUrl.classList.add('active'); modeFile.classList.remove('active');\n        });\n        tabFile.addEventListener('click', function() {\n            tabFile.classList.add('active'); tabUrl.classList.remove('active');\n            modeFile.classList.add('active'); modeUrl.classList.remove('active');\n        });\n\n        function sendForm(fd, btnEl, errEl) {\n            btnEl.disabled = true;\n            btnEl.textContent = t.sending;\n            errEl.style.display = 'none';\n            fetch(window.location.href, { method: 'POST', body: fd })\n                .then(function(r) { return r.text().then(function(txt) { return { ok: r.ok, html: txt }; }); })\n                .then(function(d) { document.open(); document.write(d.html); document.close(); })\n                .catch(function() {\n                    errEl.textContent = t.net_err;\n                    errEl.style.display = 'block';\n                    btnEl.disabled = false;\n                    btnEl.textContent = t.btn;\n                });\n        }\n\n        var fUrl = document.getElementById('f-url');\n        fUrl.addEventListener('submit', function(e) {\n            e.preventDefault();\n            var url = document.getElementById('url').value.trim();\n            if (!url) return;\n            var fd = new FormData();\n            fd.append('mode', 'url');\n            fd.append('url', url);\n            sendForm(fd, document.getElementById('btn-url'), document.getElementById('err-url'));\n        });\n\n        var fileInput = document.getElementById('file-input');\n        var fileDrop = document.getElementById('file-drop');\n        var fileName = document.getElementById('file-name');\n        var btnFile = document.getElementById('btn-file');\n\n        fileDrop.addEventListener('click', function() { fileInput.click(); });\n        fileInput.addEventListener('change', function() {\n            if (fileInput.files.length > 0) {\n                fileName.textContent = fileInput.files[0].name;\n                fileDrop.classList.add('has-file');\n                btnFile.disabled = false;\n            }\n        });\n        fileDrop.addEventListener('dragover', function(e) {\n            e.preventDefault(); fileDrop.classList.add('dragover');\n        });\n        fileDrop.addEventListener('dragleave', function() {\n            fileDrop.classList.remove('dragover');\n        });\n        fileDrop.addEventListener('drop', function(e) {\n            e.preventDefault(); fileDrop.classList.remove('dragover');\n            if (e.dataTransfer.files.length > 0) {\n                fileInput.files = e.dataTransfer.files;\n                fileName.textContent = e.dataTransfer.files[0].name;\n                fileDrop.classList.add('has-file');\n                btnFile.disabled = false;\n            }\n        });\n\n        var fFile = document.getElementById('f-file');\n        fFile.addEventListener('submit', function(e) {\n            e.preventDefault();\n            if (fileInput.files.length === 0) return;\n            var fd = new FormData();\n            fd.append('mode', 'file');\n            fd.append('file', fileInput.files[0]);\n            sendForm(fd, btnFile, document.getElementById('err-file'));\n        });\n\n        document.getElementById('btn-app').addEventListener('click', function() {\n            var cb = encodeURIComponent(window.location.href);\n            var deeplink = 'koala-clash://share-to-tv?callback=' + cb;\n            window.location.href = deeplink;\n        });\n    </script>\n</body>\n</html>");
            }
            return NanoHTTPD.newFixedLengthResponse(status, "text/html", StringsKt__IndentKt.trimIndent("\n            <!DOCTYPE html>\n            <html>\n            <head>\n                <meta charset=\"UTF-8\">\n                <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n                <title>Koala Clash</title>\n                <link rel=\"icon\" type=\"image/png\" href=\"icon.png\">\n                <style>\n                    * { margin: 0; padding: 0; box-sizing: border-box; }\n                    :root {\n                        --bg: #08111A;\n                        --text-primary: #FAFAFA;\n                        --text-secondary: #99B3D7;\n                        --accent: #00FF77;\n                    }\n                    @media (prefers-color-scheme: light) {\n                        :root {\n                            --bg: #C5D4F1;\n                            --text-primary: #0A0A0A;\n                            --text-secondary: #4A5568;\n                            --accent: #00CA5E;\n                        }\n                    }\n                    body {\n                        font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, sans-serif;\n                        background: var(--bg);\n                        color: var(--text-primary);\n                        min-height: 100dvh;\n                        display: flex;\n                        align-items: center;\n                        justify-content: center;\n                    }\n                    .msg { text-align: center; }\n                    .msg p { font-size: 14px; color: var(--text-secondary); margin-top: 16px; }\n                    .spinner {\n                        width: 36px;\n                        height: 36px;\n                        border: 3px solid var(--text-secondary);\n                        border-top-color: var(--accent);\n                        border-radius: 50%;\n                        margin: 0 auto;\n                        animation: spin 0.8s linear infinite;\n                    }\n                    @keyframes spin { to { transform: rotate(360deg); } }\n                    @media (prefers-reduced-motion: reduce) {\n                        .spinner { animation: none; border-top-color: var(--text-secondary); border-right-color: var(--accent); }\n                    }\n                </style>\n            </head>\n            <body>\n                <div class=\"msg\">\n                    <div class=\"spinner\"></div>\n                    <p id=\"status\"></p>\n                </div>\n                <form id=\"af\" method=\"POST\" style=\"display:none\">\n                    <input type=\"hidden\" name=\"mode\" value=\"url\">\n                    <input type=\"hidden\" name=\"url\" value=\"" + StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(str, "&", "&amp;"), "<", "&lt;"), ">", "&gt;"), "\"", "&quot;") + "\">\n                </form>\n                <script>\n                    var L = {\n                        en: { sending: 'Sending to TV…' },\n                        ru: { sending: 'Отправка на ТВ…' },\n                        zh: { sending: '正在发送到电视…' }\n                    };\n                    var lang = (navigator.language || '').slice(0,2).toLowerCase();\n                    var t = L[lang] || L.en;\n                    document.getElementById('status').textContent = t.sending;\n                    var form = document.getElementById('af');\n                    form.action = window.location.pathname;\n                    form.submit();\n                </script>\n            </body>\n            </html>\n        "));
        }
        if (hTTPSession.method != 3 || !strRemovePrefix.equals(this.token)) {
            return NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.NOT_FOUND, "text/plain", "Not Found");
        }
        if (this.tokenConsumed) {
            return NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.FORBIDDEN, "text/html", buildResultPage$default(this, false, "already_used", null, null, 12));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            if (hTTPSession.headers.containsKey("content-length")) {
                j = Long.parseLong((String) hTTPSession.headers.get("content-length"));
            } else {
                int i = hTTPSession.splitbyte;
                int i2 = hTTPSession.rlen;
                j = i < i2 ? i2 - i : 0L;
            }
            if (j < 1024) {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    randomAccessFile = new DataOutputStream(byteArrayOutputStream);
                    r15 = 0;
                } catch (Throwable th) {
                    th = th;
                    r3 = 0;
                    NanoHTTPD.safeClose(r3);
                    throw th;
                }
            } else {
                try {
                    CacheStrategy cacheStrategy = hTTPSession.tempFileManager;
                    NanoHTTPD.DefaultTempFile defaultTempFile = new NanoHTTPD.DefaultTempFile((File) cacheStrategy.networkRequest);
                    ((ArrayList) cacheStrategy.cacheResponse).add(defaultTempFile);
                    randomAccessFile = new RandomAccessFile(defaultTempFile.file.getAbsolutePath(), "rw");
                    r15 = randomAccessFile;
                    byteArrayOutputStream = null;
                } catch (Exception e) {
                    obj = null;
                    try {
                        throw new Error(e);
                    } catch (Throwable th2) {
                        th = th2;
                        r3 = obj;
                        NanoHTTPD.safeClose(r3);
                        throw th;
                    }
                }
            }
            try {
                byte[] bArr = new byte[512];
                r15 = r15;
                while (hTTPSession.rlen >= 0 && j > 0) {
                    try {
                        r20 = r15;
                        try {
                            int i3 = hTTPSession.inputStream.read(bArr, 0, (int) Math.min(j, 512L));
                            hTTPSession.rlen = i3;
                            j -= (long) i3;
                            if (i3 > 0) {
                                randomAccessFile.write(bArr, 0, i3);
                            }
                            r15 = r20;
                        } catch (Throwable th3) {
                            th = th3;
                            r3 = r20;
                            NanoHTTPD.safeClose(r3);
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        r20 = r15;
                        r3 = r20;
                        NanoHTTPD.safeClose(r3);
                        throw th;
                    }
                }
                r20 = r15;
                if (byteArrayOutputStream != null) {
                    map = ByteBuffer.wrap(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
                    r7 = r20;
                } else {
                    try {
                        map = r20.getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, r20.length());
                        r6 = r20;
                        try {
                            r6.seek(0L);
                            r7 = r6;
                        } catch (Throwable th5) {
                            th = th5;
                            r3 = r6;
                            NanoHTTPD.safeClose(r3);
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        r6 = r20;
                    }
                }
                if (CaptureSession$State$EnumUnboxingLocalUtility.equals(3, hTTPSession.method)) {
                    NanoHTTPD.ContentType contentType = new NanoHTTPD.ContentType((String) hTTPSession.headers.get("content-type"));
                    String str2 = contentType.contentType;
                    if (!"multipart/form-data".equalsIgnoreCase(str2)) {
                        byte[] bArr2 = new byte[map.remaining()];
                        map.get(bArr2);
                        String strTrim = new String(bArr2, contentType.getEncoding()).trim();
                        if ("application/x-www-form-urlencoded".equalsIgnoreCase(str2)) {
                            NanoHTTPD.HTTPSession.decodeParms(strTrim, hTTPSession.parms);
                        } else if (strTrim.length() != 0) {
                            linkedHashMap.put("postData", strTrim);
                        }
                    } else {
                        if (contentType.boundary == null) {
                            throw new NanoHTTPD.ResponseException(status2, "BAD REQUEST: Content type is multipart/form-data but boundary missing. Usage: GET /example/file.html");
                        }
                        hTTPSession.decodeMultipartFormData(contentType, map, hTTPSession.parms, linkedHashMap);
                    }
                } else if (CaptureSession$State$EnumUnboxingLocalUtility.equals(2, hTTPSession.method)) {
                    linkedHashMap.put("content", hTTPSession.saveTmpFile(map, 0, map.limit()));
                }
                NanoHTTPD.safeClose(r7);
                String str3 = (String) hTTPSession.getParms().get("mode");
                if (str3 == null) {
                    str3 = "url";
                }
                if (!str3.equals("file")) {
                    String str4 = (String) hTTPSession.getParms().get("url");
                    String string = str4 != null ? StringsKt.trim(str4).toString() : null;
                    if (string == null || StringsKt.isBlank(string)) {
                        return NanoHTTPD.newFixedLengthResponse(status2, "text/html", buildResultPage$default(this, false, "empty_url", null, null, 12));
                    }
                    String lowerCase = string.toLowerCase(Locale.ROOT);
                    if (!StringsKt__StringsJVMKt.startsWith(lowerCase, "http://", false) && !StringsKt__StringsJVMKt.startsWith(lowerCase, "https://", false)) {
                        return NanoHTTPD.newFixedLengthResponse(status2, "text/html", buildResultPage$default(this, false, "invalid_url", null, null, 12));
                    }
                    this.tokenConsumed = true;
                    return buildResponseFromResult((ProfileAddResult) JobKt.runBlocking(emptyCoroutineContext, new FilesActivity$showError$1(this, string, null, 12)));
                }
                String str5 = (String) linkedHashMap.get("file");
                if (str5 == null || StringsKt.isBlank(str5)) {
                    return NanoHTTPD.newFixedLengthResponse(status2, "text/html", buildResultPage$default(this, false, "empty_file", null, null, 12));
                }
                File file = new File(str5);
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    long length = file.length();
                    try {
                        if (length > 2147483647L) {
                            throw new OutOfMemoryError("File " + file + " is too big (" + length + " bytes) to fit in memory.");
                        }
                        int i4 = (int) length;
                        byte[] bArrCopyOf = new byte[i4];
                        int i5 = i4;
                        int i6 = 0;
                        while (i5 > 0) {
                            int i7 = fileInputStream.read(bArrCopyOf, i6, i5);
                            if (i7 < 0) {
                                break;
                            }
                            i5 -= i7;
                            i6 += i7;
                        }
                        if (i5 > 0) {
                            bArrCopyOf = Arrays.copyOf(bArrCopyOf, i6);
                        } else {
                            int i8 = fileInputStream.read();
                            if (i8 != -1) {
                                ExposingBufferByteArrayOutputStream exposingBufferByteArrayOutputStream = new ExposingBufferByteArrayOutputStream(8193);
                                exposingBufferByteArrayOutputStream.write(i8);
                                ByteStreamsKt.copyTo$default(fileInputStream, exposingBufferByteArrayOutputStream);
                                int size = exposingBufferByteArrayOutputStream.size() + i4;
                                if (size < 0) {
                                    throw new OutOfMemoryError("File " + file + " is too big to fit in memory.");
                                }
                                byte[] buffer = exposingBufferByteArrayOutputStream.getBuffer();
                                bArrCopyOf = Arrays.copyOf(bArrCopyOf, size);
                                System.arraycopy(buffer, 0, bArrCopyOf, i4, exposingBufferByteArrayOutputStream.size());
                            }
                        }
                        fileInputStream.close();
                        if (bArrCopyOf.length == 0) {
                            return NanoHTTPD.newFixedLengthResponse(status2, "text/html", buildResultPage$default(this, false, "empty_file", null, null, 12));
                        }
                        this.tokenConsumed = true;
                        return buildResponseFromResult((ProfileAddResult) JobKt.runBlocking(emptyCoroutineContext, new FilesActivity$showError$1(this, bArrCopyOf, null, 11)));
                    } catch (Throwable th7) {
                        th = th7;
                        Throwable th8 = th;
                        try {
                            throw th8;
                        } catch (Throwable th9) {
                            CloseableKt.closeFinally(fileInputStream, th8);
                            throw th9;
                        }
                    }
                } catch (Throwable th10) {
                    th = th10;
                }
            } catch (Throwable th11) {
                th = th11;
                r6 = r15;
            }
        } catch (Throwable th12) {
            th = th12;
            obj = null;
        }
    }
}
