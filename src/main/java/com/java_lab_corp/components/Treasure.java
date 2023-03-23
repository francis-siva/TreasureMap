package com.java_lab_corp.components;

import com.java_lab_corp.MapMD;
import com.java_lab_corp.Square;
import com.java_lab_corp.exceptions.InvalidComponentBuild;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString(callSuper = true)// required option to get whole properties in this child class toString() call
public class Treasure extends SquareComponent {

//    @Getter @Setter
//    int nbTreasure;

    public Treasure(Square square, MapMD mapMD) throws InvalidComponentBuild {
        super(square, mapMD);

    }

    public void setSquare(Square square) {
        this.square = square;
    }
}
