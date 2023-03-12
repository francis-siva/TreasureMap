package com.java_lab_corp.components;

import com.java_lab_corp.MapMD;
import com.java_lab_corp.Square;
import com.java_lab_corp.exceptions.InvalidComponentBuild;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
@ToString
public class Mountain {
    @Getter
    Square square;

    @Getter
    MapMD mapMD;

    public Mountain(Square square, MapMD mapMD) throws InvalidComponentBuild {
        if(mapMD.getTotalSquares() > 0) {
            this.mapMD = mapMD;

            // Search parameter square between mapMD's Squares (from HashMap<Integer, Square> map property)
            Optional<Square> squareToReach = this.mapMD.searchSquare(square);

            log.debug("squareToReach.isPresent(): {}", squareToReach.isPresent());

            // Check the presence of parameter (square) in Optional squareToReach before setting to Mountain
            if (squareToReach.isPresent()) {
                this.square = squareToReach.get();
                log.debug("Square found. Mountain is attached to {}", this.square);

                // Once component is created attach to its square
                this.square.addComponent(this);
            }
            else {
                log.error("Error no such kind of Square found on map for: {}", square);
                throw new InvalidComponentBuild("Unable to create Mountain => constructor's Square parameter is not reachable on map");
            }
        }
        else {
            log.error("Error: map need a proper structure to add Components. MapMD's construction requires some changes (verify widthSquares & heightSquares)");
            throw new InvalidComponentBuild("Unable to create Mountain => constructor's MapMD parameter is invalid");
        }

    }
}
