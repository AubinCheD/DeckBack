///https://www.baeldung.com/spring-data-rest-relationships

package backDeck;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "DECK")
//@EntityListeners(AuditingEntityListener.class)
public class Deck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int idSession;

    @OneToMany(mappedBy = "deck")
    private List<Card> cards;

    public List<Card> getCards() { return cards; }

    public int getIdSession() {
        return idSession;
    }

    public void setIdSession(int idSession) {  //on doit le recup avant la creation du deck par back histo
        this.idSession = idSession;
    }

    public Deck(int idSession){
        this.idSession = idSession;
        cards = new ArrayList<>(52);
        for(int i = 0; i<14; i++){
            cards.add(new Card("carreau", i, this));
            cards.add(new Card("coeur", i, this));
            cards.add(new Card("pique", i, this));
            cards.add(new Card("trefle", i, this));
        }
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

}
