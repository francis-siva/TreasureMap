package com.java_lab_corp;

import com.java_lab_corp.components.Mountain;
import com.java_lab_corp.components.Treasure;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

@Slf4j
@NoArgsConstructor
public class Square extends CoordinatesPoint {
	@Getter @Setter
	private int squareNumber;

	@Getter
	private ArrayList<Object> listComponents;

	public Square(int squareNumber, int horizontalAxis, int verticalAxis) {
		super();
		this.horizontalAxis = horizontalAxis;
		this.verticalAxis = verticalAxis;
		this.squareNumber = squareNumber;
	}

	public void addComponent(Object obj) {
		log.debug("param obj received: {}", obj);

		if(this.listComponents == null) {
			this.listComponents = new ArrayList<>();
			log.debug("ArrayList instance created to supply listComponents");
		}

		//If listComponents 1st element is a Mountain, so we don't build Component anymore
		if(this.listComponents.size() > 0 && this.listComponents.get(0) instanceof Mountain) {
			log.error("A Mountain is here !!! Unable to place another Component at this Square {}", this);
			//todo: impl & throw custom exception
		}
		else {
			log.debug("New Object to add in listComponents: {}", obj.getClass().getSimpleName());

			if(obj instanceof Mountain) {
				Mountain mountain = (Mountain) obj;

				this.listComponents.add(mountain);
				log.debug("Mountain {} is registered to Square in: {}", mountain, this);
			}

			if(obj instanceof Treasure) {
				Treasure treasure = (Treasure) obj;

				this.listComponents.add(treasure);
				log.debug("Treasure {} is registered to Square in: {}", treasure, this);
			}
//		if(obj instanceof Adventurer)
		}
	}

	public void setHorizontalAxis(int horizontalAxis) {
		this.horizontalAxis = horizontalAxis;
	}

	public void setVerticalAxis(int verticalAxis) {
		this.verticalAxis = verticalAxis;
	}

	@Override
	public String toString() {
		return "Square [squareNumber=" + squareNumber + ", horizontalAxis=" + horizontalAxis + ", verticalAxis="
				+ verticalAxis + "]";
	}
}
