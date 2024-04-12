class Instruction {

    int ordinal;
    String instructionBody;

    public Instruction() {}

    public Instruction(int ordinal, String instructionBody) {
        this.ordinal = ordinal;
        this.instructionBody = instructionBody;
    }

    public int getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(int ordinal) {
        this.ordinal = ordinal;
    }

    public String getInstructionBody() {
        return instructionBody;
    }

    public void setInstructionBody(String instructionBody) {
        this.instructionBody = instructionBody;
    }
}