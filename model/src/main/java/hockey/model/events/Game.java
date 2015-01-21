package hockey.model.events;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("GAME")
public class Game extends Event {

}
