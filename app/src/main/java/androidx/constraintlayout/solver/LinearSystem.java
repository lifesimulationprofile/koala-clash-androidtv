package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.PriorityGoalRow.GoalVariableAccessor;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.core.util.Pools$SimplePool;
import java.util.ArrayList;
import java.util.Arrays;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LinearSystem {
    public static boolean OPTIMIZED_ENGINE = true;
    public static int POOL_SIZE = 1000;
    public final Dispatcher mCache;
    public final PriorityGoalRow mGoal;
    public ArrayRow[] mRows;
    public ArrayRow mTempGoal;
    public int mVariablesID = 0;
    public int TABLE_SIZE = 32;
    public int mMaxColumns = 32;
    public boolean newgraphOptimizer = false;
    public boolean[] mAlreadyTestedCandidates = new boolean[32];
    public int mNumColumns = 1;
    public int mNumRows = 0;
    public int mMaxRows = 32;
    public SolverVariable[] mPoolVariables = new SolverVariable[POOL_SIZE];
    public int mPoolVariablesCount = 0;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class ValuesRow extends ArrayRow {
        public ValuesRow(Dispatcher dispatcher) {
            this.variable = null;
            this.constantValue = 0.0f;
            this.variablesToUpdate = new ArrayList();
            this.isSimpleDefinition = false;
            this.variables = new SolverVariableValues(this, dispatcher);
        }
    }

    public LinearSystem() {
        this.mRows = null;
        this.mRows = new ArrayRow[32];
        releaseRows();
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.executorServiceOrNull = new Pools$SimplePool();
        dispatcher.readyAsyncCalls = new Pools$SimplePool();
        dispatcher.runningAsyncCalls = new Pools$SimplePool();
        dispatcher.runningSyncCalls = new SolverVariable[32];
        this.mCache = dispatcher;
        PriorityGoalRow priorityGoalRow = new PriorityGoalRow(dispatcher);
        priorityGoalRow.arrayGoals = new SolverVariable[128];
        priorityGoalRow.sortArray = new SolverVariable[128];
        priorityGoalRow.numGoals = 0;
        priorityGoalRow.accessor = priorityGoalRow.new GoalVariableAccessor();
        this.mGoal = priorityGoalRow;
        if (OPTIMIZED_ENGINE) {
            this.mTempGoal = new ValuesRow(dispatcher);
        } else {
            this.mTempGoal = new ArrayRow(dispatcher);
        }
    }

    public static int getObjectVariableValue(Object obj) {
        SolverVariable solverVariable = ((ConstraintAnchor) obj).mSolverVariable;
        if (solverVariable != null) {
            return (int) (solverVariable.computedValue + 0.5f);
        }
        return 0;
    }

    public final SolverVariable acquireSolverVariable(int i) {
        SolverVariable solverVariable = (SolverVariable) ((Pools$SimplePool) this.mCache.runningAsyncCalls).acquire();
        if (solverVariable == null) {
            solverVariable = new SolverVariable(i);
            solverVariable.mType = i;
        } else {
            solverVariable.reset();
            solverVariable.mType = i;
        }
        int i2 = this.mPoolVariablesCount;
        int i3 = POOL_SIZE;
        if (i2 >= i3) {
            int i4 = i3 * 2;
            POOL_SIZE = i4;
            this.mPoolVariables = (SolverVariable[]) Arrays.copyOf(this.mPoolVariables, i4);
        }
        SolverVariable[] solverVariableArr = this.mPoolVariables;
        int i5 = this.mPoolVariablesCount;
        this.mPoolVariablesCount = i5 + 1;
        solverVariableArr[i5] = solverVariable;
        return solverVariable;
    }

    public final void addCentering(SolverVariable solverVariable, SolverVariable solverVariable2, int i, float f, SolverVariable solverVariable3, SolverVariable solverVariable4, int i2, int i3) {
        ArrayRow arrayRowCreateRow = createRow();
        if (solverVariable2 == solverVariable3) {
            arrayRowCreateRow.variables.put(solverVariable, 1.0f);
            arrayRowCreateRow.variables.put(solverVariable4, 1.0f);
            arrayRowCreateRow.variables.put(solverVariable2, -2.0f);
        } else if (f == 0.5f) {
            arrayRowCreateRow.variables.put(solverVariable, 1.0f);
            arrayRowCreateRow.variables.put(solverVariable2, -1.0f);
            arrayRowCreateRow.variables.put(solverVariable3, -1.0f);
            arrayRowCreateRow.variables.put(solverVariable4, 1.0f);
            if (i > 0 || i2 > 0) {
                arrayRowCreateRow.constantValue = (-i) + i2;
            }
        } else if (f <= 0.0f) {
            arrayRowCreateRow.variables.put(solverVariable, -1.0f);
            arrayRowCreateRow.variables.put(solverVariable2, 1.0f);
            arrayRowCreateRow.constantValue = i;
        } else if (f >= 1.0f) {
            arrayRowCreateRow.variables.put(solverVariable4, -1.0f);
            arrayRowCreateRow.variables.put(solverVariable3, 1.0f);
            arrayRowCreateRow.constantValue = -i2;
        } else {
            float f2 = 1.0f - f;
            arrayRowCreateRow.variables.put(solverVariable, f2 * 1.0f);
            arrayRowCreateRow.variables.put(solverVariable2, f2 * (-1.0f));
            arrayRowCreateRow.variables.put(solverVariable3, (-1.0f) * f);
            arrayRowCreateRow.variables.put(solverVariable4, 1.0f * f);
            if (i > 0 || i2 > 0) {
                arrayRowCreateRow.constantValue = (i2 * f) + ((-i) * f2);
            }
        }
        if (i3 != 8) {
            arrayRowCreateRow.addError(this, i3);
        }
        addConstraint(arrayRowCreateRow);
    }

    /* JADX WARN: Code duplicated, block: B:50:0x00be  */
    /* JADX WARN: Code duplicated, block: B:68:0x00e0  */
    public final void addConstraint(ArrayRow arrayRow) {
        boolean z;
        boolean z2;
        SolverVariable solverVariablePickPivotInVariables;
        if (this.mNumRows + 1 >= this.mMaxRows || this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        if (arrayRow.isSimpleDefinition) {
            z = false;
        } else {
            ArrayList arrayList = arrayRow.variablesToUpdate;
            if (this.mRows.length != 0) {
                boolean z3 = false;
                while (!z3) {
                    int currentSize = arrayRow.variables.getCurrentSize();
                    for (int i = 0; i < currentSize; i++) {
                        SolverVariable variable = arrayRow.variables.getVariable(i);
                        if (variable.definitionId != -1 || variable.isFinalValue) {
                            arrayList.add(variable);
                        }
                    }
                    if (arrayList.size() > 0) {
                        int size = arrayList.size();
                        int i2 = 0;
                        while (i2 < size) {
                            Object obj = arrayList.get(i2);
                            i2++;
                            SolverVariable solverVariable = (SolverVariable) obj;
                            if (solverVariable.isFinalValue) {
                                arrayRow.updateFromFinalVariable(solverVariable, true);
                            } else {
                                arrayRow.updateFromRow(this.mRows[solverVariable.definitionId], true);
                            }
                        }
                        arrayList.clear();
                    } else {
                        z3 = true;
                    }
                }
            }
            float f = 0.0f;
            if (arrayRow.variable == null && arrayRow.constantValue == 0.0f && arrayRow.variables.getCurrentSize() == 0) {
                return;
            }
            float f2 = arrayRow.constantValue;
            if (f2 < 0.0f) {
                arrayRow.constantValue = f2 * (-1.0f);
                arrayRow.variables.invert();
            }
            int currentSize2 = arrayRow.variables.getCurrentSize();
            float f3 = 0.0f;
            float f4 = 0.0f;
            SolverVariable solverVariable2 = null;
            SolverVariable solverVariable3 = null;
            int i3 = 0;
            boolean z4 = false;
            boolean z5 = false;
            while (i3 < currentSize2) {
                float variableValue = arrayRow.variables.getVariableValue(i3);
                SolverVariable variable2 = arrayRow.variables.getVariable(i3);
                float f5 = f;
                if (variable2.mType == 1) {
                    if (solverVariable2 == null) {
                        if (variable2.usageInRowCount <= 1) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        solverVariable2 = variable2;
                        f3 = variableValue;
                    } else {
                        if (f3 > variableValue) {
                            if (variable2.usageInRowCount > 1) {
                                z4 = false;
                            }
                            solverVariable2 = variable2;
                            f3 = variableValue;
                        } else if (z4 || variable2.usageInRowCount > 1) {
                        }
                        z4 = true;
                        solverVariable2 = variable2;
                        f3 = variableValue;
                    }
                } else if (solverVariable2 == null && variableValue < f5) {
                    if (solverVariable3 == null) {
                        if (variable2.usageInRowCount <= 1) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        solverVariable3 = variable2;
                        f4 = variableValue;
                    } else {
                        if (f4 > variableValue) {
                            if (variable2.usageInRowCount > 1) {
                                z5 = false;
                            }
                            solverVariable3 = variable2;
                            f4 = variableValue;
                        } else if (z5 || variable2.usageInRowCount > 1) {
                        }
                        z5 = true;
                        solverVariable3 = variable2;
                        f4 = variableValue;
                    }
                }
                i3++;
                f = f5;
            }
            float f6 = f;
            if (solverVariable2 == null) {
                solverVariable2 = solverVariable3;
            }
            if (solverVariable2 == null) {
                z2 = true;
            } else {
                arrayRow.pivot(solverVariable2);
                z2 = false;
            }
            if (arrayRow.variables.getCurrentSize() == 0) {
                arrayRow.isSimpleDefinition = true;
            }
            if (z2) {
                if (this.mNumColumns + 1 >= this.mMaxColumns) {
                    increaseTableSize();
                }
                SolverVariable solverVariableAcquireSolverVariable = acquireSolverVariable(3);
                int i4 = this.mVariablesID + 1;
                this.mVariablesID = i4;
                this.mNumColumns++;
                solverVariableAcquireSolverVariable.id = i4;
                ((SolverVariable[]) this.mCache.runningSyncCalls)[i4] = solverVariableAcquireSolverVariable;
                arrayRow.variable = solverVariableAcquireSolverVariable;
                addRow(arrayRow);
                ArrayRow arrayRow2 = this.mTempGoal;
                arrayRow2.variable = null;
                arrayRow2.variables.clear();
                for (int i5 = 0; i5 < arrayRow.variables.getCurrentSize(); i5++) {
                    arrayRow2.variables.add(arrayRow.variables.getVariable(i5), arrayRow.variables.getVariableValue(i5), true);
                }
                optimize(this.mTempGoal);
                if (solverVariableAcquireSolverVariable.definitionId == -1) {
                    if (arrayRow.variable == solverVariableAcquireSolverVariable && (solverVariablePickPivotInVariables = arrayRow.pickPivotInVariables(null, solverVariableAcquireSolverVariable)) != null) {
                        arrayRow.pivot(solverVariablePickPivotInVariables);
                    }
                    if (!arrayRow.isSimpleDefinition) {
                        arrayRow.variable.updateReferencesWithNewDefinition(arrayRow);
                    }
                    this.mNumRows--;
                }
                z = true;
            } else {
                z = false;
            }
            SolverVariable solverVariable4 = arrayRow.variable;
            if (solverVariable4 == null) {
                return;
            }
            if (solverVariable4.mType != 1 && arrayRow.constantValue < f6) {
                return;
            }
        }
        if (z) {
            return;
        }
        addRow(arrayRow);
    }

    public final void addEquality(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        boolean z = false;
        if (i2 == 8 && solverVariable2.isFinalValue && solverVariable.definitionId == -1) {
            solverVariable.computedValue = solverVariable2.computedValue + i;
            solverVariable.isFinalValue = true;
            int i3 = solverVariable.mClientEquationsCount;
            for (int i4 = 0; i4 < i3; i4++) {
                solverVariable.mClientEquations[i4].updateFromFinalVariable(solverVariable, false);
            }
            solverVariable.mClientEquationsCount = 0;
            return;
        }
        ArrayRow arrayRowCreateRow = createRow();
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            arrayRowCreateRow.constantValue = i;
        }
        if (z) {
            arrayRowCreateRow.variables.put(solverVariable, 1.0f);
            arrayRowCreateRow.variables.put(solverVariable2, -1.0f);
        } else {
            arrayRowCreateRow.variables.put(solverVariable, -1.0f);
            arrayRowCreateRow.variables.put(solverVariable2, 1.0f);
        }
        if (i2 != 8) {
            arrayRowCreateRow.addError(this, i2);
        }
        addConstraint(arrayRowCreateRow);
    }

    public final void addGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        ArrayRow arrayRowCreateRow = createRow();
        SolverVariable solverVariableCreateSlackVariable = createSlackVariable();
        solverVariableCreateSlackVariable.strength = 0;
        arrayRowCreateRow.createRowGreaterThan(solverVariable, solverVariable2, solverVariableCreateSlackVariable, i);
        if (i2 != 8) {
            arrayRowCreateRow.variables.put(createErrorVariable(i2), (int) (arrayRowCreateRow.variables.get(solverVariableCreateSlackVariable) * (-1.0f)));
        }
        addConstraint(arrayRowCreateRow);
    }

    public final void addLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        ArrayRow arrayRowCreateRow = createRow();
        SolverVariable solverVariableCreateSlackVariable = createSlackVariable();
        solverVariableCreateSlackVariable.strength = 0;
        arrayRowCreateRow.createRowLowerThan(solverVariable, solverVariable2, solverVariableCreateSlackVariable, i);
        if (i2 != 8) {
            arrayRowCreateRow.variables.put(createErrorVariable(i2), (int) (arrayRowCreateRow.variables.get(solverVariableCreateSlackVariable) * (-1.0f)));
        }
        addConstraint(arrayRowCreateRow);
    }

    public final void addRow(ArrayRow arrayRow) {
        boolean z = OPTIMIZED_ENGINE;
        Dispatcher dispatcher = this.mCache;
        if (z) {
            ArrayRow arrayRow2 = this.mRows[this.mNumRows];
            if (arrayRow2 != null) {
                ((Pools$SimplePool) dispatcher.executorServiceOrNull).release(arrayRow2);
            }
        } else {
            ArrayRow arrayRow3 = this.mRows[this.mNumRows];
            if (arrayRow3 != null) {
                ((Pools$SimplePool) dispatcher.readyAsyncCalls).release(arrayRow3);
            }
        }
        ArrayRow[] arrayRowArr = this.mRows;
        int i = this.mNumRows;
        arrayRowArr[i] = arrayRow;
        SolverVariable solverVariable = arrayRow.variable;
        solverVariable.definitionId = i;
        this.mNumRows = i + 1;
        solverVariable.updateReferencesWithNewDefinition(arrayRow);
    }

    public final SolverVariable createErrorVariable(int i) {
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable solverVariableAcquireSolverVariable = acquireSolverVariable(4);
        float[] fArr = solverVariableAcquireSolverVariable.goalStrengthVector;
        int i2 = this.mVariablesID + 1;
        this.mVariablesID = i2;
        this.mNumColumns++;
        solverVariableAcquireSolverVariable.id = i2;
        solverVariableAcquireSolverVariable.strength = i;
        ((SolverVariable[]) this.mCache.runningSyncCalls)[i2] = solverVariableAcquireSolverVariable;
        PriorityGoalRow priorityGoalRow = this.mGoal;
        priorityGoalRow.accessor.variable = solverVariableAcquireSolverVariable;
        Arrays.fill(fArr, 0.0f);
        fArr[solverVariableAcquireSolverVariable.strength] = 1.0f;
        priorityGoalRow.addToGoal(solverVariableAcquireSolverVariable);
        return solverVariableAcquireSolverVariable;
    }

    public final SolverVariable createObjectVariable(Object obj) {
        if (obj == null) {
            return null;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        if (!(obj instanceof ConstraintAnchor)) {
            return null;
        }
        ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
        SolverVariable solverVariable = constraintAnchor.mSolverVariable;
        if (solverVariable == null) {
            constraintAnchor.resetSolverVariable();
            solverVariable = constraintAnchor.mSolverVariable;
        }
        int i = solverVariable.id;
        Dispatcher dispatcher = this.mCache;
        if (i != -1 && i <= this.mVariablesID && ((SolverVariable[]) dispatcher.runningSyncCalls)[i] != null) {
            return solverVariable;
        }
        if (i != -1) {
            solverVariable.reset();
        }
        int i2 = this.mVariablesID + 1;
        this.mVariablesID = i2;
        this.mNumColumns++;
        solverVariable.id = i2;
        solverVariable.mType = 1;
        ((SolverVariable[]) dispatcher.runningSyncCalls)[i2] = solverVariable;
        return solverVariable;
    }

    public final ArrayRow createRow() {
        boolean z = OPTIMIZED_ENGINE;
        Dispatcher dispatcher = this.mCache;
        if (z) {
            ArrayRow arrayRow = (ArrayRow) ((Pools$SimplePool) dispatcher.executorServiceOrNull).acquire();
            if (arrayRow == null) {
                return new ValuesRow(dispatcher);
            }
            arrayRow.variable = null;
            arrayRow.variables.clear();
            arrayRow.constantValue = 0.0f;
            arrayRow.isSimpleDefinition = false;
            return arrayRow;
        }
        ArrayRow arrayRow2 = (ArrayRow) ((Pools$SimplePool) dispatcher.readyAsyncCalls).acquire();
        if (arrayRow2 == null) {
            return new ArrayRow(dispatcher);
        }
        arrayRow2.variable = null;
        arrayRow2.variables.clear();
        arrayRow2.constantValue = 0.0f;
        arrayRow2.isSimpleDefinition = false;
        return arrayRow2;
    }

    public final SolverVariable createSlackVariable() {
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable solverVariableAcquireSolverVariable = acquireSolverVariable(3);
        int i = this.mVariablesID + 1;
        this.mVariablesID = i;
        this.mNumColumns++;
        solverVariableAcquireSolverVariable.id = i;
        ((SolverVariable[]) this.mCache.runningSyncCalls)[i] = solverVariableAcquireSolverVariable;
        return solverVariableAcquireSolverVariable;
    }

    public final void increaseTableSize() {
        int i = this.TABLE_SIZE * 2;
        this.TABLE_SIZE = i;
        this.mRows = (ArrayRow[]) Arrays.copyOf(this.mRows, i);
        Dispatcher dispatcher = this.mCache;
        dispatcher.runningSyncCalls = (SolverVariable[]) Arrays.copyOf((SolverVariable[]) dispatcher.runningSyncCalls, this.TABLE_SIZE);
        int i2 = this.TABLE_SIZE;
        this.mAlreadyTestedCandidates = new boolean[i2];
        this.mMaxColumns = i2;
        this.mMaxRows = i2;
    }

    public final void minimizeGoal(PriorityGoalRow priorityGoalRow) {
        Dispatcher dispatcher;
        for (int i = 0; i < this.mNumRows; i++) {
            ArrayRow arrayRow = this.mRows[i];
            int i2 = 1;
            if (arrayRow.variable.mType != 1) {
                float f = 0.0f;
                if (arrayRow.constantValue < 0.0f) {
                    boolean z = false;
                    int i3 = 0;
                    while (!z) {
                        i3 += i2;
                        float f2 = Float.MAX_VALUE;
                        int i4 = -1;
                        int i5 = -1;
                        int i6 = 0;
                        int i7 = 0;
                        while (true) {
                            int i8 = this.mNumRows;
                            dispatcher = this.mCache;
                            if (i6 >= i8) {
                                break;
                            }
                            ArrayRow arrayRow2 = this.mRows[i6];
                            if (arrayRow2.variable.mType != i2 && !arrayRow2.isSimpleDefinition && arrayRow2.constantValue < f) {
                                int i9 = i2;
                                while (i9 < this.mNumColumns) {
                                    SolverVariable solverVariable = ((SolverVariable[]) dispatcher.runningSyncCalls)[i9];
                                    float f3 = arrayRow2.variables.get(solverVariable);
                                    if (f3 > f) {
                                        for (int i10 = 0; i10 < 9; i10++) {
                                            float f4 = solverVariable.strengthVector[i10] / f3;
                                            if ((f4 < f2 && i10 == i7) || i10 > i7) {
                                                i7 = i10;
                                                f2 = f4;
                                                i4 = i6;
                                                i5 = i9;
                                            }
                                        }
                                    }
                                    i9++;
                                    f = 0.0f;
                                }
                            }
                            i6++;
                            f = 0.0f;
                            i2 = 1;
                        }
                        if (i4 != -1) {
                            ArrayRow arrayRow3 = this.mRows[i4];
                            arrayRow3.variable.definitionId = -1;
                            arrayRow3.pivot(((SolverVariable[]) dispatcher.runningSyncCalls)[i5]);
                            SolverVariable solverVariable2 = arrayRow3.variable;
                            solverVariable2.definitionId = i4;
                            solverVariable2.updateReferencesWithNewDefinition(arrayRow3);
                        } else {
                            z = true;
                        }
                        if (i3 > this.mNumColumns / 2) {
                            z = true;
                        }
                        f = 0.0f;
                        i2 = 1;
                    }
                    break;
                }
            }
        }
        optimize(priorityGoalRow);
        for (int i11 = 0; i11 < this.mNumRows; i11++) {
            ArrayRow arrayRow4 = this.mRows[i11];
            arrayRow4.variable.computedValue = arrayRow4.constantValue;
        }
    }

    public final void optimize(ArrayRow arrayRow) {
        for (int i = 0; i < this.mNumColumns; i++) {
            this.mAlreadyTestedCandidates[i] = false;
        }
        boolean z = false;
        int i2 = 0;
        while (!z) {
            i2++;
            if (i2 >= this.mNumColumns * 2) {
                return;
            }
            SolverVariable solverVariable = arrayRow.variable;
            if (solverVariable != null) {
                this.mAlreadyTestedCandidates[solverVariable.id] = true;
            }
            SolverVariable pivotCandidate = arrayRow.getPivotCandidate(this.mAlreadyTestedCandidates);
            if (pivotCandidate != null) {
                boolean[] zArr = this.mAlreadyTestedCandidates;
                int i3 = pivotCandidate.id;
                if (zArr[i3]) {
                    return;
                } else {
                    zArr[i3] = true;
                }
            }
            if (pivotCandidate != null) {
                float f = Float.MAX_VALUE;
                int i4 = -1;
                for (int i5 = 0; i5 < this.mNumRows; i5++) {
                    ArrayRow arrayRow2 = this.mRows[i5];
                    if (arrayRow2.variable.mType != 1 && !arrayRow2.isSimpleDefinition && arrayRow2.variables.contains(pivotCandidate)) {
                        float f2 = arrayRow2.variables.get(pivotCandidate);
                        if (f2 < 0.0f) {
                            float f3 = (-arrayRow2.constantValue) / f2;
                            if (f3 < f) {
                                i4 = i5;
                                f = f3;
                            }
                        }
                    }
                }
                if (i4 > -1) {
                    ArrayRow arrayRow3 = this.mRows[i4];
                    arrayRow3.variable.definitionId = -1;
                    arrayRow3.pivot(pivotCandidate);
                    SolverVariable solverVariable2 = arrayRow3.variable;
                    solverVariable2.definitionId = i4;
                    solverVariable2.updateReferencesWithNewDefinition(arrayRow3);
                }
            } else {
                z = true;
            }
        }
    }

    public final void releaseRows() {
        boolean z = OPTIMIZED_ENGINE;
        Dispatcher dispatcher = this.mCache;
        int i = 0;
        if (z) {
            while (true) {
                ArrayRow[] arrayRowArr = this.mRows;
                if (i >= arrayRowArr.length) {
                    return;
                }
                ArrayRow arrayRow = arrayRowArr[i];
                if (arrayRow != null) {
                    ((Pools$SimplePool) dispatcher.executorServiceOrNull).release(arrayRow);
                }
                this.mRows[i] = null;
                i++;
            }
        } else {
            while (true) {
                ArrayRow[] arrayRowArr2 = this.mRows;
                if (i >= arrayRowArr2.length) {
                    return;
                }
                ArrayRow arrayRow2 = arrayRowArr2[i];
                if (arrayRow2 != null) {
                    ((Pools$SimplePool) dispatcher.readyAsyncCalls).release(arrayRow2);
                }
                this.mRows[i] = null;
                i++;
            }
        }
    }

    public final void reset() {
        Dispatcher dispatcher;
        int i = 0;
        while (true) {
            dispatcher = this.mCache;
            SolverVariable[] solverVariableArr = (SolverVariable[]) dispatcher.runningSyncCalls;
            if (i >= solverVariableArr.length) {
                break;
            }
            SolverVariable solverVariable = solverVariableArr[i];
            if (solverVariable != null) {
                solverVariable.reset();
            }
            i++;
        }
        Pools$SimplePool pools$SimplePool = (Pools$SimplePool) dispatcher.runningAsyncCalls;
        SolverVariable[] solverVariableArr2 = this.mPoolVariables;
        int length = this.mPoolVariablesCount;
        pools$SimplePool.getClass();
        if (length > solverVariableArr2.length) {
            length = solverVariableArr2.length;
        }
        for (int i2 = 0; i2 < length; i2++) {
            SolverVariable solverVariable2 = solverVariableArr2[i2];
            int i3 = pools$SimplePool.poolSize;
            Object[] objArr = pools$SimplePool.pool;
            if (i3 < objArr.length) {
                objArr[i3] = solverVariable2;
                pools$SimplePool.poolSize = i3 + 1;
            }
        }
        this.mPoolVariablesCount = 0;
        Arrays.fill((SolverVariable[]) dispatcher.runningSyncCalls, (Object) null);
        this.mVariablesID = 0;
        PriorityGoalRow priorityGoalRow = this.mGoal;
        priorityGoalRow.numGoals = 0;
        priorityGoalRow.constantValue = 0.0f;
        this.mNumColumns = 1;
        for (int i4 = 0; i4 < this.mNumRows; i4++) {
            this.mRows[i4].getClass();
        }
        releaseRows();
        this.mNumRows = 0;
        if (OPTIMIZED_ENGINE) {
            this.mTempGoal = new ValuesRow(dispatcher);
        } else {
            this.mTempGoal = new ArrayRow(dispatcher);
        }
    }

    public final void addEquality(SolverVariable solverVariable, int i) {
        int i2 = solverVariable.definitionId;
        if (i2 == -1) {
            solverVariable.computedValue = i;
            solverVariable.isFinalValue = true;
            int i3 = solverVariable.mClientEquationsCount;
            for (int i4 = 0; i4 < i3; i4++) {
                solverVariable.mClientEquations[i4].updateFromFinalVariable(solverVariable, false);
            }
            solverVariable.mClientEquationsCount = 0;
            return;
        }
        if (i2 != -1) {
            ArrayRow arrayRow = this.mRows[i2];
            if (arrayRow.isSimpleDefinition) {
                arrayRow.constantValue = i;
                return;
            }
            if (arrayRow.variables.getCurrentSize() == 0) {
                arrayRow.isSimpleDefinition = true;
                arrayRow.constantValue = i;
                return;
            }
            ArrayRow arrayRowCreateRow = createRow();
            if (i < 0) {
                arrayRowCreateRow.constantValue = i * (-1);
                arrayRowCreateRow.variables.put(solverVariable, 1.0f);
            } else {
                arrayRowCreateRow.constantValue = i;
                arrayRowCreateRow.variables.put(solverVariable, -1.0f);
            }
            addConstraint(arrayRowCreateRow);
            return;
        }
        ArrayRow arrayRowCreateRow2 = createRow();
        arrayRowCreateRow2.variable = solverVariable;
        float f = i;
        solverVariable.computedValue = f;
        arrayRowCreateRow2.constantValue = f;
        arrayRowCreateRow2.isSimpleDefinition = true;
        addConstraint(arrayRowCreateRow2);
    }
}
