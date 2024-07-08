package ru.lisenkova.work;

import java.util.Objects;

public class Road implements Cloneable{
    private City destination;
    private int cost;


    public Road(City destination, int cost)
    {
        this.destination=destination;
        this.cost=cost;
    }
    public City getDestination()
    {
        return destination;
    }
    public int getCost()
    {
        return cost;
    }
    public void setCost(int cost)
    {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Road road = (Road) o;
        return cost == road.cost && Objects.equals(destination, road.destination);
    }

    @Override
    protected Object clone()  {
        try {
            Road res = (Road) super.clone();
            return res;
        }
        catch (CloneNotSupportedException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(destination, cost);
    }
}
