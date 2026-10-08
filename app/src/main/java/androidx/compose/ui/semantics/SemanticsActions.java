package androidx.compose.ui.semantics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class SemanticsActions {
    public static final SemanticsPropertyKey ClearTextSubstitution;
    public static final SemanticsPropertyKey Collapse;
    public static final SemanticsPropertyKey CopyText;
    public static final SemanticsPropertyKey CustomActions;
    public static final SemanticsPropertyKey CutText;
    public static final SemanticsPropertyKey Dismiss;
    public static final SemanticsPropertyKey Expand;
    public static final SemanticsPropertyKey GetScrollViewportLength;
    public static final SemanticsPropertyKey GetTextLayoutResult;
    public static final SemanticsPropertyKey InsertTextAtCursor;
    public static final SemanticsPropertyKey OnAutofillText;
    public static final SemanticsPropertyKey OnClick;
    public static final SemanticsPropertyKey OnFillData;
    public static final SemanticsPropertyKey OnImeAction;
    public static final SemanticsPropertyKey OnLongClick;
    public static final SemanticsPropertyKey PageDown;
    public static final SemanticsPropertyKey PageLeft;
    public static final SemanticsPropertyKey PageRight;
    public static final SemanticsPropertyKey PageUp;
    public static final SemanticsPropertyKey PasteText;
    public static final SemanticsPropertyKey RequestFocus;
    public static final SemanticsPropertyKey ScrollBy;
    public static final SemanticsPropertyKey ScrollByOffset;
    public static final SemanticsPropertyKey ScrollToIndex;
    public static final SemanticsPropertyKey SetProgress;
    public static final SemanticsPropertyKey SetSelection;
    public static final SemanticsPropertyKey SetText;
    public static final SemanticsPropertyKey SetTextSubstitution;
    public static final SemanticsPropertyKey ShowTextSubstitution;

    static {
        SemanticsPropertyKey.AnonymousClass1 anonymousClass1 = SemanticsPropertyKey.AnonymousClass1.INSTANCE$19;
        GetTextLayoutResult = new SemanticsPropertyKey("GetTextLayoutResult", true, anonymousClass1);
        OnClick = new SemanticsPropertyKey("OnClick", true, anonymousClass1);
        OnLongClick = new SemanticsPropertyKey("OnLongClick", true, anonymousClass1);
        ScrollBy = new SemanticsPropertyKey("ScrollBy", true, anonymousClass1);
        ScrollByOffset = new SemanticsPropertyKey("ScrollByOffset");
        ScrollToIndex = new SemanticsPropertyKey("ScrollToIndex", true, anonymousClass1);
        OnAutofillText = new SemanticsPropertyKey("OnAutofillText", true, anonymousClass1);
        OnFillData = new SemanticsPropertyKey("OnFillData", true, anonymousClass1);
        SetProgress = new SemanticsPropertyKey("SetProgress", true, anonymousClass1);
        SetSelection = new SemanticsPropertyKey("SetSelection", true, anonymousClass1);
        SetText = new SemanticsPropertyKey("SetText", true, anonymousClass1);
        SetTextSubstitution = new SemanticsPropertyKey("SetTextSubstitution", true, anonymousClass1);
        ShowTextSubstitution = new SemanticsPropertyKey("ShowTextSubstitution", true, anonymousClass1);
        ClearTextSubstitution = new SemanticsPropertyKey("ClearTextSubstitution", true, anonymousClass1);
        InsertTextAtCursor = new SemanticsPropertyKey("InsertTextAtCursor", true, anonymousClass1);
        OnImeAction = new SemanticsPropertyKey("PerformImeAction", true, anonymousClass1);
        CopyText = new SemanticsPropertyKey("CopyText", true, anonymousClass1);
        CutText = new SemanticsPropertyKey("CutText", true, anonymousClass1);
        PasteText = new SemanticsPropertyKey("PasteText", true, anonymousClass1);
        Expand = new SemanticsPropertyKey("Expand", true, anonymousClass1);
        Collapse = new SemanticsPropertyKey("Collapse", true, anonymousClass1);
        Dismiss = new SemanticsPropertyKey("Dismiss", true, anonymousClass1);
        RequestFocus = new SemanticsPropertyKey("RequestFocus", true, anonymousClass1);
        CustomActions = new SemanticsPropertyKey("CustomActions", true, SemanticsPropertyKey.AnonymousClass1.INSTANCE$1);
        PageUp = new SemanticsPropertyKey("PageUp", true, anonymousClass1);
        PageLeft = new SemanticsPropertyKey("PageLeft", true, anonymousClass1);
        PageDown = new SemanticsPropertyKey("PageDown", true, anonymousClass1);
        PageRight = new SemanticsPropertyKey("PageRight", true, anonymousClass1);
        GetScrollViewportLength = new SemanticsPropertyKey("GetScrollViewportLength", true, anonymousClass1);
    }
}
