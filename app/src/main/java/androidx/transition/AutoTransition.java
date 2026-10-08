package androidx.transition;

import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Arrays;
import okhttp3.Dispatcher;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AutoTransition extends Transition {
    public int mChangeFlags;
    public int mCurrentListeners;
    public boolean mPlayTogether;
    public boolean mStarted;
    public ArrayList mTransitions;
    public Transition[] mTransitionsCache;

    public final void addTransition(Transition transition) {
        this.mTransitions.add(transition);
        transition.mParent = this;
        long j = this.mDuration;
        if (j >= 0) {
            transition.setDuration(j);
        }
        if ((this.mChangeFlags & 1) != 0) {
            transition.setInterpolator(this.mInterpolator);
        }
        if ((this.mChangeFlags & 2) != 0) {
            transition.setPropagation();
        }
        if ((this.mChangeFlags & 4) != 0) {
            transition.setPathMotion(this.mPathMotion);
        }
        if ((this.mChangeFlags & 8) != 0) {
            transition.setEpicenterCallback(null);
        }
    }

    @Override // androidx.transition.Transition
    public final void cancel() {
        super.cancel();
        Transition[] transitionArr = this.mTransitionsCache;
        this.mTransitionsCache = null;
        if (transitionArr == null) {
            transitionArr = new Transition[this.mTransitions.size()];
        }
        Transition[] transitionArr2 = (Transition[]) this.mTransitions.toArray(transitionArr);
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            transitionArr2[i].cancel();
        }
        Arrays.fill(transitionArr2, (Object) null);
        this.mTransitionsCache = transitionArr2;
    }

    @Override // androidx.transition.Transition
    public final void captureEndValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        if (isValidTarget(view)) {
            ArrayList arrayList = this.mTransitions;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                Transition transition = (Transition) obj;
                if (transition.isValidTarget(view)) {
                    transition.captureEndValues(transitionValues);
                    transitionValues.mTargetedTransitions.add(transition);
                }
            }
        }
    }

    @Override // androidx.transition.Transition
    public final void capturePropagationValues(TransitionValues transitionValues) {
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.mTransitions.get(i)).capturePropagationValues(transitionValues);
        }
    }

    @Override // androidx.transition.Transition
    public final void captureStartValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        if (isValidTarget(view)) {
            ArrayList arrayList = this.mTransitions;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                Transition transition = (Transition) obj;
                if (transition.isValidTarget(view)) {
                    transition.captureStartValues(transitionValues);
                    transitionValues.mTargetedTransitions.add(transition);
                }
            }
        }
    }

    @Override // androidx.transition.Transition
    public final void createAnimators(ViewGroup viewGroup, Dispatcher dispatcher, Dispatcher dispatcher2, ArrayList arrayList, ArrayList arrayList2) {
        long j = this.mStartDelay;
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            Transition transition = (Transition) this.mTransitions.get(i);
            if (j > 0 && (this.mPlayTogether || i == 0)) {
                long j2 = transition.mStartDelay;
                if (j2 > 0) {
                    transition.setStartDelay(j2 + j);
                } else {
                    transition.setStartDelay(j);
                }
            }
            transition.createAnimators(viewGroup, dispatcher, dispatcher2, arrayList, arrayList2);
        }
    }

    @Override // androidx.transition.Transition
    public final void pause(View view) {
        super.pause(view);
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.mTransitions.get(i)).pause(view);
        }
    }

    @Override // androidx.transition.Transition
    public final Transition removeListener(Transition.TransitionListener transitionListener) {
        super.removeListener(transitionListener);
        return this;
    }

    @Override // androidx.transition.Transition
    public final void resume(View view) {
        super.resume(view);
        Transition[] transitionArr = this.mTransitionsCache;
        this.mTransitionsCache = null;
        if (transitionArr == null) {
            transitionArr = new Transition[this.mTransitions.size()];
        }
        Transition[] transitionArr2 = (Transition[]) this.mTransitions.toArray(transitionArr);
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            transitionArr2[i].resume(view);
        }
        Arrays.fill(transitionArr2, (Object) null);
        this.mTransitionsCache = transitionArr2;
    }

    @Override // androidx.transition.Transition
    public final void runAnimators() {
        if (this.mTransitions.isEmpty()) {
            start();
            end();
            return;
        }
        TransitionSet$1 transitionSet$1 = new TransitionSet$1();
        transitionSet$1.val$nextTransition = this;
        ArrayList arrayList = this.mTransitions;
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            ((Transition) obj).addListener(transitionSet$1);
        }
        this.mCurrentListeners = this.mTransitions.size();
        if (this.mPlayTogether) {
            ArrayList arrayList2 = this.mTransitions;
            int size2 = arrayList2.size();
            while (i < size2) {
                Object obj2 = arrayList2.get(i);
                i++;
                ((Transition) obj2).runAnimators();
            }
            return;
        }
        for (int i3 = 1; i3 < this.mTransitions.size(); i3++) {
            ((Transition) this.mTransitions.get(i3 - 1)).addListener(new TransitionSet$1((Transition) this.mTransitions.get(i3)));
        }
        Transition transition = (Transition) this.mTransitions.get(0);
        if (transition != null) {
            transition.runAnimators();
        }
    }

    @Override // androidx.transition.Transition
    public final void setDuration(long j) {
        ArrayList arrayList;
        this.mDuration = j;
        if (j < 0 || (arrayList = this.mTransitions) == null) {
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.mTransitions.get(i)).setDuration(j);
        }
    }

    @Override // androidx.transition.Transition
    public final void setEpicenterCallback(Transition.EpicenterCallback epicenterCallback) {
        this.mChangeFlags |= 8;
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.mTransitions.get(i)).setEpicenterCallback(epicenterCallback);
        }
    }

    @Override // androidx.transition.Transition
    public final void setInterpolator(TimeInterpolator timeInterpolator) {
        this.mChangeFlags |= 1;
        ArrayList arrayList = this.mTransitions;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((Transition) this.mTransitions.get(i)).setInterpolator(timeInterpolator);
            }
        }
        this.mInterpolator = timeInterpolator;
    }

    @Override // androidx.transition.Transition
    public final void setPathMotion(Path.Companion companion) {
        super.setPathMotion(companion);
        this.mChangeFlags |= 4;
        if (this.mTransitions != null) {
            for (int i = 0; i < this.mTransitions.size(); i++) {
                ((Transition) this.mTransitions.get(i)).setPathMotion(companion);
            }
        }
    }

    @Override // androidx.transition.Transition
    public final void setPropagation() {
        this.mChangeFlags |= 2;
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.mTransitions.get(i)).setPropagation();
        }
    }

    @Override // androidx.transition.Transition
    public final void setStartDelay(long j) {
        this.mStartDelay = j;
    }

    @Override // androidx.transition.Transition
    public final String toString(String str) {
        String string = super.toString(str);
        for (int i = 0; i < this.mTransitions.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            sb.append("\n");
            sb.append(((Transition) this.mTransitions.get(i)).toString(str + "  "));
            string = sb.toString();
        }
        return string;
    }

    @Override // androidx.transition.Transition
    /* JADX INFO: renamed from: clone */
    public final Transition mo776clone() {
        AutoTransition autoTransition = (AutoTransition) super.mo776clone();
        autoTransition.mTransitions = new ArrayList();
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            Transition transitionMo776clone = ((Transition) this.mTransitions.get(i)).mo776clone();
            autoTransition.mTransitions.add(transitionMo776clone);
            transitionMo776clone.mParent = autoTransition;
        }
        return autoTransition;
    }
}
