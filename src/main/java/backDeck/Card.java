package backDeck;

import javax.persistence.*;

@Entity
@Table(name="CARD")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String color; //carreau, coeur, pique, trefle

    @Column
    private int value; //de 1 (la plus petite) à 13 (le roi)

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DECK_ID")
    private Deck deck;

    public Card() {
    }
    public Card(String c, int v, Deck d) {
        this.color = c;
        this.value = v;
        this.deck = d;
    }

    public String getColor() {return color;}
    public int getValue() {return value;}

    public void setColor(String c) {color=c;}
    public void setValue (int v) {value=v;}

    public void setId(Long id) {
        this.id=id;
    }
}
