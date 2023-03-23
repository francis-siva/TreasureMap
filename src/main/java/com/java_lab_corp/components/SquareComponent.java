package com.java_lab_corp.components;

import com.java_lab_corp.MapMD;
import com.java_lab_corp.Square;
import com.java_lab_corp.exceptions.InvalidComponentBuild;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

/**
 * SquareComponent is designed to put component(s) into Square as Mountain, Treasure, Adventurer
 */
@Slf4j
@ToString
public abstract class SquareComponent {
    //todo: Mountain, Treasure, Adventurer seem to have common process into constructor
    @Getter
    protected Square square;

    @Getter
    protected MapMD mapMD;

    public SquareComponent(Square square, MapMD mapMD) throws InvalidComponentBuild {

        String componentClassType = this.getClass().getSimpleName();
        log.debug("component_CLASS_Type: " + componentClassType);

        if(mapMD.getTotalSquares() > 0) {
            this.mapMD = mapMD;

            /* Search parameter square between mapMD's Squares (from HashMap<Integer, Square> map property)
            by its horizontalAxis & verticalAxis properties. Property squareNumber
            of parameter square could be NOT Defined => squareNumber value may be equal to 0 */
            Optional<Square> squareToReach = this.mapMD.searchSquare(square);

            log.debug("squareToReach.isPresent(): {}", squareToReach.isPresent());

            // Check the presence of parameter (square) in Optional squareToReach before setting to Component (Mountain, Treasure, Adventurer)
            if (squareToReach.isPresent()) {
                this.square = squareToReach.get();
                log.debug("Square found. {} is ready to be attached to {}", componentClassType, this.square);

                // Once component is created attach to its square
                this.square.addComponent(this);
            }
            else {
                log.error("Error no such kind of Square found on map for: {}", square);
                throw new InvalidComponentBuild("Unable to create " + componentClassType + " => constructor's Square parameter is not reachable on map");
            }
        }
        else {
            log.error("Error: map need a proper structure to add Components. MapMD's construction requires some changes (verify widthSquares & heightSquares)");
            throw new InvalidComponentBuild("Unable to create " + componentClassType + " => constructor's MapMD parameter is invalid");
        }
    }

}
