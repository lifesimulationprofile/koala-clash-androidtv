package androidx.constraintlayout.solver;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import java.util.Arrays;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SolverVariableValues implements ArrayRow.ArrayRowVariables {
    public final Dispatcher mCache;
    public final LinearSystem.ValuesRow mRow;
    public int SIZE = 16;
    public final int[] keys = new int[16];
    public int[] nextKeys = new int[16];
    public int[] variables = new int[16];
    public float[] values = new float[16];
    public int[] previous = new int[16];
    public int[] next = new int[16];
    public int mCount = 0;
    public int head = -1;

    public SolverVariableValues(LinearSystem.ValuesRow valuesRow, Dispatcher dispatcher) {
        this.mRow = valuesRow;
        this.mCache = dispatcher;
        clear();
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final void add(SolverVariable solverVariable, float f, boolean z) {
        if (f <= -0.001f || f >= 0.001f) {
            int iIndexOf = indexOf(solverVariable);
            if (iIndexOf == -1) {
                put(solverVariable, f);
                return;
            }
            float[] fArr = this.values;
            float f2 = fArr[iIndexOf] + f;
            fArr[iIndexOf] = f2;
            if (f2 <= -0.001f || f2 >= 0.001f) {
                return;
            }
            fArr[iIndexOf] = 0.0f;
            remove(solverVariable, z);
        }
    }

    public final void addToHashMap(SolverVariable solverVariable, int i) {
        int[] iArr;
        int i2 = solverVariable.id % 16;
        int[] iArr2 = this.keys;
        int i3 = iArr2[i2];
        if (i3 == -1) {
            iArr2[i2] = i;
        } else {
            while (true) {
                iArr = this.nextKeys;
                int i4 = iArr[i3];
                if (i4 == -1) {
                    break;
                } else {
                    i3 = i4;
                }
            }
            iArr[i3] = i;
        }
        this.nextKeys[i] = -1;
    }

    public final void addVariable(int i, SolverVariable solverVariable, float f) {
        this.variables[i] = solverVariable.id;
        this.values[i] = f;
        this.previous[i] = -1;
        this.next[i] = -1;
        solverVariable.addToRow(this.mRow);
        solverVariable.usageInRowCount++;
        this.mCount++;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final void clear() {
        int i = this.mCount;
        for (int i2 = 0; i2 < i; i2++) {
            SolverVariable variable = getVariable(i2);
            if (variable != null) {
                variable.removeFromRow(this.mRow);
            }
        }
        for (int i3 = 0; i3 < this.SIZE; i3++) {
            this.variables[i3] = -1;
            this.nextKeys[i3] = -1;
        }
        for (int i4 = 0; i4 < 16; i4++) {
            this.keys[i4] = -1;
        }
        this.mCount = 0;
        this.head = -1;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final boolean contains(SolverVariable solverVariable) {
        return indexOf(solverVariable) != -1;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final void divideByAmount(float f) {
        int i = this.mCount;
        int i2 = this.head;
        for (int i3 = 0; i3 < i; i3++) {
            float[] fArr = this.values;
            fArr[i2] = fArr[i2] / f;
            i2 = this.next[i2];
            if (i2 == -1) {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final float get(SolverVariable solverVariable) {
        int iIndexOf = indexOf(solverVariable);
        if (iIndexOf != -1) {
            return this.values[iIndexOf];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final int getCurrentSize() {
        return this.mCount;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final SolverVariable getVariable(int i) {
        int i2 = this.mCount;
        if (i2 == 0) {
            return null;
        }
        int i3 = this.head;
        for (int i4 = 0; i4 < i2; i4++) {
            if (i4 == i && i3 != -1) {
                return ((SolverVariable[]) this.mCache.runningSyncCalls)[this.variables[i3]];
            }
            i3 = this.next[i3];
            if (i3 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final float getVariableValue(int i) {
        int i2 = this.mCount;
        int i3 = this.head;
        for (int i4 = 0; i4 < i2; i4++) {
            if (i4 == i) {
                return this.values[i3];
            }
            i3 = this.next[i3];
            if (i3 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    public final int indexOf(SolverVariable solverVariable) {
        if (this.mCount == 0) {
            return -1;
        }
        int i = solverVariable.id;
        int i2 = this.keys[i % 16];
        if (i2 == -1) {
            return -1;
        }
        if (this.variables[i2] == i) {
            return i2;
        }
        do {
            i2 = this.nextKeys[i2];
            if (i2 == -1) {
                break;
            }
        } while (this.variables[i2] != i);
        if (i2 != -1 && this.variables[i2] == i) {
            return i2;
        }
        return -1;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final void invert() {
        int i = this.mCount;
        int i2 = this.head;
        for (int i3 = 0; i3 < i; i3++) {
            float[] fArr = this.values;
            fArr[i2] = fArr[i2] * (-1.0f);
            i2 = this.next[i2];
            if (i2 == -1) {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final void put(SolverVariable solverVariable, float f) {
        if (f > -0.001f && f < 0.001f) {
            remove(solverVariable, true);
            return;
        }
        int i = 0;
        if (this.mCount == 0) {
            addVariable(0, solverVariable, f);
            addToHashMap(solverVariable, 0);
            this.head = 0;
            return;
        }
        int iIndexOf = indexOf(solverVariable);
        if (iIndexOf != -1) {
            this.values[iIndexOf] = f;
            return;
        }
        int i2 = this.mCount + 1;
        int i3 = this.SIZE;
        if (i2 >= i3) {
            int i4 = i3 * 2;
            this.variables = Arrays.copyOf(this.variables, i4);
            this.values = Arrays.copyOf(this.values, i4);
            this.previous = Arrays.copyOf(this.previous, i4);
            this.next = Arrays.copyOf(this.next, i4);
            this.nextKeys = Arrays.copyOf(this.nextKeys, i4);
            for (int i5 = this.SIZE; i5 < i4; i5++) {
                this.variables[i5] = -1;
                this.nextKeys[i5] = -1;
            }
            this.SIZE = i4;
        }
        int i6 = this.mCount;
        int i7 = this.head;
        int i8 = -1;
        for (int i9 = 0; i9 < i6; i9++) {
            int i10 = this.variables[i7];
            int i11 = solverVariable.id;
            if (i10 == i11) {
                this.values[i7] = f;
                return;
            }
            if (i10 < i11) {
                i8 = i7;
            }
            i7 = this.next[i7];
            if (i7 == -1) {
                break;
            }
        }
        while (true) {
            if (i >= this.SIZE) {
                i = -1;
                break;
            } else if (this.variables[i] == -1) {
                break;
            } else {
                i++;
            }
        }
        addVariable(i, solverVariable, f);
        if (i8 != -1) {
            this.previous[i] = i8;
            int[] iArr = this.next;
            iArr[i] = iArr[i8];
            iArr[i8] = i;
        } else {
            this.previous[i] = -1;
            if (this.mCount > 0) {
                this.next[i] = this.head;
                this.head = i;
            } else {
                this.next[i] = -1;
            }
        }
        int i12 = this.next[i];
        if (i12 != -1) {
            this.previous[i12] = i;
        }
        addToHashMap(solverVariable, i);
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final float remove(SolverVariable solverVariable, boolean z) {
        int[] iArr;
        int i;
        int iIndexOf = indexOf(solverVariable);
        if (iIndexOf == -1) {
            return 0.0f;
        }
        int i2 = solverVariable.id;
        int i3 = i2 % 16;
        int[] iArr2 = this.keys;
        int i4 = iArr2[i3];
        if (i4 != -1) {
            if (this.variables[i4] == i2) {
                int[] iArr3 = this.nextKeys;
                iArr2[i3] = iArr3[i4];
                iArr3[i4] = -1;
            } else {
                while (true) {
                    iArr = this.nextKeys;
                    i = iArr[i4];
                    if (i == -1 || this.variables[i] == i2) {
                        break;
                    }
                    i4 = i;
                }
                if (i != -1 && this.variables[i] == i2) {
                    iArr[i4] = iArr[i];
                    iArr[i] = -1;
                }
            }
        }
        float f = this.values[iIndexOf];
        if (this.head == iIndexOf) {
            this.head = this.next[iIndexOf];
        }
        this.variables[iIndexOf] = -1;
        int[] iArr4 = this.previous;
        int i5 = iArr4[iIndexOf];
        if (i5 != -1) {
            int[] iArr5 = this.next;
            iArr5[i5] = iArr5[iIndexOf];
        }
        int i6 = this.next[iIndexOf];
        if (i6 != -1) {
            iArr4[i6] = iArr4[iIndexOf];
        }
        this.mCount--;
        solverVariable.usageInRowCount--;
        if (z) {
            solverVariable.removeFromRow(this.mRow);
        }
        return f;
    }

    public final String toString() {
        String strM = hashCode() + " { ";
        int i = this.mCount;
        for (int i2 = 0; i2 < i; i2++) {
            SolverVariable variable = getVariable(i2);
            if (variable != null) {
                String str = strM + variable + " = " + getVariableValue(i2) + " ";
                int iIndexOf = indexOf(variable);
                String strM2 = ImageAnalysis$$ExternalSyntheticLambda1.m(str, "[p: ");
                int i3 = this.previous[iIndexOf];
                Dispatcher dispatcher = this.mCache;
                String strM3 = ImageAnalysis$$ExternalSyntheticLambda1.m(i3 != -1 ? strM2 + ((SolverVariable[]) dispatcher.runningSyncCalls)[this.variables[this.previous[iIndexOf]]] : ImageAnalysis$$ExternalSyntheticLambda1.m(strM2, "none"), ", n: ");
                strM = ImageAnalysis$$ExternalSyntheticLambda1.m(this.next[iIndexOf] != -1 ? strM3 + ((SolverVariable[]) dispatcher.runningSyncCalls)[this.variables[this.next[iIndexOf]]] : ImageAnalysis$$ExternalSyntheticLambda1.m(strM3, "none"), "]");
            }
        }
        return ImageAnalysis$$ExternalSyntheticLambda1.m(strM, " }");
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final float use(ArrayRow arrayRow, boolean z) {
        float f = get(arrayRow.variable);
        remove(arrayRow.variable, z);
        SolverVariableValues solverVariableValues = (SolverVariableValues) arrayRow.variables;
        int i = solverVariableValues.mCount;
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            int i4 = solverVariableValues.variables[i3];
            if (i4 != -1) {
                add(((SolverVariable[]) this.mCache.runningSyncCalls)[i4], solverVariableValues.values[i3] * f, z);
                i2++;
            }
            i3++;
        }
        return f;
    }
}
