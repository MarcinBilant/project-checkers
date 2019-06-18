package com.kodilla;

public enum PawnType {
    BLASCK(1), WHITE(-1);

    final int moveDIR;
    PawnType(int moveDIR) {
        this.moveDIR = moveDIR;

    }

}
