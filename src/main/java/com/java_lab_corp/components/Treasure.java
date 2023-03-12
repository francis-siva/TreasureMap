package com.java_lab_corp.components;

import com.java_lab_corp.Square;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString
public class Treasure {
    @Getter @Setter
    Square square;

//    @Getter @Setter
//    int nbTreasure;
}
