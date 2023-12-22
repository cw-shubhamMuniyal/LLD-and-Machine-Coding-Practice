using Exceptions;

namespace Model.Parking.Strategy
{

  /**
   * Parking strategy in which the natural ordering numbers are used for deciding the slot numbers.
   * For example, 1st car will be parked in slot 1, then next in slot 2, then in slot 3, and so on.
   */
  public class NaturalOrderingParkingStrategy : ParkingStrategy
  {
    SortedSet<int> SlotSet;

    public NaturalOrderingParkingStrategy()
    {
      this.SlotSet = new SortedSet<int>();
    }

    /**
     * {@inheritDoc}
     */
    public void AddSlot(int slotNumber)
    {
      this.SlotSet.Add(slotNumber);
    }

    /**
     * {@inheritDoc}
     */
    public void RemoveSlot(int slotNumber)
    {
      this.SlotSet.Remove(slotNumber);
    }

    /**
     * {@inheritDoc}
     */
    public int GetNextSlot()
    {
      if (SlotSet.Count == 0)
      {
        throw new NoFreeSlotAvailableException();
      }
      return this.SlotSet.First();
    }
  }
}