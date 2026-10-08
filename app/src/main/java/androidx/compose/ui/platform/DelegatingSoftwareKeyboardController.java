package androidx.compose.ui.platform;

import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputSession;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class DelegatingSoftwareKeyboardController implements SoftwareKeyboardController {
    public final TextInputService textInputService;

    public DelegatingSoftwareKeyboardController(TextInputService textInputService) {
        this.textInputService = textInputService;
    }

    public final void hide() {
        this.textInputService.platformTextInputService.hideSoftwareKeyboard();
    }

    public final void show() {
        TextInputService textInputService = this.textInputService;
        if (((TextInputSession) textInputService._currentInputSession.get()) != null) {
            textInputService.platformTextInputService.showSoftwareKeyboard();
        }
    }
}
