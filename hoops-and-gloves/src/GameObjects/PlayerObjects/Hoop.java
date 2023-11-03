package GameObjects.PlayerObjects;

import Court.Court;

public class Hoop extends PlayerObject{

    public Hoop(Court court) {
        super(court, court.getCols()/2 - 5, court.getRows() - 8, 10, "resources/PlayerObjects/hoop.png");
    }


}
