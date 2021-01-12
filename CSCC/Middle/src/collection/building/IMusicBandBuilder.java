package collection.building;

import collection.MusicBand;

public interface IMusicBandBuilder {

    void setName();

    void setCoordinates();

    void setNumberOfParticipants();

    void setGenre();

    void setLabel();

    MusicBand create();
}
