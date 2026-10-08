package androidx.transition;

import android.animation.Animator;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowId;
import android.widget.FrameLayout;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import com.koala.clash.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class TransitionManager {
    public static final AutoTransition sDefaultTransition;
    public static final ArrayList sPendingTransitions;
    public static final ThreadLocal sRunningTransitions;

    static {
        AutoTransition autoTransition = new AutoTransition();
        autoTransition.mTransitions = new ArrayList();
        autoTransition.mStarted = false;
        autoTransition.mChangeFlags = 0;
        autoTransition.mPlayTogether = false;
        autoTransition.addTransition(new Fade(2));
        autoTransition.addTransition(new ChangeBounds());
        autoTransition.addTransition(new Fade(1));
        sDefaultTransition = autoTransition;
        sRunningTransitions = new ThreadLocal();
        sPendingTransitions = new ArrayList();
    }

    public static void beginDelayedTransition(FrameLayout frameLayout, Transition transition) {
        ArrayList arrayList = sPendingTransitions;
        if (arrayList.contains(frameLayout) || !frameLayout.isLaidOut()) {
            return;
        }
        arrayList.add(frameLayout);
        if (transition == null) {
            transition = sDefaultTransition;
        }
        Transition transitionMo776clone = transition.mo776clone();
        ArrayList arrayList2 = (ArrayList) getRunningTransitions().get(frameLayout);
        if (arrayList2 != null && arrayList2.size() > 0) {
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList2.get(i);
                i++;
                ((Transition) obj).pause(frameLayout);
            }
        }
        transitionMo776clone.captureValues(frameLayout, true);
        if (frameLayout.getTag(R.id.transition_current_scene) != null) {
            throw new ClassCastException();
        }
        frameLayout.setTag(R.id.transition_current_scene, null);
        MultiListener multiListener = new MultiListener();
        multiListener.mTransition = transitionMo776clone;
        multiListener.mSceneRoot = frameLayout;
        frameLayout.addOnAttachStateChangeListener(multiListener);
        frameLayout.getViewTreeObserver().addOnPreDrawListener(multiListener);
    }

    public static ArrayMap getRunningTransitions() {
        ArrayMap arrayMap;
        ThreadLocal threadLocal = sRunningTransitions;
        WeakReference weakReference = (WeakReference) threadLocal.get();
        if (weakReference != null && (arrayMap = (ArrayMap) weakReference.get()) != null) {
            return arrayMap;
        }
        ArrayMap arrayMap2 = new ArrayMap(0);
        threadLocal.set(new WeakReference(arrayMap2));
        return arrayMap2;
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class MultiListener implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
        public ViewGroup mSceneRoot;
        public Transition mTransition;

        /* JADX WARN: Code duplicated, block: B:100:0x021f  */
        /* JADX WARN: Code duplicated, block: B:102:0x022d  */
        /* JADX WARN: Code duplicated, block: B:103:0x0239  */
        /* JADX WARN: Code duplicated, block: B:107:0x0250  */
        /* JADX WARN: Code duplicated, block: B:134:0x02bc  */
        /* JADX WARN: Code duplicated, block: B:136:0x02cb  */
        /* JADX WARN: Code duplicated, block: B:141:0x01f7 A[EDGE_INSN: B:141:0x01f7->B:90:0x01f7 BREAK  A[LOOP:1: B:18:0x0084->B:89:0x01ed], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:14:0x004c  */
        /* JADX WARN: Code duplicated, block: B:16:0x0053 A[LOOP:0: B:15:0x0051->B:16:0x0053, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:171:0x0217 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:186:0x02d3 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:20:0x0089  */
        /* JADX WARN: Code duplicated, block: B:22:0x008d  */
        /* JADX WARN: Code duplicated, block: B:24:0x0090  */
        /* JADX WARN: Code duplicated, block: B:26:0x0093  */
        /* JADX WARN: Code duplicated, block: B:28:0x0096  */
        /* JADX WARN: Code duplicated, block: B:29:0x009b  */
        /* JADX WARN: Code duplicated, block: B:31:0x00aa  */
        /* JADX WARN: Code duplicated, block: B:44:0x00f4  */
        /* JADX WARN: Code duplicated, block: B:47:0x0104  */
        /* JADX WARN: Code duplicated, block: B:49:0x0119  */
        /* JADX WARN: Code duplicated, block: B:62:0x015e  */
        /* JADX WARN: Code duplicated, block: B:64:0x016e  */
        /* JADX WARN: Code duplicated, block: B:77:0x01b3  */
        /* JADX WARN: Code duplicated, block: B:79:0x01bc  */
        /* JADX WARN: Code duplicated, block: B:93:0x01fe  */
        /* JADX WARN: Code duplicated, block: B:95:0x020c  */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            ArrayList arrayList;
            int i;
            Dispatcher dispatcher;
            Dispatcher dispatcher2;
            ArrayMap arrayMap;
            ArrayMap arrayMap2;
            int i2;
            int[] iArr;
            boolean z;
            int i3;
            int i4;
            ArrayMap runningAnimators;
            ArrayList arrayList2;
            int i5;
            int i6;
            Transition transition;
            Animator animator;
            Transition.AnimationInfo animationInfo;
            TransitionValues transitionValues;
            TransitionValues transitionValues2;
            int i7;
            Dispatcher dispatcher3;
            boolean z2;
            int i8;
            View view;
            TransitionValues transitionValues3;
            ArrayMap arrayMap3;
            int i9;
            int i10;
            View view2;
            View view3;
            SparseArray sparseArray;
            int size;
            int i11;
            View view4;
            View view5;
            LongSparseArray longSparseArray;
            int size2;
            int i12;
            View view6;
            Dispatcher dispatcher4;
            int size3;
            int i13;
            Transition transition2 = this.mTransition;
            ViewGroup viewGroup = this.mSceneRoot;
            viewGroup.getViewTreeObserver().removeOnPreDrawListener(this);
            viewGroup.removeOnAttachStateChangeListener(this);
            boolean z3 = true;
            if (!TransitionManager.sPendingTransitions.remove(viewGroup)) {
                return true;
            }
            final ArrayMap runningTransitions = TransitionManager.getRunningTransitions();
            ArrayList arrayList3 = (ArrayList) runningTransitions.get(viewGroup);
            if (arrayList3 != null) {
                arrayList = arrayList3.size() > 0 ? new ArrayList(arrayList3) : null;
                arrayList3.add(transition2);
                transition2.addListener(new TransitionListenerAdapter() { // from class: androidx.transition.TransitionManager.MultiListener.1
                    @Override // androidx.transition.Transition.TransitionListener
                    public final void onTransitionEnd(Transition transition3) {
                        ((ArrayList) runningTransitions.get(MultiListener.this.mSceneRoot)).remove(transition3);
                        transition3.removeListener(this);
                    }
                });
                i = 0;
                transition2.captureValues(viewGroup, false);
                if (arrayList != null) {
                    size3 = arrayList.size();
                    i13 = 0;
                    while (i13 < size3) {
                        Object obj = arrayList.get(i13);
                        i13++;
                        ((Transition) obj).resume(viewGroup);
                    }
                }
                transition2.mStartValuesList = new ArrayList();
                transition2.mEndValuesList = new ArrayList();
                dispatcher = transition2.mStartValues;
                dispatcher2 = transition2.mEndValues;
                arrayMap = new ArrayMap((ArrayMap) dispatcher.executorServiceOrNull);
                arrayMap2 = new ArrayMap((ArrayMap) dispatcher2.executorServiceOrNull);
                i2 = 0;
                while (true) {
                    iArr = transition2.mMatchOrder;
                    if (i2 < iArr.length) {
                        break;
                    }
                    i7 = iArr[i2];
                    if (i7 != z3) {
                        dispatcher3 = dispatcher2;
                        z2 = z3;
                        for (i8 = arrayMap.size - 1; i8 >= 0; i8--) {
                            view = (View) arrayMap.keyAt(i8);
                            if (view == null && transition2.isValidTarget(view) && (transitionValues3 = (TransitionValues) arrayMap2.remove(view)) != null && transition2.isValidTarget(transitionValues3.view)) {
                                transition2.mStartValuesList.add((TransitionValues) arrayMap.removeAt(i8));
                                transition2.mEndValuesList.add(transitionValues3);
                            }
                        }
                    } else if (i7 != 2) {
                        dispatcher3 = dispatcher2;
                        z2 = z3;
                        arrayMap3 = (ArrayMap) dispatcher.runningSyncCalls;
                        ArrayMap arrayMap4 = (ArrayMap) dispatcher3.runningSyncCalls;
                        i9 = arrayMap3.size;
                        for (i10 = 0; i10 < i9; i10++) {
                            view2 = (View) arrayMap3.valueAt(i10);
                            if (view2 == null && transition2.isValidTarget(view2) && (view3 = (View) arrayMap4.get((String) arrayMap3.keyAt(i10))) != null && transition2.isValidTarget(view3)) {
                                TransitionValues transitionValues4 = (TransitionValues) arrayMap.get(view2);
                                TransitionValues transitionValues5 = (TransitionValues) arrayMap2.get(view3);
                                if (transitionValues4 != null && transitionValues5 != null) {
                                    transition2.mStartValuesList.add(transitionValues4);
                                    transition2.mEndValuesList.add(transitionValues5);
                                    arrayMap.remove(view2);
                                    arrayMap2.remove(view3);
                                }
                            }
                        }
                    } else if (i7 != 3) {
                        z2 = z3;
                        sparseArray = (SparseArray) dispatcher.readyAsyncCalls;
                        dispatcher3 = dispatcher2;
                        SparseArray sparseArray2 = (SparseArray) dispatcher3.readyAsyncCalls;
                        size = sparseArray.size();
                        for (i11 = 0; i11 < size; i11++) {
                            view4 = (View) sparseArray.valueAt(i11);
                            if (view4 == null && transition2.isValidTarget(view4) && (view5 = (View) sparseArray2.get(sparseArray.keyAt(i11))) != null && transition2.isValidTarget(view5)) {
                                TransitionValues transitionValues6 = (TransitionValues) arrayMap.get(view4);
                                TransitionValues transitionValues7 = (TransitionValues) arrayMap2.get(view5);
                                if (transitionValues6 != null && transitionValues7 != null) {
                                    transition2.mStartValuesList.add(transitionValues6);
                                    transition2.mEndValuesList.add(transitionValues7);
                                    arrayMap.remove(view4);
                                    arrayMap2.remove(view5);
                                }
                            }
                        }
                    } else if (i7 != 4) {
                        dispatcher3 = dispatcher2;
                        z2 = z3;
                    } else {
                        longSparseArray = (LongSparseArray) dispatcher.runningAsyncCalls;
                        LongSparseArray longSparseArray2 = (LongSparseArray) dispatcher2.runningAsyncCalls;
                        size2 = longSparseArray.size();
                        i12 = i;
                        while (i12 < size2) {
                            view6 = (View) longSparseArray.valueAt(i12);
                            if (view6 == null && transition2.isValidTarget(view6)) {
                                dispatcher4 = dispatcher2;
                                View view7 = (View) longSparseArray2.get(longSparseArray.keyAt(i12));
                                if (view7 != null && transition2.isValidTarget(view7)) {
                                    TransitionValues transitionValues8 = (TransitionValues) arrayMap.get(view6);
                                    TransitionValues transitionValues9 = (TransitionValues) arrayMap2.get(view7);
                                    if (transitionValues8 != null && transitionValues9 != null) {
                                        transition2.mStartValuesList.add(transitionValues8);
                                        transition2.mEndValuesList.add(transitionValues9);
                                        arrayMap.remove(view6);
                                        arrayMap2.remove(view7);
                                    }
                                }
                                i12++;
                                dispatcher2 = dispatcher4;
                                z3 = z3;
                            } else {
                                dispatcher4 = dispatcher2;
                            }
                            i12++;
                            dispatcher2 = dispatcher4;
                            z3 = z3;
                        }
                        z2 = z3;
                        dispatcher3 = dispatcher2;
                    }
                    i2++;
                    dispatcher2 = dispatcher3;
                    z3 = z2;
                    i = 0;
                }
                z = z3;
                for (i3 = 0; i3 < arrayMap.size; i3++) {
                    transitionValues2 = (TransitionValues) arrayMap.valueAt(i3);
                    if (transition2.isValidTarget(transitionValues2.view)) {
                        transition2.mStartValuesList.add(transitionValues2);
                        transition2.mEndValuesList.add(null);
                    }
                }
                for (i4 = 0; i4 < arrayMap2.size; i4++) {
                    transitionValues = (TransitionValues) arrayMap2.valueAt(i4);
                    if (transition2.isValidTarget(transitionValues.view)) {
                        transition2.mEndValuesList.add(transitionValues);
                        transition2.mStartValuesList.add(null);
                    }
                }
                runningAnimators = Transition.getRunningAnimators();
                int i14 = runningAnimators.size;
                WindowId windowId = viewGroup.getWindowId();
                arrayList2 = new ArrayList();
                i5 = i14 - 1;
                while (i5 >= 0) {
                    animator = (Animator) runningAnimators.keyAt(i5);
                    if (animator == null && (animationInfo = (Transition.AnimationInfo) runningAnimators.get(animator)) != null) {
                        Transition transition3 = animationInfo.mTransition;
                        View view8 = animationInfo.mView;
                        if (view8 != null && windowId.equals(animationInfo.mWindowId)) {
                            TransitionValues transitionValues10 = animationInfo.mValues;
                            boolean z4 = z;
                            TransitionValues transitionValues11 = transition2.getTransitionValues(view8, z4);
                            TransitionValues matchedTransitionValues = transition2.getMatchedTransitionValues(view8, z4);
                            if (transitionValues11 == null && matchedTransitionValues == null) {
                                matchedTransitionValues = (TransitionValues) ((ArrayMap) transition2.mEndValues.executorServiceOrNull).get(view8);
                            }
                            if ((transitionValues11 != null || matchedTransitionValues != null) && transition3.isTransitionRequired(transitionValues10, matchedTransitionValues)) {
                                transition3.getRootTransition().getClass();
                                if (animator.isRunning() || animator.isStarted()) {
                                    animator.cancel();
                                } else {
                                    runningAnimators.removeAt(i5);
                                }
                            }
                        }
                    }
                    i5--;
                    z = true;
                }
                for (i6 = 0; i6 < arrayList2.size(); i6++) {
                    transition = (Transition) arrayList2.get(i6);
                    transition.notifyFromTransition(transition, Transition.TransitionNotification.ON_CANCEL);
                    if (!transition.mEnded) {
                        transition.mEnded = true;
                        transition.notifyFromTransition(transition, Transition.TransitionNotification.ON_END);
                    }
                }
                transition2.createAnimators(viewGroup, transition2.mStartValues, transition2.mEndValues, transition2.mStartValuesList, transition2.mEndValuesList);
                transition2.runAnimators();
                return true;
            }
            arrayList3 = new ArrayList();
            runningTransitions.put(viewGroup, arrayList3);
            arrayList3.add(transition2);
            transition2.addListener(new TransitionListenerAdapter() { // from class: androidx.transition.TransitionManager.MultiListener.1
                @Override // androidx.transition.Transition.TransitionListener
                public final void onTransitionEnd(Transition transition4) {
                    ((ArrayList) runningTransitions.get(MultiListener.this.mSceneRoot)).remove(transition4);
                    transition4.removeListener(this);
                }
            });
            i = 0;
            transition2.captureValues(viewGroup, false);
            if (arrayList != null) {
                size3 = arrayList.size();
                i13 = 0;
                while (i13 < size3) {
                    Object obj2 = arrayList.get(i13);
                    i13++;
                    ((Transition) obj2).resume(viewGroup);
                }
            }
            transition2.mStartValuesList = new ArrayList();
            transition2.mEndValuesList = new ArrayList();
            dispatcher = transition2.mStartValues;
            dispatcher2 = transition2.mEndValues;
            arrayMap = new ArrayMap((ArrayMap) dispatcher.executorServiceOrNull);
            arrayMap2 = new ArrayMap((ArrayMap) dispatcher2.executorServiceOrNull);
            i2 = 0;
            while (true) {
                iArr = transition2.mMatchOrder;
                if (i2 < iArr.length) {
                    break;
                    break;
                }
                i7 = iArr[i2];
                if (i7 != z3) {
                    dispatcher3 = dispatcher2;
                    z2 = z3;
                    while (i8 >= 0) {
                        view = (View) arrayMap.keyAt(i8);
                        if (view == null) {
                        }
                    }
                } else if (i7 != 2) {
                    dispatcher3 = dispatcher2;
                    z2 = z3;
                    arrayMap3 = (ArrayMap) dispatcher.runningSyncCalls;
                    ArrayMap arrayMap5 = (ArrayMap) dispatcher3.runningSyncCalls;
                    i9 = arrayMap3.size;
                    while (i10 < i9) {
                        view2 = (View) arrayMap3.valueAt(i10);
                        if (view2 == null) {
                        }
                    }
                } else if (i7 != 3) {
                    z2 = z3;
                    sparseArray = (SparseArray) dispatcher.readyAsyncCalls;
                    dispatcher3 = dispatcher2;
                    SparseArray sparseArray3 = (SparseArray) dispatcher3.readyAsyncCalls;
                    size = sparseArray.size();
                    while (i11 < size) {
                        view4 = (View) sparseArray.valueAt(i11);
                        if (view4 == null) {
                        }
                    }
                } else if (i7 != 4) {
                    dispatcher3 = dispatcher2;
                    z2 = z3;
                } else {
                    longSparseArray = (LongSparseArray) dispatcher.runningAsyncCalls;
                    LongSparseArray longSparseArray3 = (LongSparseArray) dispatcher2.runningAsyncCalls;
                    size2 = longSparseArray.size();
                    i12 = i;
                    while (i12 < size2) {
                        view6 = (View) longSparseArray.valueAt(i12);
                        if (view6 == null) {
                            dispatcher4 = dispatcher2;
                        } else {
                            dispatcher4 = dispatcher2;
                        }
                        i12++;
                        dispatcher2 = dispatcher4;
                        z3 = z3;
                    }
                    z2 = z3;
                    dispatcher3 = dispatcher2;
                }
                i2++;
                dispatcher2 = dispatcher3;
                z3 = z2;
                i = 0;
            }
            z = z3;
            while (i3 < arrayMap.size) {
                transitionValues2 = (TransitionValues) arrayMap.valueAt(i3);
                if (transition2.isValidTarget(transitionValues2.view)) {
                    transition2.mStartValuesList.add(transitionValues2);
                    transition2.mEndValuesList.add(null);
                }
            }
            while (i4 < arrayMap2.size) {
                transitionValues = (TransitionValues) arrayMap2.valueAt(i4);
                if (transition2.isValidTarget(transitionValues.view)) {
                    transition2.mEndValuesList.add(transitionValues);
                    transition2.mStartValuesList.add(null);
                }
            }
            runningAnimators = Transition.getRunningAnimators();
            int i15 = runningAnimators.size;
            WindowId windowId2 = viewGroup.getWindowId();
            arrayList2 = new ArrayList();
            i5 = i15 - 1;
            while (i5 >= 0) {
                animator = (Animator) runningAnimators.keyAt(i5);
                if (animator == null) {
                }
                i5--;
                z = true;
            }
            while (i6 < arrayList2.size()) {
                transition = (Transition) arrayList2.get(i6);
                transition.notifyFromTransition(transition, Transition.TransitionNotification.ON_CANCEL);
                if (!transition.mEnded) {
                    transition.mEnded = true;
                    transition.notifyFromTransition(transition, Transition.TransitionNotification.ON_END);
                }
            }
            transition2.createAnimators(viewGroup, transition2.mStartValues, transition2.mEndValues, transition2.mStartValuesList, transition2.mEndValuesList);
            transition2.runAnimators();
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
            ViewGroup viewGroup = this.mSceneRoot;
            viewGroup.getViewTreeObserver().removeOnPreDrawListener(this);
            viewGroup.removeOnAttachStateChangeListener(this);
            TransitionManager.sPendingTransitions.remove(viewGroup);
            ArrayList arrayList = (ArrayList) TransitionManager.getRunningTransitions().get(viewGroup);
            if (arrayList != null && arrayList.size() > 0) {
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    ((Transition) obj).resume(viewGroup);
                }
            }
            this.mTransition.clearValues(true);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
        }
    }
}
