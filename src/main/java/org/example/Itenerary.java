package org.example;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Builder
public class Itenerary {
    List<Destination> itenerary = new ArrayList<>();

    void print(){
        for (Destination destination: itenerary){
            System.out.println("\n");
            destination.print();
        }
    }
}
