package eu.piiroinen.recipes.model;

import jakarta.persistence.*;

@Entity
@Table(name="ohje")
public class Instruction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_ohje")
    private Long instructionId;
    @Column(name="järjestysluku", nullable = false)
    int ordinal;
    @Column(name="ohjeet", length = 1000, nullable = false)
    String instructionBody;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_resepti")
    private Recipe recipe;

    public Instruction() {}

    public Instruction(int ordinal, String instructionBody) {
        this.ordinal = ordinal;
        this.instructionBody = instructionBody;
    }

    public Long getInstructionId() {
        return instructionId;
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