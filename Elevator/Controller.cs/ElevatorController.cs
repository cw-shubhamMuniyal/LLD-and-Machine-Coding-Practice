using System;
using System.Collections.Generic;
using Elevator.Logic;
using Elevator.Modal;

public class ElevatorController
{
    private PriorityQueue<int> upMinPQ;
    private PriorityQueue<int> downMaxPQ;
    public ElevatorCar elevatorCar;

    public ElevatorController(ElevatorCar elevatorCar)
    {
        this.elevatorCar = elevatorCar;
        upMinPQ = new PriorityQueue<int>((a, b) => a - b);    // ascending order
        downMaxPQ = new PriorityQueue<int>((a, b) => b - a);  // descending order
    }

    public void SubmitExternalRequest(int floor, Direction direction)
    {
        if (direction == Direction.Down)
        {
            downMaxPQ.Offer(floor);
        }
        else
        {
            upMinPQ.Offer(floor);
        }
    }

    public void SubmitInternalRequest(int floor)
    {
        // Implement internal request handling
    }

    public void ControlElevator()
    {
        while (true)
        {
            if (elevatorCar._elevatorDirection == Direction.Up)
            {
                // Implement logic for elevator going up
            }
            // Add logic for handling elevator going down and other conditions
        }
    }
}

// PriorityQueue implementation for C#
public class PriorityQueue<T>
{
    private readonly List<T> data;
    private readonly Comparison<T> comparison;

    public PriorityQueue(Comparison<T> comparison)
    {
        this.data = new List<T>();
        this.comparison = comparison;
    }

    public void Offer(T item)
    {
        data.Add(item);
        data.Sort(comparison);
    }

    // Add other methods as needed for your PriorityQueue
}
