package GameObjects.PlayerObjects;

import Court.Court;

public class Glove extends PlayerObject{

    public Glove(Court court) {
        super(court, court.getCols()/2 - 3, court.getRows() - 30, 6, "resources/PlayerObjects/glove.png");
    }

}
