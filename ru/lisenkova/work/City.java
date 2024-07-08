package ru.lisenkova.work;

import ru.lisenkova.geometry.Line;
import ru.lisenkova.math.Fraction;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class City implements Cloneable{
    private String name;
    private List<Road> roads = new ArrayList<>();
    public City(String name)
    {
        this.name = name;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass()!= obj.getClass()) return false;
        City city = (City) obj;
        return Objects.equals(name, city.name) && Objects.equals(roads, city.roads);
    }

    @Override
    public City clone()  {
        try {
            City res = (City) super.clone();
            res.roads = new ArrayList<>();
            for(int i=0;i<this.roads.size();i++)
            {
                res.roads.add((Road) this.roads.get(i).clone());
            }
            return res;
        }
        catch (CloneNotSupportedException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, roads);
    }

    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }
    public City addRoad(Road r1)
    {
        for (Road road : roads) {
            if (road.getDestination() == r1.getDestination())
                road.setCost(r1.getCost());
            return this;

        }
        roads.add(r1);
        return this;
    }
    public City removeRoad(City r1)
    {
        for(Road road:roads)
        {
            if(road.getDestination() == r1) {
                roads.remove(road);
                return this;
            }
        }
        return this;
    }

    public List<Road> getRoads() {
        return new ArrayList<>(roads);
    }
}
